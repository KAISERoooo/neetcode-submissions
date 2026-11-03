class Solution {
    public int maxProduct(int[] nums) {
        
        int curMax = 1, curMin = 1;
        int res = nums[0];
        for(int num : nums){
            int temp = num * curMax;

           
           curMax = Math.max(Math.max(curMax * num, curMin * num), num);

           curMin = Math.min(Math.min(temp, curMin * num), num);

            res = Math.max(res, curMax);
            
        }
        return res;
    }
}
