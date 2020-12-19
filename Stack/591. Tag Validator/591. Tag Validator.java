class Solution {
    public boolean isValid(String code) {
        // 1. <![CDATA[ -> ]]>
        // 2. </ -> >
        // 3. < -> >
        // 4. tag head and tag tail
        // 5. no tag
        // 6. head has <>, end has </>
        // tagname is a upper case
        if (code == null || code.length() == 0) return false;
        Stack<String> stack = new Stack<>();
        
        int n = code.length();
        int i = 0;
        boolean head = false;
        while (i < n) {
            if (i+8 < n && code.substring(i, i+9).equals("<![CDATA[")) {
                
                i += 9;
                int i0 = i;
                while (i+2 < n && !code.substring(i, i+3).equals("]]>")) i++;
                if (i+2 == n) return false;                
                i += 3;
            } else if (i+1 < n && code.substring(i, i+2).equals("</")) {
                i += 2;
                int i0 = i;
                while (i < n && !code.substring(i, i+1).equals(">")) i++;
                if (i == n) return false;
                String tagname = code.substring(i0, i);
                //if (!isValidTag(tagname)) return false;
                if (stack.isEmpty() || !stack.peek().equals(tagname)) return false;
                
                stack.pop();
                i++;
                if (stack.isEmpty() && i != n) return false; // tail tag
            } else if (code.substring(i, i+1).equals("<")) {
                
                i += 1;
                int i0 = i;
                
                while (i < n && !code.substring(i, i+1).equals(">")) i++;
                if (i == n) return false;
                String tagname = code.substring(i0, i);
                
                if (!isValidTag(tagname)) return false;
                
                if (head == false && i0 != 1) return false;  // head tag
                
                head = true;
                stack.push(tagname);
                i++;
            } else {
                i++;
            }
        }
        if (!head || !stack.isEmpty()) return false;
        return true;
    }
    
    private boolean isValidTag(String str) {
        if (str == null || str.length() < 1 || str.length() > 9) return false;
        for (char c : str.toCharArray()) {
            if (c < 'A' || c > 'Z') return false;
        }
        return true;
    }
}

/*class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < code.length();){
            if(i>0 && stack.isEmpty()) return false;
            if(code.startsWith("<![CDATA[", i)){
                int j = i+9;
                i = code.indexOf("]]>", j);
                if(i < 0) return false;
                i += 3;
            }else if(code.startsWith("</", i)){
                int j = i + 2;
                i = code.indexOf('>', j);
                if(i < 0 || i == j || i - j > 9) return false;
                for(int k = j; k < i; k++){
                    if(!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s = code.substring(j, i++);
                if(stack.isEmpty() || !stack.pop().equals(s)) return false;
            }else if(code.startsWith("<", i)){
                int j = i + 1;
                i = code.indexOf('>', j);
                if(i < 0 || i == j || i - j > 9) return false;
                for(int k = j; k < i; k++){
                    if(!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s = code.substring(j, i++);
                stack.push(s);
            }else{
                i++;
            }
        }
        return stack.isEmpty();
    }
}*/
