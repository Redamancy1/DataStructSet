package forward.somethingTry;

/**
 * TODO
 *
 * @author Redamancy@浮生若梦
 * @version 1.0
 * @date 2020/9/7 - 22:28
 * @since jdk 1.8
 * 算法练习之分割等和子集（背包）
 */
public class day_05 {
    /**
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * 注意:
     * 每个数组中的元素不会超过 100
     * 数组的大小不会超过 200
     *
     * 示例：
     * 输入: [1, 5, 11, 5]
     * 输出: true
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     */
    public static boolean canPartition(int[] nums){
        int sum = 0;
        //循环记录数组元素总和
        for(int item:nums){
            sum += item;
        }
        //判断总和是否为偶数能否被平分
        if(sum%2 != 0){
            return false;
        }
        //将总和平分
        sum /= 2;
        //dp[i]储存当时是否可以组成 和为 i
        boolean[] dp = new boolean[sum+1];
        //和为 0 始终可以
        dp[0] = true;
        for(int item:nums){
            for(int j=sum;j>=item;--j){
                dp[j] = dp[j] || dp[j-item];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        boolean result = canPartition(new int[]{1,3,4});
        System.out.println(result);

    }
}
