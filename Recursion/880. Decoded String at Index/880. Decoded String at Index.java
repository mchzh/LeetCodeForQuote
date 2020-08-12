class Solution {
    public String decodeAtIndex(String S, int K) {
        return helper(S, (long)K);
//         long size = 0;
//         int N = S.length();
        
//         for (char c : S.toCharArray()) {
//             if (Character.isDigit(c)) {
//                 size *= (c-'0');
//             } else {
//                 size++;
//             }
//         }
        
//         // from outer side to inside
//         for (int i = N-1; i >= 0; i--) {
//             char c = S.charAt(i);
//             K %= size;
//             if (K == 0 && !Character.isDigit(c)) return String.valueOf(c);
            
//             if (Character.isDigit(c)) {
//                 size /= (c-'0');
//             } else {
//                 size--;
//             }
//         }
//         return "";
    }
    // ha2 2
    private String helper(String str, long k) {
        long count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                count++;
                //System.out.println(c + ": char pos is -> " + count);
                if (count == k) return String.valueOf(c);
            } else {
                long times = c-'0';
                
                if (count*times < k) {
                    count = count*times;
                } else if (k % count == 0) {
                    //System.out.println("0 encounter number -> " + c + ": char pos is -> " + count);
                    return helper(str.substring(0, i), count);
                } else {
                    //System.out.println("non 0 encounter number -> " + c + ": char pos is -> " + count);
                    return helper(str.substring(0, i), k%count);
                } 
                //System.out.println("encounter number -> " + c + ": char pos is -> " + count);
            }
        }
        return "";
    }
}
