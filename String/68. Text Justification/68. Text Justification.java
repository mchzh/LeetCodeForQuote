class Solution {
    // 1. loop the input string array
    // 2. find the current line string works number with right pointer
    // 3. last line deal with left-justified space and other line with even distributed space
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rets = new ArrayList<>();
        int n = words.length;
        
        for (int i = 0; i < n; i++) {
            int j = i, count = 0;
            // move right pointer
            while (j < n && count <= maxWidth) {
                // 1st word and the following word
                if (count == 0) {
                    count += words[j].length();
                } else {
                    count += (words[j].length() + 1); // at least space compared with previous word
                }
                j++;
            }
            j--; // just back to count > maxWidth postion

            if (count > maxWidth) {
                //count <= maxwidth means is the last line;
                count -= (words[j].length() + 1);
                j--;
            }

            // words[i...j] current line elements
            if (j == n-1) {
                // last line
                rets.add(printLastLine(words, i, j, maxWidth));
            } else {
                rets.add(printCommLine(words, i, j, maxWidth));
            }

            i = j;
        }

        return rets;
    }

    private String printLastLine(String[] words, int a, int b, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if (a == b) {
            // only one word within this line
            sb.append(words[a]);
            for (int j = 0; j < maxWidth-words[a].length(); j++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        
        int cursize = 0;
        for (int i = a; i < b; i++) {
            sb.append(words[i]);
            sb.append(" ");
            cursize += (words[i].length()+1);
        }
        sb.append(words[b]);
        cursize += words[b].length();
        for (int j = 0; j < maxWidth-cursize; j++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String printCommLine(String[] words, int a, int b, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if (a == b) {
            // only one word within this line
            sb.append(words[a]);
            for (int j = 0; j < maxWidth-words[a].length(); j++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        
        int totalstring = 0;
        for (int i = a; i <= b; i++) {
            totalstring += words[i].length();
        }
        int space = (maxWidth-totalstring) / (b-a);
        int k = (maxWidth-totalstring) % (b-a); // extra space
        for (int i = a; i < a+k; i++) {
            sb.append(words[i]);
            for (int j = 0; j < space+1; j++) {
                sb.append(" ");
            }
        }
        for (int i = a+k; i < b; i++) {
            sb.append(words[i]);
            for (int j = 0; j < space; j++) {
                sb.append(" ");
            }
        }
        sb.append(words[b]);
        return sb.toString();
    }
}
