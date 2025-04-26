class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int size = nums.size();
        vector<int> ans;
        for(int ele: nums){
            int elementIndex = abs(ele)-1;
            if(nums[elementIndex] < 0)
                continue;
            nums[elementIndex] = nums[elementIndex]*(-1);
        }

        for(int i = 0; i< size; i++){
            if(nums[i] > 0)
                ans.push_back(i+1);
        }
        return ans;
    }
};