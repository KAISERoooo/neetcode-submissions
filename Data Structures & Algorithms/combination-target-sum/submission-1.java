

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        dfs(0, new ArrayList<>(), 0, target, nums, res);

        return res;
    }

    public void dfs(int i, List<Integer> cur, int total,
                    int target, int[] nums, List<List<Integer>> res) {

        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) {
                break;
            }

            cur.add(nums[j]);

            dfs(j, cur, total + nums[j], target, nums, res);

            cur.remove(cur.size() - 1);
        }
    }
}