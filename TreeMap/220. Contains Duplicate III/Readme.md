### 220. Contains Duplicate III

本题brute force解法就是两重loop去遍历所有区间，在区间小于等于k的window里compare abs difference。

改进的思路就是固定一个当前访问的元素，在之前访问过的有序序列中查找符合abs小于等于t的元素，所以需要应该需要pq或者ordered set去存访问过的元素。

但是pq内部元素不是有序的，iterator耗时，应用treeset已经其api celing和floor。


[Leetcode Link](https://leetcode.com/problems/contains-duplicate-iii/)
