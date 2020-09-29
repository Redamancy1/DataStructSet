package forward.somethingTry;

/**
 * TODO
 *
 * @author Redamancy@浮生若梦
 * @version 1.0
 * @date 2020/9/7 - 14:01
 * @since jdk 1.8
 * 算法练习之买卖股票最佳时机 含冷冻期
 * 此题目，未有最优解法
 */
public class day_02_2 {
    /**
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
     *
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     *
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     *输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     *
     * 思想：
     * 注意状态是指每一天结束时的状态。
     * 三种状态：无操作(冷冻或不持股)，刚卖出，持股（买入）。
     * 如果前一天“无操作”，今天可选择买入或不买入，分别转化为“持股”和“无操作”；
     * 如果前一天“刚卖出”，今天必须进入冷冻，即转化为“无操作”状态；
     * 如果前一天“持股”，今天可选择卖出或不卖出，分别可转化为“刚卖出”和“持股”；
     * 这样状态转移方程就可以写出来了：
     *
     * dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
     * dp[i][1] = dp[i-1][2] + prices[i];
     * dp[i][2] = Math.max(dp[i-1][2],dp[i-1][0] - prices[i]);
     */
    public static int maxProfit(int[] prices){
        if(prices.length==0){
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] lock = new int[prices.length];
        for(int i = 0;i < prices.length;i++){
            buy[i] = Integer.MIN_VALUE;
        }
        for(int i = 0;i < prices.length;i++){
            if(i==0){
                //第一天只要买入就是亏钱
                buy[i] = -prices[i];
            }else{
                //其中buy[i-1]表示截至昨天最后一个操作是买入且今天啥也不干
                // lock[i-1] - prices[i]表示截至昨天最后一个操作是冷冻且今天买入
                //比较两次买入操作哪次 花费较少（买入是负数，哪个大表示低价买入）
                buy[i] = Math.max(buy[i-1],lock[i-1]-prices[i]);
                //用今天的价钱去抵消前一天的亏损（即买入所用费用）
                sell[i] = buy[i-1] + prices[i];
                //当天冻结带来的收益
                //即比较如果前一天不操作，跟前一天卖出收益大
                lock[i] = Math.max(lock[i-1],sell[i-1]);
            }
        }
        //其中buy[i-1]表示截至昨天最后一个操作是买入且今天啥也不干
        //即直到最后前一天买入且今天不做操作
        int result = buy[prices.length - 1];
        //判断今天卖出 跟 不操作哪个收益大
        if(sell[prices.length-1] > result){
            result = sell[prices.length-1];
        }
        //判断在上面比较中的收益，今天如果不操作能否更不亏
        if(lock[prices.length-1] > result){
            result = lock[prices.length-1];
        }
        return result;
    }


    public static void main(String[] args) {
        int maxfit = maxProfit(new int[]{2,4,9,3,8,10});
        System.out.println(maxfit);
    }
}
