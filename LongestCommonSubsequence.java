class LongestCommonSubsequence {
    private final String str1;
    private final String str2;

    private final int len1;
    private final int len2;

    int[][] dp;

    public LongestCommonSubsequence(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;

        int len1 = str1.length();
        int len2 = str2.length();

        this.len1 = len1;
        this.len2 = len2;

        this.dp = new int[len1][len2];

        for (int i = 0; i < len1; i++)
            for (int j = 0; j < len2; j++)
                this.dp[i][j] = -1;
    }

    private int computeLength(int startInd1, int startInd2) {
        if (startInd1 == this.len1 || startInd2 == this.len2)
            return 0;
        
        if (this.dp[startInd1][startInd2] != -1)
            return this.dp[startInd1][startInd2];
        
        int l = 0;
        if (this.str1.charAt(startInd1) == this.str2.charAt(startInd2)) {
            this.dp[startInd1][startInd2] = 1 + this.computeLength(startInd1 + 1, startInd2 + 1);
            return this.dp[startInd1][startInd2];
        }
        
        int l1 = this.computeLength(startInd1 + 1, startInd2);
        int l2 = this.computeLength(startInd1, startInd2 + 1);

        dp[startInd1][startInd2] = (l1 > l2) ? l1 : l2;
        return dp[startInd1][startInd2];
    }

    public static void main(String args[]) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        int LCS = (new LongestCommonSubsequence(str1, str2)).computeLength(0, 0);
        System.out.println(LCS);
    }
}