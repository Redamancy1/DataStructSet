package forward.somethingTry;

/**
 * TODO
 *
 * @author Redamancy@浮生若梦
 * @version 1.0
 * @date 2020/9/7 - 21:47
 * @since jdk 1.8
 * 算法练习之最长回文子串
 * 回文子串：即正反念都一样，121,434，aba,bab,1234321
 */
public class day_03 {
    /**
     *给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     *
     * 动态规划，用boolean[][] dp记录每一对字符是否相等；
     * 双循环遍历所有子串情况，每次遍历时，当前子串首尾相等且内层-1字符串dp值为true，则记录dp值为true；全部遍历完，取最长，即为最长子串；
     * 临界条件很复杂，最好在循环之前把长度小于2的情况剔除；条件中有一个i-j<3，因为小于3且首尾相等的子串一定是回文串，不需要再往内层再判断dp。
     */
    public static String longestPalindrome(String s) {

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int i,j,max=0,m=0,n=0;
        if(len<2){
            return s;
        }
        for(i=0;i<len;++i){
            for(j=0;j<=i;++j){
                if(s.charAt(i) == s.charAt(j)&&(i-j<3||dp[j+1][i-1])){
                    dp[j][i]=true;
                    if(i-j>max){
                        max = i-j;
                        m=j;n=i;
                    }
                }else{
                    dp[j][i]=false;
                }
            }
        }
        return s.substring(m,n+1);
    }


    public static void main(String[] args) {
        String s = longestPalindrome("asksfskbkbkbk");
        System.out.print(s);

    }
}

//暴力法
 class Solution {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        String res = s.substring(0, 1);

        // 枚举所有长度大于等于 2 的子串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && valid(s, i, j)) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private boolean valid(String s, int left, int right) {
        // 验证子串 s[left, right] 是否为回文串
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
