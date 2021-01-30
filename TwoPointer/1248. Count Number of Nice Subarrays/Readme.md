### 1248. Count Number of Nice Subarrays

本题的意思是可以给你一个固定长度的滑窗，滑窗里面是固定的k个odd的数。

首先遍历一遍数组将数是odd的索引位置加到动态数组中，为了方便前后各增加一个虚拟节点，开头是-1， 结尾是整个输入数组的长度。

然后考虑一个长度为k的滑窗内，用滑窗头尾节点的位置分别与它的前一个和后一个位置作减法，得到两个距离，两个距离的乘积就是当前取的k个odd数后能形成的subarray的数目。

[Leetcode Link](https://leetcode.com/problems/count-number-of-nice-subarrays/)
