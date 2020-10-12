### 1208. Get Equal Substrings Within Budget

本题的意思是在滑动窗口里不同的元素的cost之和要小于等于给定的最大值。

基本的two pointer算法，让right指针不停的移动，遇到不同的字符就增加cost，同时计算当前的最大长度。

如果当前窗口的cost大于最大cost，需要移动左指针以减少花费来形成新的滑窗，只能右指针遍历完毕。


[Leetcode Link](https://leetcode.com/problems/get-equal-substrings-within-budget/)
