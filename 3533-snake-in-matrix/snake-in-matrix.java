class Solution {
    public int finalPositionOfSnake(int n, List<String> nums) {
        int i=0;
        for(String c: nums){
            if(c.charAt(0)=='D')i+=n;
            else if(c.charAt(0)=='R')i+=1;
            else if(c.charAt(0)=='L')i-=1;
            else i-=n;
        }
        return i;
    }
}