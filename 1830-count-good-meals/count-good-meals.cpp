class Solution {
public:
    int countPairs(vector<int>& deliciousness) {
        const int MOD = 1e9 + 7;
        unordered_map<int, int> count;
        int result = 0;

        for (int val : deliciousness) {
            for (int power = 1; power <= (1 << 21); power <<= 1) {
                int complement = power - val;
                if (count.find(complement) != count.end()) {
                    result = (result + count[complement]) % MOD;
                }
            }
            count[val]++;
        }

        return result;
    }
};