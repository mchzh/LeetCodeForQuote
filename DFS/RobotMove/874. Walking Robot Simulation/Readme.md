### 874. Walking Robot Simulation

本题的关键点还是方向和移动问题，思路就是遇到转向标志就转向，转向由一个变量控制，加一个方向数字然后mod 4。对于移动过程中的坐标改变需要判斷是否遇到了block，遇到就停止。

```cpp
int dir = 0; // 0 up, 1 right, 2 down, 3 left
int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
Switch direction:
L: (dir+3) %4
R: (dir+1) %4
move step:
x += ;
y += ;
```
block点就增加一个set来判斷。


[Leetcode Link](https://leetcode.com/problems/walking-robot-simulation/)
