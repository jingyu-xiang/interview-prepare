package CodeChallenges;

import java.util.Arrays;

class LongestIncSubseq {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = dp[0];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }
}

class RunLongestIncSubseq {
    public static void main(String[] args) {
        LongestIncSubseq sol = new LongestIncSubseq();
        int res = sol.lengthOfLIS(new int[] { 3, 2, 1 });
        System.out.println(res);
    }
}