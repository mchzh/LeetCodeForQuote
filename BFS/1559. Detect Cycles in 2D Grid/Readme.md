### 1559.Detect-Cycles-in-2D-Grid

从任意一点开始，对同一个value的所有像素做常规的遍历。如果遍历的过程中遇到了之前访问过的格子，那么就是有环。注意遍历的过程中不能走“回头路”，即从A遍历到B，那么从B开始的遍历就不能包括A。

[Leetcode Link](https://leetcode.com/problems/detect-cycles-in-2d-grid/)
