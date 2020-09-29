package forward.somethingTry;

/**
 * TODO
 *
 * @author Redamancy@浮生若梦
 * @version 1.0
 * @date 2020/9/7 - 13:40
 * @since jdk 1.8
 * 算法练习之买卖股票最佳时机
 */
public class day_02 {
    /**
     * 给定一个数组，他的第 i 个元素是某股票第一天的价格
     * 如果你最多只允许完成一笔交易
     * 即买入和卖出一只股票一次
     * 设计一个算法来计算你能获取的最大利润
     * 注意：不能买入前 卖出
     *输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     *
     * 记录【今天之前买入的最小值】
     * 计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
     * 比较【每天的最大获利】，取最大值即可
     */
    //记录第几天卖出
    public static int date;
    /**
     * 计算卖出股票的最佳日期
     * @param prices 原始数组
     * @return 最佳卖出的日期--数组第几个元素(从1开始)
     */
    public static int maxProfit(int[] prices){
        int L = prices.length;
        if(L == 0){
            return 0;
        }
        //min表示当前位置之前的最小值
        int min = prices[0];
        //maxProfit表示当前位置之前的最大利润
        int maxProfit = 0;
        for(int i = 1;i < L;++i){
            /**
             *prices[i]-min :当前位置抛售可获得的最大利润
             *注意只能是当天减去之前的 min ，而不能 之前的 减去当天
             * 例如 20 1 7
             * 最大是 7 - 1，而不是 1 - 20
             */
            maxProfit = Math.max(maxProfit,prices[i]-min);
            min = Math.min(prices[i],min);
            date=i+1;
        }
        return maxProfit;
    }



    public static void main(String[] args) {
        int money = maxProfit(new int[]{26,4,12,8,16,89,12});
        System.out.println("在第 "+date+"天卖出利润最大，可赚 "+money+" 万元！！");
    }
}
