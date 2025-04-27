class Solution {
public:
    bool checkRecord(string s) {

        int n=s.size();
        int absent=0;
        int late=0;
                 int ans=INT_MIN;
        for(int i=0;i<n;i++)
        {
            if (s[i]=='L')
            {
                late++;
                continue;

            }
           else if(s[i]=='A')
            {
                absent++;
            }
            
         ans=max(ans,late);
         late=0;
        }
          ans=max(ans,late);
        if(absent<2 && ans<3)
        {
            return true;
        }

        return false;
    }
};