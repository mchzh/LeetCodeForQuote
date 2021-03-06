### 489.Robot-Room-Cleaner

比较常规的DFS，但是题目却很有趣，而且对于考察回溯的概念要求很高．

基本的流程是：

(1) 每新探索(DFS)一个格子，先判断是否曾经来过，曾经来过的话什么都不用做，return．注意，这里是指＂新探索＂一个格子．如果确定不是新探索，而是在回溯的过程中到了这个地方，不适用于这个规则．

如果这是一个新格子，就clean()，并且标记已经来过．然后依次向四个方向探索：

(2) 首先向当前方向继续探索：步骤是：move, DFS（递归的过程，新探索下一个格子）, turnRight, turnRight, move, turnRight, turnRight．后面这五步是一个必要的回溯过程，保证回到了探索之前的状态．

(３) 然后turnRight,找到下一个方向，重复(２)的过程．

(４) 然后turnRight,找到下一个方向，重复(２)的过程．

(５) 然后turnRight,找到下一个方向，重复(２)的过程．

完整结束了这个格子的探索．

本题看上去是一个常规的DFS，但是难点在于机器人的运动是第一视角，DFS的回溯过程必须靠“手工”实现。

假设当前我们访问了dfs(x,y,north)，表示当前位置是(x,y)，朝向是北。如果我们想递归访问它的东边的节点(i,j)，你需要依次做如下的事情：
```
1. 向右转，使得朝向东边，
2. 前进
3. 递归调用dfs(i,j,east)
4. 180度转弯
5. 前进
6. 180度转弯
=====
8. 向右转，使得朝向南边
9. 前进
10. 递归调用dfs(i,j,south)
11. ...
```
可见我们完成一次dfs之后，必须手工完成掉头、退回、调整方向，才能进行另一次平行的dfs尝试。


[Leetcode Link](https://leetcode.com/problems/robot-room-cleaner)
