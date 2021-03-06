### 1606.Find-Servers-That-Handled-Most-Number-of-Requests

我们希望能有一个集合free，里面存放当前空闲的服务器id。如果这个集合是有序的，那么显然我们就很容易用二分法找到我们想要操作的服务器（也就是第一个大于等于i%k的机器，如果没有，就找id最小的机器）。然后我们会将这个机器从集合中删除。然后处理下一个任务。

那么如何往free里面添加已经完成任务的呢？我们可以在处理任务i的时候，将所有arrival[i]之前就已经完工的机器加入到free里面。因此我们可以维护一个busy的优先队列，存放的都是正在工作的机器，并且按照预期完工时间从早到晚排序。因此每次我们找到处理任务i的机器时，记得将它加入busy队列。

最终我们将每台机器被指派的任务累加起来找到最大值即可。

时间复杂度分析：外层的循环是o(N)。内层对于free而言，每层循环有固定一次的查找、删除；对于busy而言，有固定一次的弹出。考虑到free和busy最长是K，所以最终时间复杂度大概是```O(N*logK)```

[LeetCode Link](https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/)
