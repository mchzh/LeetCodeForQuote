### 386. Lexicographical Numbers

思路是按个位数遍历，在遍历下一个个位数之前，先遍历十位数，十位数的高位为之前的个位数，只要这个多位数并没有超过n，就可以一直往后遍历，如果超过了，我们除以10，然后再加1，如果加1后末尾形成了很多0，那么我们要用个while循环把0都去掉，然后继续运算.

其证明过程还需要探索。

[Leecode Link](https://leetcode.com/problems/lexicographical-numbers/)
