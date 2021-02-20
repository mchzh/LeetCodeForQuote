### 1247. Minimum Swaps to Make Strings Equal

首先需要判断输入是否合法，如果x和y的字符个数分别和为奇数，表明不能组成两个相同的string。

然后去判断每个index位置的字符，如果相等什么都不做，不相等只有两种情况， 四种pattern：

````
x   y
y   x
`````

````
xx   yy   xy    yx
yy   xx   yx    xy
`````
前两种pattern互换一次，后两种pattern互换两次。所以对于相同位置不同字符的情况，统计x出现次数和y出现次数，偶数次的都可以用前两种pattern处理加上count/2， 剩下的后两种pattern只可能出现一次，就是x的出现次数为奇数。
