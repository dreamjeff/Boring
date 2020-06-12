package leetcode;

import common.Go;

public class _0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, preBuy=0, sell=0, preSell=0;
        for(int i=0; i<prices.length; i++){
            preBuy = buy;
            buy = Math.max(preSell-prices[i], preBuy);
            preSell = sell;
            sell = Math.max(preBuy+prices[i], preSell);
        }
        return Math.max(buy,sell);
    }
}
