class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) return 0;
        String str = Integer.toBinaryString(n);
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') i++;
        
        str = str.substring(i);
        i = 0;
        int lastDigits = 0;
        for (int k = 0; k < str.length(); k++) {
            int x;
            if (str.charAt(k) == '1') {
                x = lastDigits == 0 ? 1 : 0;
            } else {
                x = lastDigits == 0 ? 0 : 1;
            }
            
            i = i*2 + x;
            lastDigits = x;
        }
        
        return i;
    }
}
