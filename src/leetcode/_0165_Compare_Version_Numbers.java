package leetcode;

import common.Go;

public class _0165_Compare_Version_Numbers implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public int compareVersion(String version1, String version2) {
        if(version1.equals(version2)) return 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length = Math.min(v1.length, v2.length);
        int i;
        for(i=0; i<length; i++){
            int num1 = Integer.parseInt(v1[i]);
            int num2 = Integer.parseInt(v2[i]);
            if(num1>num2) return 1;
            if(num1<num2) return -1;
        }
        while(i<v1.length){
            if(Integer.parseInt(v1[i++])>0){
                return 1;
            }
        }
        while(i<v2.length){
            if(Integer.parseInt(v2[i++])>0){
                return -1;
            }
        }
        return 0;
    }
}
