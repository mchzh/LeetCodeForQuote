### 1048. Longest String Chain

Instead of adding a character, try deleting a character to form a chain in reverse.

For each word in order of length, for each word2 which is word with one character removed, length[word2] = max(length[word2], length[word] + 1).

[Leetcode Link](https://leetcode.com/problems/longest-string-chain/)
