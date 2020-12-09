// 动态规划
// 昨天我唯唯诺诺，今天我重拳出击
class Solution {
    public int uniquePaths(int m, int n) {
        // 动态规划
        int[][] dp = new int[m][n];
        // 为0情况的判断
        for(int i = 0 ; i < m ; i++ ){
            dp[i][0] = 1;
        }
        for(int j = 0 ; j < n ; j++ ){
            dp[0][j] = 1;
        }
        for(int i = 1 ; i < m ; i ++){
            for(int j = 1 ; j < n ; j ++){
                // 动态转移方程
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
