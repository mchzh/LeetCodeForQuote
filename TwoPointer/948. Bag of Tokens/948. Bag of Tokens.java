class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        // bp: select or non-select then dp
        Arrays.sort(tokens);
        int score = 0, ret = 0;
        int left = 0, right = tokens.length-1;
        while ( left <= right && (P >= tokens[left] || score > 0) ) {
            // play token face up until we cannot
            while (left <= right && P >= tokens[left]) {
                score++;
                P -= tokens[left++];
            }
            ret = Math.max(ret, score);
            if (left <= right && score >= 1) {
                P += tokens[right--];
                score --;
            }
        }
        return ret;
    }
}

/*class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int l = 0, r = tokens.length-1;
        int res = 0, points = 0;
        
       while(l<=r){
           if(P>=tokens[l]){
               P-=tokens[l++];
               points++;
               res = Math.max(res, points);
           }
           else if(points>0){
               points--;
               P+=tokens[r--];
           }
           else{break;}
       }
        
        return res;
    }
}*/
