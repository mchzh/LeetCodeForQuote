### 1515. Best Position for a Service Centre

此题需要估算思想，选定一个点和一个步长，以这个点为起点，向四个方向移动相同步长得到四个点，通过比较当前点和所有点的距离以及四个点和所有点的距离哪个小来决定是否减小步长，每次减小的步长是最初的二分之一。

如果四个扩展点有一个的距离小于当前点产生的距离，就用这个扩展点代替当前点作为起点，继续用同样步长做同样的逻辑，否则就减少步长再进入同样逻辑直到步长趋近于零。


[Leetcode Link](https://leetcode.com/problems/best-position-for-a-service-centre/)
