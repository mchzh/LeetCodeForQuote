### 1033. Moving Stones Until Consecutive

这道题需要针对最小步骤分析各种情况，最大步骤就是左右两个端点往中间靠拢，所以移动步骤是z-x-2。

最小步骤情况可分三类讨论： 1. 三个石头紧挨着： min = 0；

                         2. 三个石头有两个挨着或者有两个空隙为1，也就是有前两个或者后两个之间空隙为1，min=1；
                         
                         3. 其他一般情况都是min = 2；

[Leetcode Link](https://leetcode.com/problems/moving-stones-until-consecutive/)
