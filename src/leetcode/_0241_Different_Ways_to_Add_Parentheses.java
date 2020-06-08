package leetcode;

import common.Go;
import java.util.*;

public class _0241_Different_Ways_to_Add_Parentheses implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    HashMap<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input);
        List<Integer> res = new LinkedList<>();
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
                for(int x=0; x<left.size(); x++){
                    for(int y=0; y<right.size(); y++){
                        if(input.charAt(i)=='+') res.add(left.get(x)+right.get(y));
                        else if(input.charAt(i)=='-') res.add(left.get(x)-right.get(y));
                        else res.add(left.get(x)*right.get(y));//*
                    }
                }
            }
        }
        if(res.size()==0){
            res.add(Integer.valueOf(input));
        }
        map.put(input, res);
        return res;
    }
	
}
