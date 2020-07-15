class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] mask = new boolean[s.length()];
        
        for (String word : dict) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != word.charAt(0)) continue;
                // check if substring == word
                if (i+word.length()-1 < s.length() && s.substring(i, i+word.length()).equals(word)) {
                    for (int k = 0; k < word.length(); k++) mask[i+k] = true;
                }
            }
        }
        
        // add <b> tag, get cosecutive char
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // begin of group
            if (mask[i] && (i == 0 || !mask[i-1])) sb.append("<b>");
            sb.append(s.charAt(i));
            // end of group
            if (mask[i] && (i == s.length()-1 || !mask[i+1])) sb.append("</b>");
        }
        //if (mask[S.length()-1]) sb.append("</b>");
        return sb.toString();
    }
}
/*class Solution {
    public String addBoldTag(String S, String[] words) {
         StringBuilder sb = new StringBuilder();
        boolean [] status = new boolean[S.length()];
        
        for(String word: words){

            int index = 0;
            while(index != -1 && index < S.length()){
                index = S.indexOf(word, index);
                if (index != -1) {
                    //update status
                    int start = index; 
                    int end = index + word.length();
                    for(int i=start; i< end; i++){
                        status[i] = true;
                    }
                    index ++;
                }
            }
        }

        boolean b = false;
        for(int i=0; i<status.length; i++){
            if(status[i] == true){
                if(b == false){
                    b = true;
                    sb.append("<b>");
                }
            }else {
                if(b == true){
                    b = false;
                    sb.append("</b>");
                }
            }
            sb.append(S.charAt(i));
        }
        if(b == true){
            sb.append("</b>");
        }
        return sb.toString();
    }
}*/
