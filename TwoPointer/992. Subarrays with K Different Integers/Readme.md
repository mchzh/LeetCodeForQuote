### 992. Subarrays with K Different Integers

本题是滑动窗口的应用。

基本思想是定义一个函数求最多有k个不同数字的subarray有多少个，这个函数可以方便的用滑动窗口解决，只需要定义一个辅助的map统计当前窗口的不重复的数字个数，利用滑动窗口模板解决：

````````
        int[] count = new int[n+1];
        int i = 0;
        int rets = 0;
        for (int j = 0; j < n; j++) {
            if (count[A[j]]++ == 0) k--;
            while (k < 0) {
                if (--count[A[i++]] == 0) k++;
            }
            
            rets += j-i+1;
        }
        return rets;
````````

题目就演变成允许最多k个不重复和允许最多k-1个不重复相减就是恰好有k个不重复的子序列个数。

[Leetcode Link](https://leetcode.com/problems/subarrays-with-k-different-integers/)
