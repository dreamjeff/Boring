package leetcode;

import common.Go;

public class _0345_Reverse_Vowels_of_a_String implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int i=0, j=s.length()-1;
        while(i<j){
            while(i<j && !isVowels(c[i])) i++;
            while(i<j && !isVowels(c[j])) j--;
            if(i<j){
                char t = c[i];
                c[i] = c[j];
                c[j] = t;
                i++;
                j--;
            }
        }
        return String.valueOf(c);
    }
    
    private boolean isVowels(char c){
        c = Character.toUpperCase(c);
        if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
            return true;
        }
        return false;
    }
}
