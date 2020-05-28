package micro;

import common.Go;

public class Largest_alphabetically_order implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		1. ֻ�д�д��Сд��ĸ��ɣ�Ҫ�󷵻�һ����д��ĸ��which is the largest alphabetically order
//		and occurs both in lower and upper cases in the string��
//		����"aAbxeEX"��A��E�� X ���������⣬�� X ����ĸ��Ƚϴ����Է��� X��
		
//Given a string containing lowercase and uppercase letters.sort it in such a manner such that the uppercase and lowercase letter comes in an alternate manner but in sorted way.
//		Input : bAwutndekWEdkd
//		Output :AbEdWddekkntuw
//		Explanation:
//		Here we can see that letter ‘A’, ’E’, ’W’ are sorted 
//		as well as letters “b, d, d, d, e, k, k, n, t, u, w” are sorted 
//		but both appears alternately in the string as far as possible.
//
//		Input :abbfDDhGFBvdFDGBNDasZVDFjkb
//		Output :BaBaDbDbDbDdDfFhFjFkGsGvNVZ
		System.out.print(work("aAbxeEX"));
	}

	private char work(String s) {
		int diff = 'a'-'A';
		char res = 'A'-1;
		boolean[] chars = new boolean[128];
		for(char c : s.toCharArray()) {
			if(c<'a') {
				chars[c]=true;
				if(chars[c+diff]) {
					res = c>res?c:res;
				}
			}else {
				chars[c]=true;
				if(chars[c-diff]) {
					res = (c-diff)>res?(char)(c-diff):res;
				}
			}
		}
		return res;
	}
	
	private final static int MAX = 100; 
	
	public static String alternateSort(String s1) 
	{ 
	    int n = s1.length(); 
	  
	    char[] s = s1.toCharArray(); 
	  
	    // Count occurrences of  
	    // individual lower case and 
	    // upper case characters 
	    int[] lCount = new int[MAX]; 
	    int[] uCount = new int[MAX]; 
	  
	    for (int i = 0; i < n; i++) { 
	  
	        if (Character.isUpperCase(s[i])) 
	            uCount[s[i] - 'A']++; 
	        else
	            lCount[s[i] - 'a']++; 
	    } 
	  
	    // Traverse through count 
	    // arrays and one by one 
	    // pick characters.  
	    // Below loop takes O(n) time 
	    // considering the MAX is constant. 
	    int i = 0, j = 0, k = 0; 
	    while (k < n)  
	    { 
	  
	        while (i < MAX && uCount[i] == 0) 
	                i++; 
	  
	        if (i < MAX) { 
	                s[k++] = (char)('A' + i); 
	                uCount[i]--; 
	            } 
	  
	        while (j < MAX && lCount[j] == 0) 
	                j++; 
	  
	        if (j < MAX) { 
	                s[k++] = (char)('a' + j); 
	                lCount[j]--; 
	            } 
	        } 
	          
	        return (new String(s)); 
	    } 
}
