package am;

import java.util.Stack;

import common.Go;

public class Delete_Duplicate_Alphabet implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//"abccbd" => "ad"; "aabcd" =>bcd; "abcccc" => "ab"; "aabccdee" => "bd"
		System.out.println(deleteDuplicateAlphabet("aabccdee"));
	}

	private String deleteDuplicateAlphabet(String s) {
		Stack<Character> st = new Stack<>();
		int i=0;
		while(i<s.length()) {
			Character c = s.charAt(i);
			if(st.isEmpty()||st.peek()!=c) {
				st.add(c);
				i++;
			}else {
				while(i<s.length()&&s.charAt(i)==c) {
					i++;
				}
				st.pop();
			}
		}
		String res = "";
		while(!st.isEmpty()) {
			res = st.pop() + res;
		}
		return res;
	}

}
