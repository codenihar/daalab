public class set {
    public static boolean isSubsetSum(int[] set, int n, int targetSum) {
        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= set[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - set[i - 1]];
                }
            }
        }

        return dp[n][targetSum];
    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int targetSum = 9;
        int n = set.length;

        if (isSubsetSum(set, n, targetSum)) {
            System.out.println("A subset with the sum " + targetSum + " exists.");
        } else {
            System.out.println("No subset with the sum " + targetSum + " exists.");
        }
    }
}