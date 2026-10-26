class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] temp1 = new int[nums.length - 1];
        int[] temp2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            temp1[i] = nums[i];
            temp2[i] = nums[i + 1];
        }
        return helper(temp1, temp2);
    }
    private int helper(int[] temp1, int[] temp2) {
        int n1 = temp1.length;
        int n2 = temp2.length;
        int[] dp1 = new int[n1];
        int[] dp2 = new int[n2];
        dp1[0] = temp1[0];
        dp2[0] = temp2[0];
        dp1[1] = Math.max(temp1[0], temp1[1]);
        dp2[1] = Math.max(temp2[0], temp2[1]);
        for (int i = 2; i < n1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + temp1[i], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + temp2[i], dp2[i - 1]);
        }
        return Math.max(dp1[n1 - 1], dp2[n2 - 1]);
    }
}