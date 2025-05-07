class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int c=0;
        Set<Character>s=new HashSet<>();
        for(Character i:jewels.toCharArray()){
            s.add(i);
        }
        for(int i=0;i<stones.length();i++){
            if(s.contains(stones.charAt(i))) c++;
        }
        return c;
    }
}