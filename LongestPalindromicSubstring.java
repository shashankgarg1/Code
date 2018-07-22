class LongestPalindromicSubstring {
    private String str;
    private Boolean[][] dp;
    public String longestSubstring;

    public LongestPalindromicSubstring(String str, int n) {
        this.str = str;
        this.dp = new Boolean[n][n];
        
        for (int i = 0; i < n; i++)
	        for (int j = 0; j < n; j++)
		        this.dp[i][j] = false;
    }

    private String computeSubstring() {
        int len = this.str.length();

        for (int i = 0; i < len; i++)
            this.dp[i][i] = true;
        
        this.longestSubstring = this.str.substring(0, 1);
        
        if (len > 2)
            for (int i = 0; i < len - 2 + 1; i++)
                if (this.str.charAt(i) == this.str.charAt(i + 1)) {
                    this.dp[i][i + 1] = true;
                    this.longestSubstring = this.str.substring(i, i + 2);
                }

        for (int strLen = 3; strLen < len; strLen++)
            for (int i = 0; i < len - strLen + 1; i++)
                if (this.str.charAt(i) == this.str.charAt(i + strLen - 1) && this.dp[i + 1][i + strLen - 2]) {
                    this.dp[i][i + strLen - 1] = true;
                    this.longestSubstring = this.str.substring(i, i + strLen);
                }
        return this.longestSubstring;
    }

    public static void main(String args[]) {
        String str = "forgeeksskeegfor";
        String substr = (new LongestPalindromicSubstring(str, str.length())).computeSubstring();
        System.out.println(substr);
    }
}