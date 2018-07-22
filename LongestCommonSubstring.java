class LongestCommonSubstring {
    private String str1;
    private String str2;
    private int[][] dp;

    public LongestCommonSubstring(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;

        int len1 = str1.length();
        int len2 = str2.length();

        this.dp = new int[len1][len2];

        for (int i = 0; i < len1; i++)
            for (int j = 0; j < len2; j++)
                this.dp[i][j] = 0;
    }

    private int computeLength() {
        int len1 = str1.length();
        int len2 = str2.length();

        for (int i = 0; i < len1; i++)
            if (this.str1.charAt(i) == this.str2.charAt(0))
                this.dp[i][0] = 1;
        
        for (int j = 0; j < len2; j++)
            if (this.str1.charAt(0) == this.str2.charAt(j))
                this.dp[0][j] = 1;
        
        for (int i = 1; i < len1; i++)
            for (int j = 1; j < len2; j++)
                if (this.str1.charAt(i) == this.str2.charAt(j))
                    this.dp[i][j] = this.dp[i - 1][j - 1] + 1;
        
        int max = -1;
        for (int i = 0; i < len1; i++)
            for (int j = 0; j < len2; j++)
                if (max < this.dp[i][j])
                    max = this.dp[i][j];
        
        return max;
    }

    public static void main(String args[]) {
        String str1 = "GeeksforGeeks";
        String str2 = "GeeksQuiz";

        int LCS = (new LongestCommonSubstring(str1, str2)).computeLength();
        System.out.println(LCS);
    }

}