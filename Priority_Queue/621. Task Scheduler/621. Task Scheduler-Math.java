class Solution {
    public int leastInterval(char[] tasks, int n) {
        n++;
        int max = 0, countmax = 0;
        int[] count = new int[26];
        for (char c : tasks) {
            count[c-'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                countmax = 1;
                max = count[i];
            } else if (count[i] == max) {
                countmax++;
            }
        }
        int desiredtotal = n*(max-1)+countmax;
        //System.out.println(desiredtotal + " " + max + " " + countmax);
        return desiredtotal < tasks.length ? tasks.length : desiredtotal;
    }
}

// A
// B
// C  max
// D  max
// E
// F
// G

// C D  A  B  G ...
// C D  A  B
// C D  A  E
// ...  B  F
// C D

// 1) has idle: total is n*(max-1)+ countmax
// 2) no idle : total is tasks.size()
