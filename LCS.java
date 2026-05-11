public class LCS {
    public static void findLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int index = dp[m][n];
        char[] lcs = new char[index];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs[index - 1] = s1.charAt(i - 1);
                i--; j--; index--;
            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }

        System.out.println("string 1 (name): " + s1);
        System.out.println("string 2 (key):  " + s2);
        System.out.println("LCS length: " + dp[m][n]);
        System.out.print("LCS string: ");
        System.out.println(String.valueOf(lcs));
    }

    public static void main(String[] args) {
        // String 1: Karan Kumar
        // String 2: ETAOINSHR
        findLCS("KARAN KUMAR", "ETAOINSHR");
    }
}
