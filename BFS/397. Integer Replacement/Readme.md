### 397. Integer Replacement

本题最直接的思路就是BFS获得最短步骤，每次从队列取出本次所有需要访问的元素，然后按照奇偶规则生成下一步所有的数字进队列，辅以visited帮助判断是否之前访问过，直到队列为空或者发现要找的数字。

该题和[2059. Minimum Operations to Convert Number](https://leetcode.com/problems/minimum-operations-to-convert-number/)是完全相同的思路，仅仅是规则复杂度不同而已。

一起思考。
