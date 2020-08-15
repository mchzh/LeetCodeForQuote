### 394. Decode String

这个题主要就是考虑入栈和出栈条件。

如果是数字就需要把当前获得的str入栈，str置为"", 然后数字需要在访问到'['入栈。

出栈条件就是遇到']', str里面的top元素加目前获得的临时str重复，重复的次数从num的top元素获得。

最终返回的是当前的字符串，即curRes。


[Leetcode Link](https://leetcode.com/problems/decode-string/)
