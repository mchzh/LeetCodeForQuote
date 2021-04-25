class Solution {
    public String toHexspeak(String num) {
        // Map<Long, Character> map = new HashMap<>();
        // map.put((long)0, 'O');
        // map.put((long)1, 'I');
        // map.put((long)10, 'A');
        // map.put((long)11, 'B');
        // map.put((long)12, 'C');
        // map.put((long)13, 'D');
        // map.put((long)14, 'E');
        // map.put((long)15, 'F');
        var map = Map.of(0, "O", 1, "I", 10, "A", 11,
                    "B", 12, "C", 13, "D", 14, "E", 15, "F");

        long cur = Long.valueOf(num);
        StringBuilder sb = new StringBuilder();
        while (cur != 0) {
            int remainder = (int)(cur%16);
            if (remainder>1 && remainder < 10) return "ERROR";
            else {
                sb.append(map.get(remainder));
            }
            cur /= 16;
        }
        return sb.reverse().toString();
    }
}
