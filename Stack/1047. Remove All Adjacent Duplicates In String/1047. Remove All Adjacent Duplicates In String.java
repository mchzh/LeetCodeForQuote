class Solution {
    // stack
    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

// x  y y
// <-
// x y<-y
// x x
// z x

/*class Solution 
{
    public String removeDuplicates(String s)
    {
        int i = 0, n = s.length();//i refers to the index to set next character in the output string.

        char[] res = s.toCharArray();
        
        //j refers to the index of current iteration in the input string.
        for (int j = 0; j < n; j++, i++)
        {
            res[i] = res[j];

            // If S[j] is same as the current last character S[i - 1], we remove duplicates by doing i -= 2.
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
            
            // If S[j] is different as the current last character S[i - 1], we set S[i] = S[j] and increment i++.

        }
        
        return new String(res, 0, i);
    }
}

// Time O(N) for one pass
// Space O(N) for output

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/discuss/294893/JavaC%2B%2BPython-Two-Pointers-and-Stack-Solution

//Two Pointers*/
