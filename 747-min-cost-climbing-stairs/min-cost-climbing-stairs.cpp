class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int n = cost.size();
        cost.push_back(0);
        for(int a=n-3;a>=00;a--){
        cost[a] +=min(cost[a+1],cost[a+2]);
        }
        return min(cost[0],cost[1]);
    }
};