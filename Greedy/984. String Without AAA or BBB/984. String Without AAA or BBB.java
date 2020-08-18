class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        char constA = 'a', constB ='b';
        while ( A != 0 || B != 0 ) {
            if (A == B) {
                sb.append(constA);
                sb.append(constB);
                A--;B--;
            } else if (A > B) {
                if (A >= 2) {
                    sb.append(constA);
                    sb.append(constA);
                    A -=2;
                } else {
                    sb.append(constA);
                    A--;
                }
                if (B != 0) {
                    sb.append(constB);
                    B--;
                }
            } else {
                if (B >= 2) {
                    sb.append(constB);
                    sb.append(constB);
                    B -=2;
                } else {
                    sb.append(constB);
                    B--;
                }
                if (A != 0) {
                    sb.append(constA);
                    A--;
                }
            }
        }
        return sb.toString();
    }
}
