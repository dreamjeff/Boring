package micro;

import java.util.*;

import common.Go;

public class Min_Deletions_to_Make_Frequency_of_Each_Letter_Unique implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		��һ���ַ�����������ɾ�����ٸ��ַ����ַ��������ÿ���ַ����ֵĴ�������unique��
//		�ַ�����ɾ��0�����򲻼���ͳ��
//		input: aaabbbcccd
//		output: 4  (����1��ɾ����ʽ�ǵõ��Ľ����aaabbc��
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
