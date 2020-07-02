import common.Go;

public class _0376_Wiggle_Subsequence implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;
        if(nums.length<2){
            return nums.length;
        }    
        if(nums.length==1) return 1;
        int preDiff=nums[1]-nums[0];
        int count = preDiff==0?1:2;
        for(int i=2; i<nums.length; i++){
            int curDiff=nums[i]-nums[i-1];
            if((preDiff>=0&&curDiff<0)||(preDiff<=0&&curDiff>0)){
                count++;
                preDiff=curDiff;
            }
        }

        return count;
    }
}
