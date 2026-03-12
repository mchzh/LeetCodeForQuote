class Solution {
    public String nearestPalindromic(String n) {
        String sm = nextSmaller(n);
        String sg = nextGreater(n);
    
        if (Long.valueOf(sg) - Long.valueOf(n) >= Long.valueOf(n) - Long.valueOf(sm)) {
            return sm;
        } else {
            return sg;
        }
    }

    private String nextSmaller(String n) {
        char[] chars = n.toCharArray();
        int len = chars.length;
        for (int i = 0, j = len-1; i<=j;) {
            chars[j--] = chars[i++];
        }
        
        if (String.valueOf(chars).compareTo(n) < 0) {
            return String.valueOf(chars);
        }

        int carry = 1;
        // minus 1
        for (int i = (len-1)/2; i >=0 ;i--) {
            int d = chars[i]-'0'-carry;
            if (d >= 0) {
                chars[i] = (char)(d + '0');
                carry = 0;
            } else {
                chars[i] = '9';
                carry = 1;
            }
            chars[len-1-i] = chars[i];
        }

        if (chars[0] == '0' && len > 1) {
            //100-1 = 099
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len-1; i++) {
                sb.append('9');
            }
            return sb.toString();
        } else {
            return String.valueOf(chars);
        }
    }
    private String nextGreater(String n) {
        char[] chars = n.toCharArray();
        int len = chars.length;
        for (int i = 0, j = len-1; i<=j;) {
            chars[j--] = chars[i++];
        }
        
        if (String.valueOf(chars).compareTo(n) > 0) {
            return String.valueOf(chars);
        }

        int carry = 1;
        // plus 1: 99
        for (int i = (len-1)/2; i >=0 ;i--) {
            int d = chars[i]-'0'+carry;
            if (d <= 9) {
                chars[i] = (char)(d + '0');
                carry = 0;
            } else {
                chars[i] = '0';
                carry = 1;
            }
            chars[len-1-i] = chars[i];
        }

        // out of boundary: 999 -> 1000 -> 10001(99919)
        // m-1 0 + head 1 + tail 1
        if (chars[0] == '0') {
            //100-1 = 099
            StringBuilder sb = new StringBuilder();
            sb.append('1');
            for (int i = 0; i < len-1; i++) {
                sb.append('0');
            }
            sb.append('1');
            return sb.toString();
        } else {
            return String.valueOf(chars);
        }
    }
}
// 123 => 121
// 12399 : 12321 smaller 
//       : 12421 greater (near)
// 39512 : 39593 greater
//       : 39493 smaller (near)

// 991: -> +1 = 100 -> 10001 -> should 1001
// 1004 : -> -1 -> 99 -> 999
