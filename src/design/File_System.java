package design;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

public class File_System {
	  public static void main(String[] args) throws IOException {
		    Executor exec = new ExecutionGenerator().generateExecutor(args);
		    exec.Execute();
		  }
}

////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////// ִ���� ////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
class Executor {
private Path startPath;
private ArrayList<Option> options;
private Predicate filterPredicate;
private ArrayList<Action> actions;
private ExecutionContext context;

// ����������Java�����ṩ��Files.walkFileTree()�����Լ�FileVisitor�ص��ӿ�
// �ο�����Ľ��ܣ�[url]https://docs.oracle.com/javase/tutorial/essential/io/walk.html[/url]
private class NodeVistor implements FileVisitor<Path> {
private FileVisitResult visitFileOrDirectory(Path fileOrDir, BasicFileAttributes attr) {
// ����ǲ���Symbolic link
if (attr.isSymbolicLink() && !context.shouldFollowSymbolicLink()) {
return FileVisitResult.SKIP_SUBTREE;
}
context.setFilePath(fileOrDir);
context.setBasicFileAttributes(attr);
// ν�ʣ�predicate������SQL��where��䣩��ֵ
// ���ֵΪfalse�Ļ���ʾ��ǰ�ļ��������û��趨�Ĺ�����������ô������ǰ�ļ�
if (filterPredicate != null && !filterPredicate.evaluate(context)) {
return FileVisitResult.CONTINUE;
}
// ����������������ȴ�ӡ��ǰ·��
System.out.println(fileOrDir.toString());
// Ȼ��ִ������actions
for (Action action : actions) {
action.invoke(context);
}
return FileVisitResult.CONTINUE;
}

// ����ÿһ���ļ�ʱ�Ļص�
@Override
public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
return visitFileOrDirectory(file, attrs);
}
// ����ÿһ��Ŀ¼֮ǰ�Ļص�
@Override
public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
return visitFileOrDirectory(dir, attrs);
}
// ����ÿһ��Ŀ¼֮��Ļص�
@Override
public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
return FileVisitResult.CONTINUE;
}
// ��������ʱ�Ļص�
@Override
public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
return FileVisitResult.CONTINUE;
}
}

// ���캯��
public Executor(Path startPath, ArrayList<Option> options,
Predicate filterPredicate, ArrayList<Action> actions) {
this.startPath = startPath;
this.options = options;
this.filterPredicate = filterPredicate;
this.actions = actions;
}

public void Execute() throws IOException {
context = new ExecutionContext();
// ������options��ʼ��context������maxdepth������
for (Option option : options) {
option.setup(context);
}
// Ȼ���ʼ��actions�����������ļ���
for (Action action : actions) {
action.initialize();
}
// Walk file tree������NodeVistor����ص�
Files.walkFileTree(startPath, EnumSet.of(FileVisitOption.FOLLOW_LINKS),
context.getMaxDepth(), new NodeVistor());
// actions����ᴦ������flush���ر�����ļ���
for (Action action : actions) {
action.finalize();
}
}
}

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////ִ�������� //////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
class ExecutionContext {
// Options
private int maxDepth = Integer.MAX_VALUE;
private boolean followSymbolicLink = false;

// Runtime attributes
private Path filePath;
private BasicFileAttributes fileAttr;

// Getters and setters
public void setMaxDepth(int maxDepth) {
this.maxDepth = maxDepth;
}
public int getMaxDepth() {
return maxDepth;
}
public void setFollowSymbolicLink() {
followSymbolicLink = true;
}
public boolean shouldFollowSymbolicLink() {
return followSymbolicLink;
}
public void setFilePath(Path filePath) {
this.filePath = filePath;
}
public Path getFilePath() {
return filePath;
}
public void setBasicFileAttributes(BasicFileAttributes fileAttr) {
this.fileAttr = fileAttr;
}
public BasicFileAttributes getBasicFileAttributes() {
return fileAttr;
}
}

////////////////////////////////////////////////////////////////////////////////
/////////////////////////////// ��������������ִ���� //////////////////////////////
////////////////////////////////////////////////////////////////////////////////
class ExecutionGenerator {
private static Map<String, OptionParser> optionParserRegistry = new HashMap<>();

private static void Register(OptionParser parser) {
optionParserRegistry.put(parser.getName(), parser);
}

// ������ע�����е�OptionParser����
static {
Register(new MaxDepthOptionParser());
Register(new FollowSymbolicLinkOptionParser());
Register(new FileTypeFilterParser());
Register(new FileNameFilterParser());
Register(new FileSizeFilterParser());
Register(new WriteToFileActionParser());
}

private Stack<String> tokens;

// �����������������ִ����
// ���������һ�����׵�LL(1) recursive descent parser
public Executor generateExecutor(String[] args) {
tokens = new Stack<String>();
for (int i = args.length - 1; i >= 0; --i) {
tokens.push(args[i]);
}

if (tokens.empty()) {
throw new RuntimeException("Requires at least one path argument");
}
final Path filePath = Paths.get(tokens.pop());

ArrayList<Option> options = new ArrayList<>();
ArrayList<Predicate> predicates = new ArrayList<>();
ArrayList<Action> actions = new ArrayList<>();

while (!tokens.empty()) {
PlanNode node = parseOr();
switch (node.getKind()) {
case OPTION: options.add((Option)node); break;
case PREDICATE: predicates.add((Predicate)node); break;
case ACTION: actions.add((Action)node); break;
default:
throw new RuntimeException("Unsupport enum value " + node.getKind().name());
}
}

Predicate filterPredicate = null;
if (predicates.size() == 1) {
filterPredicate = predicates.get(0);
} else if (predicates.size() > 1) {
filterPredicate = new LogicalAnd(predicates);
}

tokens = null;
return new Executor(filePath, options, filterPredicate, actions);
}

// ���� "... -or ..." ����������
private PlanNode parseOr() {
ArrayList<PlanNode> operands = new ArrayList<>();
operands.add(parseAnd());
while (nextTokenIs("-or") || nextTokenIs("-o")) {
tokens.pop();
operands.add(parseAnd());
}
if (operands.size() == 1) {
return operands.get(0);
}
ArrayList<Predicate> predicates = new ArrayList<>();
for (PlanNode node : operands) {
if (node.getKind() != PlanNodeKind.PREDICATE) {
throw new RuntimeException("Logical OR can only be applied to predicates");
}
predicates.add((Predicate)node);
}
return new LogicalOr(predicates);
}

// ���� "... -and ..." ����������
private PlanNode parseAnd() {
ArrayList<PlanNode> operands = new ArrayList<>();
operands.add(parseNot());
while (nextTokenIs("-and") || nextTokenIs("-a")) {
tokens.pop();
operands.add(parseNot());
}
if (operands.size() == 1) {
return operands.get(0);
}
ArrayList<Predicate> predicates = new ArrayList<>();
for (PlanNode node : operands) {
if (node.getKind() != PlanNodeKind.PREDICATE) {
throw new RuntimeException("Logical AND can only be applied to predicates");
}
predicates.add((Predicate)node);
}
return new LogicalAnd(predicates);
}

// ���� "-not ..." ����������
private PlanNode parseNot() {
boolean negate = false;
if (nextTokenIs("-not") || nextTokenIs("-n")) {
tokens.pop();
negate = true;
}
PlanNode operand = parseAtom();
if (!negate) {
return operand;
}
if (operand.getKind() != PlanNodeKind.PREDICATE) {
throw new RuntimeException("Logical NOT can only be applied to a predicate");
}
return new LogicalNot((Predicate)operand);
}

// �������ű��ʽ "( ... )" �����ǻ����� Option / Filter / Action
private PlanNode parseAtom() {
if (nextTokenIs("(")) {
tokens.pop();
PlanNode node = parseOr();
if (!nextTokenIs(")")) {
throw new RuntimeException("Unmatched parenthesis");
}
tokens.pop();
return node;
}
if (tokens.isEmpty()) {
throw new RuntimeException("Unexpected end of input stream");
}
if (!tokens.peek().startsWith("-")) {
throw new RuntimeException("Unexpected token " + tokens.peek());
}
// ���name���ǲ�����������-type��"type"��-size��"size"
final String name = tokens.pop().substring(1);
// ��registry���ҵ����������Ӧ��parser
final OptionParser parser = optionParserRegistry.get(name);
if (parser == null) {
throw new RuntimeException("Unrecognized option " + name);
}
// Parser���Ե�parse()�������ڽ���������arguments
// ���� -size +1M����ô"size"����Ӧ��parserӦ��֪����ν���"+1M"
return parser.parse(tokens);
}

private boolean nextTokenIs(String value) {
return !tokens.isEmpty() && value.equals(tokens.peek());
}
}

////////////////////////////////////////////////////////////////////////////////
//////////////////////Option/ Predicate / Action �ĳ��� ////////////////////////
////////////////////////////////////////////////////////////////////////////////

//�����OOP��ƱȽ���Ҫ�Ĳ���

enum PlanNodeKind {
OPTION, PREDICATE, ACTION
}

//Option/Predicate/Action�Ļ���
abstract class PlanNode {
public abstract PlanNodeKind getKind();
}

//�̳�����������һ���µ�Option
abstract class Option extends PlanNode {
// ÿ��Option��Ҫʵ��setup()����������ExecutionContext
public abstract void setup(ExecutionContext context);
@Override
public PlanNodeKind getKind() {
return PlanNodeKind.OPTION;
}
}

//�̳�����������һ���µ�Predicate
abstract class Predicate extends PlanNode {
// ÿ��Predicate��Ҫʵ��evaluate()�����Թ��˵�ǰ���ʵ��ļ���Ŀ¼
public abstract boolean evaluate(ExecutionContext context);
@Override
public PlanNodeKind getKind() {
return PlanNodeKind.PREDICATE;
}
}

//�̳�����������һ���µ�Action
abstract class Action extends PlanNode {
// ÿ��Action��Ҫʵ��invoke()��������Ե�ǰ���ʵ��ļ���Ŀ¼������Ӧ����
public abstract void invoke(ExecutionContext context);
public void initialize() {}
public void finalize() {}
@Override
public PlanNodeKind getKind() {
return PlanNodeKind.ACTION;
}
}

//FilterҲ����GNU find�ٷ��ĵ�����˵��"tests"
//���磺
//-name a.txt
//-size +1MB
//-type f
//��Щ����Filter
//�̳�����������һ���µ�Filter
abstract class Filter extends Predicate {}

//Option/Filter/Action�Ľ���������
abstract class OptionParser {
// �ý�����������Ĳ�����������"maxdepth"��"type"��"size"
public abstract String getName();
// �����߼���ʵ��
public abstract PlanNode parse(Stack<String> args);
}

////////////////////////////////////////////////////////////////////////////////
///////////////////// �߼������ And/Or/Not (��/��/��) ��ʵ�� //////////////////////
////////////////////////////////////////////////////////////////////////////////

//�߼����롱
class LogicalAnd extends Predicate {
private ArrayList<Predicate> operands;
public LogicalAnd(ArrayList<Predicate> operands) {
this.operands = operands;
}
// ���롱��������true���ҽ���������ν�ʶ�����true
@Override
public boolean evaluate(ExecutionContext context) {
for (final Predicate operand : operands) {
if (!operand.evaluate(context)) {
return false;
}
}
return true;
}
}

//�߼�����
class LogicalOr extends Predicate {
private ArrayList<Predicate> operands;
public LogicalOr(ArrayList<Predicate> operands) {
this.operands = operands;
}
// ���򡱲�������true���ҽ�������һ����ν�ʷ���true
@Override
public boolean evaluate(ExecutionContext context) {
for (final Predicate operand : operands) {
if (operand.evaluate(context)) {
return true;
}
}
return false;
}
}

//�߼����ǡ�
class LogicalNot extends Predicate {
private Predicate operand;
public LogicalNot(Predicate operand) {
this.operand = operand;
}
// ���ǡ���������true���ҽ�����ν�ʷ���false
@Override
public boolean evaluate(ExecutionContext context) {
return !operand.evaluate(context);
}
}

////////////////////////////////////////////////////////////////////////////////
////////////////////////Option/ Filter / Action ������ /////////////////////////
////////////////////////////////////////////////////////////////////////////////

//���һ���µ�Filter / Action�󲿷������ֻ��Ҫ�̳в�ʵ����Ӧ�Ļ����Լ�OptionParser����
//���һ���µ�Option���ܻ���Ҫ�޸�ExecutionContext����Executor������Ӧ�޸�

//����ʱ�������ȣ����磺
//-maxdepth 10
class MaxDepthOption extends Option {
private int maxDepth;
public MaxDepthOption(int maxDepth) {
this.maxDepth = maxDepth;
}
@Override
public void setup(ExecutionContext context) {
context.setMaxDepth(maxDepth);
}
}
class MaxDepthOptionParser extends OptionParser {
@Override
public String getName() {
return "maxdepth";
}

@Override
public PlanNode parse(Stack<String> args) {
return new MaxDepthOption(Integer.parseInt(args.pop()));
}
}

//�Ƿ���symbolic link��
//-L
class FollowSymbolicLinkOption extends Option {
@Override
public void setup(ExecutionContext context) {
context.setFollowSymbolicLink();
}
}
class FollowSymbolicLinkOptionParser extends OptionParser {
@Override
public String getName() {
return "L";
}
@Override
public PlanNode parse(Stack<String> args) {
return new FollowSymbolicLinkOption();
}
}

//�趨���ҵ����ļ�����Ŀ¼�����磺
//-type f
//-type d
class FileTypeFilter extends Filter {
public enum FileType {
DIRECTORY, FILE
}
private FileType targetFileType;
public FileTypeFilter(FileType targetFileType) {
this.targetFileType = targetFileType;
}
@Override
public boolean evaluate(ExecutionContext context) {
switch (targetFileType) {
case FILE:
return context.getBasicFileAttributes().isRegularFile();
case DIRECTORY:
return context.getBasicFileAttributes().isDirectory();
}
throw new RuntimeException("Unsupported enum value: " + targetFileType.name());
}
}
class FileTypeFilterParser extends OptionParser {
@Override
public String getName() {
return "type";
}
@Override
public PlanNode parse(Stack<String> args) {
final String param = args.pop();
switch (param) {
case "f":
return new FileTypeFilter(FileTypeFilter.FileType.FILE);
case "d":
return new FileTypeFilter(FileTypeFilter.FileType.DIRECTORY);
}
throw new RuntimeException("Unsupport file type: " + param);
}
}

//�趨�ļ���glob pattern�����磺
//-name a.txt
//-name \*.txt
//-name \*data\*.txt
//ע���������²���ֱ��д-name *.txt������glob���*.txtչ��Ϊ��ǰĿ¼�µ�����match���ļ�
class FileNameFilter extends Filter {
private PathMatcher pathMatcher;
public FileNameFilter(PathMatcher pathMatcher) {
this.pathMatcher = pathMatcher;
}
@Override
public boolean evaluate(ExecutionContext context) {
final Path filePath = context.getFilePath();
return pathMatcher.matches(filePath) ||
pathMatcher.matches(filePath.getFileName());
}
}
class FileNameFilterParser extends OptionParser {
@Override
public String getName() {
return "name";
}
@Override
public PlanNode parse(Stack<String> args) {
return new FileNameFilter(FileSystems.getDefault().getPathMatcher("glob:" + args.pop()));
}
}

//�����ļ�size�����磺
//-size 1MB
//-size +1KB
//-size -1GB
class FileSizeFilter extends Filter {
public enum OpType {
EQUAL, GREATER_EQUAL, LESS_EQUAL
}

private long targetFileSize;
private OpType op;

public FileSizeFilter(OpType op, long targetFileSize) {
this.op = op;
this.targetFileSize = targetFileSize;
}
@Override
public boolean evaluate(ExecutionContext context) {
long fileSize = context.getBasicFileAttributes().size();
switch (op) {
case EQUAL:
return fileSize == targetFileSize;
case GREATER_EQUAL:
return fileSize >= targetFileSize;
case LESS_EQUAL:
return fileSize <= targetFileSize;
}
throw new RuntimeException("Unsupported enum value: " + op.name());
}
}
class FileSizeFilterParser extends OptionParser {
@Override
public String getName() {
return "size";
}
@Override
public PlanNode parse(Stack<String> args) {
String param = args.pop();
FileSizeFilter.OpType op = FileSizeFilter.OpType.EQUAL;
int digitStart = 0;
if (param.startsWith("+")) {
op = FileSizeFilter.OpType.GREATER_EQUAL;
digitStart = 1;
} else if (param.startsWith("-")) {
op = FileSizeFilter.OpType.LESS_EQUAL;
digitStart = 1;
}
int digitEnd = digitStart;
while (digitEnd < param.length() && Character.isDigit(param.charAt(digitEnd))) {
++digitEnd;
}
if (digitEnd == digitStart) {
throw new RuntimeException("Invalid file size specification: " + param);
}
long targetFileSize = Long.parseLong(param.substring(digitStart, digitEnd));
if (digitEnd != param.length()) {
final String unit = param.substring(digitEnd);
switch (unit.toLowerCase()) {
case "k":
case "kb":
targetFileSize *= 1024;
break;
case "m":
case "mb":
targetFileSize *= 1024 * 1024;
break;
case "g":
case "gb":
targetFileSize *= 1024 * 1024 * 1024;
break;
default:
throw new RuntimeException("Invalid file size unit: " + unit);
}
}
return new FileSizeFilter(op, targetFileSize);
}
}

//�����д��ĳ���ļ��У����磺
//-writetofile output.txt
class WriteToFileAction extends Action {
private String fileName;
private PrintWriter pw;
public WriteToFileAction(String fileName) {
this.fileName = fileName;
}
@Override
public void initialize() {
try {
pw = new PrintWriter(fileName);
} catch (FileNotFoundException e) {
throw new RuntimeException(e);
}
}
@Override
public void finalize() {
pw.close();
}
@Override
public void invoke(ExecutionContext context) {
pw.println(context.getFilePath());
}
}
class WriteToFileActionParser extends OptionParser {
@Override
public String getName() {
return "writetofile";
}
@Override
public PlanNode parse(Stack<String> args) {
return new WriteToFileAction(args.pop());
}
}