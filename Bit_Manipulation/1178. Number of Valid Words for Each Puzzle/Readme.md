### 1178. Number of Valid Words for Each Puzzle

#### 解法1：
bitmask, 因为小写字母一共26个，所以对于一个word出现过的字符最多就是2^26大小，在整数范围内，对于一个string，如何获得它的出现字符的bitmask？我们用下面代码。

``````
for (char c : str) {
  mask |= (1<<(c-'a));
}
``````
第一位代表a，第二位代表b，以此类推，比如cej就是10010100，算出每个word的bitmask后用map存储其出现数量。
接着对于每个puzzle都有一个最初的state，对这个state的所有submask进行遍历，每个在map里存在的submask表明这些word是match的，就可以直接sum其对应的数量。


#### 解法2

trie, Trie解法看leetcode solution，随后补上。
