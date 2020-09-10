class Solution {
//     public int calculate(String s) {
        
//        // empty string
//         // operator precedence
//        // multi digit number i.e num > 9
//        // leading zero
//        // is string always valid?? 
        
//         if(s == null || s.length() == 0){
//             return 0;
//         }
        
//         Stack<Integer> stack = new Stack<>();
      
//         int num = 0;
//         char lastSign = '+';
//         int sum =0;
//         for(int i=0; i< s.length() ; i++){
//             char c = s.charAt(i);
//             if(Character.isDigit(c)){
//                 num = num*10 + c-'0';
//             }
            
//             if((!Character.isDigit(c) && ' ' != c) || i == s.length()-1){
//                 switch(lastSign){
//                     case '+':
//                         stack.push(num);
//                         sum +=num;
//                         break;
//                     case '-':
//                         stack.push(-num);
//                         sum -=num;
//                         break;
//                     case '*':
//                         stack.push(stack.pop()*num);
//                         break;
//                     default:
//                         stack.push(stack.pop()/num);
//                 }
                
//                 num =0;
//                 lastSign = c;
//             }
//         }
//         int ans =0;
//         while(!stack.isEmpty()){
//             ans += stack.pop();
//         }
        
//         return ans;
//     }
    public int calculate(String s) {
        // String noSpace = "+";
        // for (char c : s.toCharArray()) {
        //     if (c == ' ') continue;
        //     noSpace += c;
        // }
        
        Stack<Integer> stack = new Stack<>();
        int N = s.length();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);
            if ( Character.isDigit(ch) ) {
                num = num*10 + (ch-'0');
            } 
            if ( (!Character.isDigit(ch) && ch != ' ') || i == N-1 ) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop()*num);
                } else if (sign == '/') {
                    stack.push(stack.pop()/num);
                }
                sign = ch;
                num = 0;
            }
        }
        // for (int i = 0; i < N; i++) {
        //     char ch = noSpace.charAt(i);
        //     if (ch == '+' || ch == '-') {
        //         // get num
        //         int j = i+1;
        //         while ( j < N && Character.isDigit(noSpace.charAt(j)) ) j++;
        //         int num = Integer.valueOf(noSpace.substring(i+1, j));
        //         i = j-1;
        //         if (ch == '+') stack.push(num);
        //         else stack.push(-num);
        //     } else if (ch == '*' || ch == '/') {
        //         int j = i+1;
        //         while ( j < N && Character.isDigit(noSpace.charAt(j)) ) j++;
        //         int num = Integer.valueOf(noSpace.substring(i+1, j));
        //         i = j-1;
        //         if (ch == '*') stack.push(stack.pop()*num);
        //         else stack.push(stack.pop()/num);
        //     }
        // }
        
        int ret = 0;
        while (!stack.isEmpty()) {
            ret += stack.pop();
        }
        return ret;
    }
}

// +10-20
// i  j
