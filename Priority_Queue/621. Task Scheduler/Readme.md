### 621.Task-Scheduler

#### 解法１：模拟最优解的过程

此题非常类似  358.Rearrange-String-k-Distance-Apart。

设计一个大顶堆的priority_queue，每次取出权重最多的n+1个（或少于这个数目）字符，将其权重减一后再放回队列中。

需要注意的是，即使队列中的元素少于n+1，只要没有完成所有的任务，根据题意的idle设定，计数器仍需要count+=n+1. 只有最后一轮（弹出后队列为空）时，计数器才 count+= num，其中num时队列弹出前的元素个数。

#### 解法２：

我们令n自加１，这样题意要求每n个相邻的位置不能有重复的元素．如果有重复的元素，则必须放在每ｎ个为一组的每个小组的前端．

首先，我们可以在队列中找到出现的最大的字符频率maxFreq.这样我们构造maxFreq-1个容器，每个容器至少有n的容量（可以比n多，后面会讲）．暂时我们将每个位置都置为idle占位.然后我们将所有的字符都过一遍，如果该字符的词频<=maxFreq-1，那么我们就将它依次,均匀地放在每个容器的最前端即可．如果词频==maxFreq，那么就仍然照此方法处理其中的maxFreq-1个，剩下一个就扔到最后再处理（用count++记录一下）．如果一个容器装满了n个，没关系，在这个容器的后面继续添加；如果一个容器始终没有满n，那么没有满的部分我们依然设置为idle.

最后我们把这些容器并列排成一排，再加上落单的那些可以再摆放一排，就是我们的解决方案．

这些容器有多少个位置呢？注意到，这些容器都是均匀填充的，即任意两个容器之间的个数不会相差大于１（把idle也算上），所以无非就是两种情况，一种就是这些容器（至少部分容器）还没有填充满n个，所以我们需要的位置依然是整个矩阵的大小加上落单的个数```(maxFreq-1)*n+count```．另外一种就是这些容器都已经填充满n个了，说明没有任何需要用idle来占位的情况，那么我们需要的位置的个数就是字符的个数```tasks.size()```

与本题类似的题目还有：767. Reorganize String，1054. Distant Barcodes


[Leetcode Link](https://leetcode.com/problems/task-scheduler)
