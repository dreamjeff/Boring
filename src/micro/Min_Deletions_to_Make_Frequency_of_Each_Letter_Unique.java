package micro;

import java.util.*;

import common.Go;

public class Min_Deletions_to_Make_Frequency_of_Each_Letter_Unique implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		给一个字符串，问最少删除多少个字符，字符串里面的每个字符出现的次数都是unique的
//		字符可以删到0个，则不计入统计
//		input: aaabbbcccd
//		output: 4  (其中1种删除方式是得到的结果是aaabbc）
		//Min Deletions to Make Frequency of Each Letter Unique
		//https://leetcode.com/discuss/interview-question/398035/
		System.out.print(work("example"));
	}

	private int work(String s) {
		int[] chars = new int[128];
		int count=0;
		for(char c : s.toCharArray()) {
			if(chars[c]==0) count++;
			chars[c]++;
		}
		int[] counts = new int[count];
		int i = 0;
		for(int j : chars) {
			if(j!=0) {
				counts[i]=j;
				i++;
			}
		}
		Arrays.sort(counts);
		count--;
		int res = 0, cur=counts[count];
		count--;
		for(int k=count; k>=0; k--) {
			if(cur==0) res+=counts[k];
			else if(counts[k]>=cur) {
				int temp = counts[k]-cur+1;
				cur = counts[k]-temp;
				res+=temp;
			}else {
				cur = counts[k];
			}
		}
		return res;
	}
}
