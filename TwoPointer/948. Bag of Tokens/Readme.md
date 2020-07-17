### 948. Bag of Tokens

此题是一个简单双指针贪心。

首先对tokens队列排序，双指针循环中两个判斷条件， Power大于左边token值就消掉获取power直到不能消， 此时更新最大的point值，然后继续用point换取右边的power值用来继续消左边的token以获得更多分数。

[Leetcode Link](https://leetcode.com/problems/bag-of-tokens/)
