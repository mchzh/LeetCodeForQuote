### 302. Smallest Rectangle Enclosing Black Pixels

本题可以遍历每个方阵，查看方阵black pixel point。对每一个点都可以更新长方形的左右和上下边界。

本题更高效的方法就是二分搜值。从当前点的列开始向左找到最左边的1，向右找到最右边的1。同理从当前点的行开始向上找到最上面的1，向下找到最下面的1。查找过程就是定义边界后使用二分法。

[LeetCode Link](https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/)
