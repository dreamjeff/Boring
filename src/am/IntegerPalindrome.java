package am;

import common.Go;

public class IntegerPalindrome implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("IntegerIsPalindrome Not Cut 0 : " + isPalindromeNotCut0(27));
		System.out.println("IntegerIsPalindrome cut 0 : " + isPalindromeCut0(27));
	}

	public boolean isPalindromeNotCut0(int k) {
		String s = Integer.toBinaryString(k);
		System.out.println("Original string : " + s);
		if(s.length()!=32) {
			for(int i = 0; i < 32 - s.length(); i++) {
				s = "0" + s;
			}
		}
		System.out.println("New String : " + s);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length()/2; i++) {
			sb.append(s.charAt(s.length() - 1 - i));
		}
		String half = sb.toString();
		System.out.println(half);
		System.out.println(s.substring(0, s.length()/2));
		return s.substring(0, s.length()/2).equals(half);
	}
	
	public boolean isPalindromeCut0(int k) {
		String s = Integer.toBinaryString(k);
		System.out.println("Original string : " + s);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length()/2; i++) {
			sb.append(s.charAt(s.length() - 1 - i));
		}
		String half = sb.toString();
		System.out.println(half);
		System.out.println(s.substring(0, s.length()/2));
		return s.substring(0, s.length()/2).equals(half);
	}
}
