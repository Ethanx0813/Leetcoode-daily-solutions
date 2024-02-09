class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
         // Sort the array
        Arrays.sort(nums);

        // Initialize variables
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] stores the size of the largest divisible subset ending at nums[i]
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxIndex = 0;

        // Dynamic programming to find the largest divisible subset
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > maxSize) {
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        // Construct the largest divisible subset
        List<Integer> subset = new ArrayList<>();
        int currentSize = maxSize;
        int currentNum = nums[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (currentSize == dp[i] && currentNum % nums[i] == 0) {
                subset.add(nums[i]);
                currentNum = nums[i];
                currentSize--;
            }
        }

        return subset; 
    }
}
