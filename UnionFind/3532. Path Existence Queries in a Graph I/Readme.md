### 3532. Path Existence Queries in a Graph I


#### 解法：Union Find

我们根据如下的规则将所有的人分组：1.同属于一对couple的聚为一组；2.被安排在相邻位置的聚为一组（指的是01，23，45这样的位置）。

这样我们就得到了若干个union。这些union有如下性质：1.每个union之间是没有关系的，即没有任何couple被拆在不同的union里。2.在每个union内部，都可以通过若干次的swap使得内部的couple得到配对。3.每个union不可能再拆分为若干个更小的union。

因为每个union是这样一个“最小”的社区单位，所以他们其实形成了一个闭环。如果一个union内部有k对couple，则最多只需要k-1次swap就可以让所有couple配对。（这是因为每次swap至少能保证一对couple配对，而使得k-1对couple配对后，最后一对couple自然也就配对了。）那么有没有可能用更少次数的swap使其配对呢？其实不可能。

给一个比较粗糙的类比。Union A有k个couple，Union B有m个couple，Union C有n个couple，且k=m+n。要是的B和C理顺关系，只需要m-1+n-1=m+n-2=k-2次swap。如果理顺A也只需要k-2此的话，其意味着A可能分为B+C？但事实上A不可再分，其拓扑结构必然复杂于B+C，所以不可能也用k-2次swap就实现目标，只能用k-1次。


[Leetcode Link](https://leetcode.com/problems/path-existence-queries-in-a-graph-i/description/)
