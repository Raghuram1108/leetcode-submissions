class Solution {
public:
    vector<int> luckyNumbers(vector<vector<int>>& matrix) {
        vector<int>ans;
        for(int i=0; i<matrix.size(); i++){
            int min_row_value = 1000000;
            int min_col;

            for(int j=0; j<matrix[i].size(); j++){
                if(matrix[i][j] < min_row_value){
                    min_row_value = matrix[i][j];
                    min_col = j;
                }
            }

            int max = 0;
            for(int i=0; i<matrix.size(); i++){
                if(max < matrix[i][min_col]){
                    max = matrix[i][min_col];
                }
            }
            if(max == matrix[i][min_col]) ans.push_back(max);
        }
        return ans;
    }
};