class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int rets = 1;
        for (int i = 2; i*i <= num; i++) {
            if (num%i == 0) {
                rets += i;
                if (i*i != num) rets += num/i;
            }
        }

        return rets == num;
    }
}
