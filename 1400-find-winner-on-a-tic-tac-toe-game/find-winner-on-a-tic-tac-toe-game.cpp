class Solution {
public:
    string tictactoe(vector<vector<int>>& moves) {
        int rows[3] = {}, cols[3] = {}, diag = 0, anti = 0;
        int turn = 1;
        for (auto& move : moves) {
            int r = move[0], c = move[1];
            rows[r] += turn;
            cols[c] += turn;
            if (r == c) diag += turn;
            if (r + c == 2) anti += turn;
            if (abs(rows[r]) == 3 || abs(cols[c]) == 3 || 
                abs(diag) == 3 || abs(anti) == 3) 
                return turn == 1 ? "A" : "B";
            turn *= -1;
        }
        return moves.size() == 9 ? "Draw" : "Pending";
    }
};