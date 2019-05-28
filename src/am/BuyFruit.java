package am;

import java.util.*;

import common.Go;

public class BuyFruit implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<List<String>> codeList = new ArrayList<List<String>>();
		List<String> code = new ArrayList<String>();
		code.add("apple");
		code.add("apple");
		codeList.add(new ArrayList<String>(code));
		code.clear();
		//code.add("orange");
		code.add("anything");
		code.add("orange");
		codeList.add(new ArrayList<String>(code));
		List<String> shoppingCart = new ArrayList<String>();
		shoppingCart.add("orange");
		shoppingCart.add("apple");
		shoppingCart.add("apple");
		shoppingCart.add("orange");
		shoppingCart.add("banana");
		shoppingCart.add("orange");
		System.out.println(canBuy(codeList, shoppingCart));
	}

	public int canBuy(List<List<String>> codeList, List<String> shoppingCart) {
		return canBuy(codeList, shoppingCart, 0, 0);
	}
	
	private int canBuy(List<List<String>> codeList, List<String> shoppingCart, int index, int level) {
		System.out.println("level:" + level);
		if(level == codeList.size()) return 1;
		List<String> cur = codeList.get(level);
		for(int i = index; i < shoppingCart.size(); i++) {
			if(canMatch(cur, shoppingCart, i)) {
				int sub = canBuy(codeList, shoppingCart, i + cur.size(), level+1);
				if(sub == 1) return 1;
			}
		}
		return 0;
	}
	
	private boolean canMatch(List<String> code, List<String> shoppingCart, int index) {
		System.out.print("canMatch:" + index);
		int j = 0;
		while(j < code.size() && index+j < shoppingCart.size()) {
			if(code.get(j) == shoppingCart.get(index + j) || code.get(j) == "anything") {
				j++;
			}else {
				break;
			}
		}
		if(j == code.size()) {
			System.out.println(" :true");
			return true;
		}else {
			System.out.println(" :false");
			return false;
		}

	}
}
