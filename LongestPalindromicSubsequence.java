import java.lang.Math;

class LongestPalindromicSubsequence {
    int[][] dp;
    String str;

    public LongestPalindromicSubsequence(int n, String str) {
        this.dp = new int[n][n];
        this.str = str;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                this.dp[i][j] = -1;
    }

    private int computeDP(int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            dp[leftIndex][rightIndex] = 1;
            return dp[leftIndex][rightIndex];
        }

        if (leftIndex > rightIndex)
            return 0;

        if (dp[leftIndex][rightIndex] != -1)
            return dp[leftIndex][rightIndex];

        int len1 = this.computeDP(leftIndex + 1, rightIndex);
        int len2 = this.computeDP(leftIndex, rightIndex - 1);
        int len3 = 0;

        if (this.str.charAt(leftIndex) == this.str.charAt(rightIndex))
            len3 = 2 + this.computeDP(leftIndex + 1, rightIndex - 1);
        
        dp[leftIndex][rightIndex] = Math.max(len1, Math.max(len2, len3));
        return dp[leftIndex][rightIndex];
    }

    public static void main(String args[]) {
        String str = "GEEKS FOR GEEKS";
        int strLen = str.length();
        int res = (new LongestPalindromicSubsequence(strLen, str)).computeDP(0, strLen - 1);
        System.out.println(res);
    }
}