class Solution {
    public int leastInterval(char[] tasks, int n) {
        n++;
        int[] count = new int[26];
        for (char t : tasks) count[t-'A']++;
        
        int maxFreq = 0;
        for (int c : count) maxFreq = Math.max(c, maxFreq);
        
        int tail = 0;
        for (int c : count) if (c == maxFreq) tail++;
        
        // (maxFreq-1)*n+tail : tasks.size()
        int areaA = (maxFreq-1)*n+tail;
        return areaA < tasks.length ? tasks.length : areaA;
    }
}


// maxFreq:
// A
// B
// C : f_c
// D : f_d
// E
// F
// G
// HIJKLMNOPQ



// A B X X X 
// A B X X X
// A B X X X
// A B X X X
// A B

// (a) include idle
// A B C D F 
// A B C E G
// A B C E X
// A B D F X
// A B

// (b) length of input
// A B C D F J n 
// A B C E G k o
// A B C E H l p
// A B D F I m
// A B
