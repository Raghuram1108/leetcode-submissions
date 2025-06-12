class Solution {
public:
    bool canMake(vector<int>& bloomDay, int day, int m, int k) {
        int count = 0, bouquets = 0;
        for (int b : bloomDay) {
            if (b <= day) count++;
            else count = 0;
            if (count == k) {
                bouquets++;
                count = 0;
            }
        }
        return bouquets >= m;
    }

    int minDays(vector<int>& bloomDay, int m, int k) {
        if ((long long)m * k > bloomDay.size()) return -1;

        int left = 1, right = *max_element(bloomDay.begin(), bloomDay.end()), ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canMake(bloomDay, mid, m, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
};
