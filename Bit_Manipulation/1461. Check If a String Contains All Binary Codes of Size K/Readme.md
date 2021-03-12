### 1461. Check If a String Contains All Binary Codes of Size K

此题用到了与和或运算，设置一个初始的0， 然后访问每一个‘1’或者‘0’的时候，先把这个初值左移一位，然后与k个1组成的数进行与运算可以将k位之前的数都清零，

最后末位再或一次当前的值，对于每一个k位数进行判断，最后看unique的数是不是2^k个。

[LeetcodeLink](https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/)
