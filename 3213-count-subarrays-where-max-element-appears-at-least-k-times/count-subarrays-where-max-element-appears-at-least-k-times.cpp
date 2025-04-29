class Solution {
public:
    long long countSubarrays(vector<int>& nums, int k) {
        int maxi = *max_element(nums.begin(), nums.end());
        int n = nums.size();
        long long count = 0;
        int l = 0, maxFreq = 0;

        for (int r = 0; r < n; ++r) {
            if (nums[r] == maxi) ++maxFreq;

            while (maxFreq >= k) {
                count += (n - r); // All subarrays from l to r are valid
                if (nums[l] == maxi) --maxFreq;
                ++l;
            }
        }

        return count;
    }
};
