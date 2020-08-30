### 1567. Maximum Length of Subarray With Positive Product

此题是按照0来区分subarray的贪心。对于0之前的子序列和之后的子序列按照负数出现的次数判斷，偶数次直接返回子序列长度，奇数次需要做两次remove操作prefix和suffix，找到从左到右第一个负数和从右到左最后一个负数。

Split the whole array into subarrays by zeroes since a subarray with positive product cannot contain any zero.

If the subarray has even number of negative numbers, the whole subarray has positive product.

Otherwise, we have two choices, either - remove the prefix till the first negative element in this subarray, or remove the suffix starting from the last negative element in this subarray.

[Leetcode Link](https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/)
