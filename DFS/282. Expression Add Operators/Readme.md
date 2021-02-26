### 282. Expression Add Operators

比较直观的想法就是DFS搜索，层层递归下去。设计递归函数表示从位置0开始插入+， -， *之后形成的各种组合是否满足题目要求。

加减比较容易处理，有乘法后单传递之前得到的算术值就不够了，所以需要增加变量递归进去。

举例子
```
 (12+3-4*5)+ DFS(7896)
 (12+3-4*5)- DFS(7896)
 (12+3-4*5)* DFS(7896)
```
遇到乘法的时候需要知道最后一个单项式的值，所以递归过程中要包括前面形成的算术值和最后一个单项式的值
prevalue 和 lastvalue

[Leetcode Link](https://leetcode.com/problems/expression-add-operators/)
