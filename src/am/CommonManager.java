package am;

import java.util.*;

import common.Go;

public class CommonManager implements Go {

	
	/**/
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Employee e1 = new Employee(1);
		Employee e2 = new Employee(2);
		Employee e3 = new Employee(3);
		Employee e4 = new Employee(4);
		Employee e5 = new Employee(5);
		Employee e6 = new Employee(6);
		Employee e7 = new Employee(7);
		Employee e8 = new Employee(8);
		e2.manage.add(e4);
		e2.manage.add(e5);
		e2.manage.add(e6);
		e3.manage.add(e7);
		e3.manage.add(e8);
		e1.manage.add(e2);
		e1.manage.add(e3);
		Employee manager = findCommonManager(6,4,e1);
		System.out.println("Traditional : " + (manager == null ? -1 : manager.number));
		System.out.println();
		System.out.println("N-ray Tree : " + findCommonManager2(6,4,e1));
	}

	private boolean canFindE1, canFindE2;
	
	public Employee findCommonManager(int e1, int e2, Employee ceo) {
		System.out.println("findCommonManager:");
		Employee manager = dfs(ceo, e1, e2);
		if(canFindE1 && canFindE2) {
			if(manager.number == 1) {
				System.out.println("Manager is CEO.");
				return null;
			}else {
				return manager;
			}
		}else {
			System.out.println("Employee not found.");
			return null;
		}
	}
	
	private Employee dfs(Employee manager, int e1, int e2) {
		if(manager == null) return manager;
		if(manager.number == e1) {
			this.canFindE1 = true;
			return manager;
		}
		if(manager.number == e2) {
			this.canFindE2 = true;
			return manager;
		}
		List<Employee> list = new ArrayList<Employee>();
		for(Employee employee : manager.manage) {
			Employee find = dfs(employee, e1, e2);
			if(find!=null) list.add(find);
			if(list.size() == 2) return manager;
		}
		if(list.size() == 1) return list.get(0);
		return null;
	}
	
	public int findCommonManager2(int e1, int e2, Employee ceo) {
		System.out.println("findCommonManager2:");
		List<Integer> dfsList = new ArrayList<Integer>();
		List<Integer> levelList = new ArrayList<Integer>();
		dfs(ceo, dfsList, levelList, 0);
		showList(dfsList);
		showList(levelList);
		int indexE1 = dfsList.indexOf(e1), indexE2 = dfsList.indexOf(e2);
		if(indexE1 > indexE2) {
			int tmp = indexE1;
			indexE1 = indexE2;
			indexE2 = tmp;
		}
		int indexRes = Integer.MAX_VALUE;
		for(int i = indexE1; i <= indexE2; i++) {
			indexRes = Math.min(indexRes, levelList.get(i));
		}
		return dfsList.get(indexRes);
	}
	
	private void showList(List<Integer> list) {
		for(Integer i : list) {
			System.out.print(i + ",");
		}
		System.out.println();
	}
	
	private void dfs(Employee manager, List<Integer> dfsList, List<Integer> levelList, int level) {
		dfsList.add(manager.number);
		levelList.add(level);
		for(Employee employee : manager.manage) {
			dfs(employee, dfsList, levelList, level+1);
			dfsList.add(manager.number);
			levelList.add(level);
		}
	}
	
	private class Employee{
		int number;
		public List<Employee> manage = new ArrayList<Employee>();
		public Employee(int val) {
			this.number = val;
		}
	}
}
