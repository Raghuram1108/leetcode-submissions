class Solution {
public:
    vector<vector<int>> construct2DArray(vector<int>& original, int m, int n) {
    vector<vector<int>> ans(m,vector<int>(n));
    int a =0;
       if(m*n == size(original))
    {
          for(int i=0;i< m;i++)
            {
              for(int j=0;j<n;j++)
                 {
                    ans[i][j]  = original[a];
                    a++;             
                 }
             
            }
            return ans;
    }
       if(m*n != size(original))
       {
        return {};
       }
       return {};
    }
};