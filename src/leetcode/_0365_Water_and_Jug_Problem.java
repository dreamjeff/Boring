package leetcode;
import common.Go;

public class _0365_Water_and_Jug_Problem implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public boolean canMeasureWater(int x, int y, int z) {
        //ax+by=z => z=gcd(x,y);
        return z==0 || (x+y>=z && z%gcd(x,y)==0);
    }
    
    private int gcd(int x, int y){
        return y==0? x : gcd(y, x%y);
    }
}
