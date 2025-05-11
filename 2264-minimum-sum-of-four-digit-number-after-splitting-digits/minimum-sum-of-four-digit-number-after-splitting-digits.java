class Solution {
    public int minimumSum(int num) {
        int num1 = 0;
        int num2 = 0;
        int min = 10;
        int digits[] = new int[4];
        int i = 0;
        while(num>=1){
            digits[i] = num%10;
            num = num/10;
            i++;
        }
        Arrays.sort(digits);
        num1 = digits[0]*10 + digits[3];
        num2 = digits[1]*10 + digits[2];
        return num1+num2;
    }
}