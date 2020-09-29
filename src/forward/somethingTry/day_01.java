package forward.somethingTry;

/**
 * TODO
 *
 * @author Redamancy@浮生若梦
 * @version 1.0
 * @date 2020/9/7 - 13:22
 * @since jdk 1.8
 * 算法练习之爬楼梯
 */
public class day_01 {
    /**
     * 假设你正在爬楼梯，需要n阶才能到达楼顶
     * 每次可以爬 1 或 2 个台阶，问有多少种方法爬到楼顶
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     */
    //滚动数组法 O(n)
    public static int climbStaire1(int n){
        //r1 r2 分别代表当前位置的前两个数
        int r1 = 1,r2 = 2,res = n;
        for(int i = 3;i <= n;i++){
            res = r1 + r2;
            r1 = r2;
            r2 = res;
        }
        return res;
    }

    //自底向上动态规划法
    public static int climbStair2(int n){
        //存储每一个台阶的方法数
        int[] num = new int[n+1];
        //0号位是多余的，故数组要分配 n+1 项
        num[0] = 1;
        num[1] = 1;
        for(int i = 2;i <= n;++i){
            num[i] = num[i-1] + num[i-2];
        }
        return num[n];
    }

    public static void main(String[] args) {
        int result = climbStaire1(8);
        System.out.println(result);

        int result1 = climbStair2(2);
        System.out.print(result1);
    }

}
