class Solution {
public:
    int minimumDeletions(string w, int k) {
        
    int f[26]={}, r = size(w); for (auto& c: w) ++f[c - 'a'];
        for (int x: f) {
            int remove = 0;
            for (int c: f) remove += c < x ? c: max(0, c - x - k);
            r = min(r, remove);
        } return r;
    }
};