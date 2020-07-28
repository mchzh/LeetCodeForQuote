### 325. Maximum Size Subarray Sum Equals k

此题就是用map存储preSum的信息后和当前的sum值进行比较，比较关键的两个点是一是需要设置一个virtual node表示起始的sum，另一个是先判斷之前的preSum信息再更新当前信息。

设计如下的判斷条件：

```cpp
        map.put(0, 1); // save the initialize sum value; key is sum and value is index or count
        ///
        for () {
          sum += cur;
          if (map.coantains(sum-k)) // update the result
          
          map.put(cur, val);
        }
        ///
```        

与本题非常相似的题目有： 560. Subarray Sum Equals K    


[Leetcode Link](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/)
