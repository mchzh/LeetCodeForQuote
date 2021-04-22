### 554. Brick Wall

本题是对于使用hash的考察，存储关键值及对应的出现的次数。

本题要求每一个单位的竖线能穿越最少的整砖，所以要对每一个行砖出现的右边届进行统计，如果线在这个右边届就代表不会穿过，得到了不会穿过的数目用总行数减去这个数就是要穿过的数目。

[LeetCode Link](https://leetcode.com/problems/brick-wall/)
