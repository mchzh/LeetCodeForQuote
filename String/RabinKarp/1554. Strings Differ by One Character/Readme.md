### 1554. Strings Differ by One Character

此题暴力解法目前可过，但是用Rabin Karp hash可以减少时间复杂度。

Rabin Karp主要用在匹配两个字符的内容，采用26进制去得到hash value再做进一步处理。

hash之后需要对于当然字符串的每个字符和26个小写字母比较，先把当前访问到的字符从hash中去除，然后如果某个小写字母和当前字符不同，以现在去除的hash得到新的hash，如果hash存在说明存在。

hash - currentCharHash * power : hashWithout

hashWithout + visitedDifferentChar * power : hashNew

[Leetcode Link](https://leetcode.com/problems/strings-differ-by-one-character/)
