class Solution {
public:
    int findMin(vector<int>& nums) {
       sort(nums.begin(),nums.end());
      vector<int> res = nums;
       return res[0]; 
    }
};