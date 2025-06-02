class Solution {
public:
    int differenceOfSum(vector<int>& nums) {
        int sum = 0, dsum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            int n = nums[i];
    

            while (n != 0) {
                dsum += (n % 10);
                n /= 10;
            }
        }
            return abs(sum - dsum);
        }
    };