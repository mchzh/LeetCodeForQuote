### 76. Minimum Window Substring

本题的意思是求一个最小长度的滑窗，滑窗内的字符可以涵盖目标字符串的字符。

依旧使用滑窗的模板去搭框架。

``````
def two pointer
left = 0, right = n, len;
for (right = 0; right < len; right++) {
  c = s[right];
  if () // dosomething
  map[c]++; or map[c]--;
  
  while (left < right && map count == 0 or match condition) { // keep move left pointer
    if () // do something
    cl = s[left];
    map[cl]-- or map[cl]++;
    left++;
  }
}
return range or max or min;
```````

本题的判断条件设置的粗放一些就是用两个map去比较，第一个map存target元素的对应关系（char和char的出现次数）， 第二个map就是对应动态变化的滑窗信息， 然后当第二map涵盖第一个map的时候就让left指针一直移动；

涵盖条件就是对同样的字符，map2里出现次数要大于等于map1中出现次数。

另一种方式可以减少一个map，用一个map和一个单变量总数配合判断，这个总数初始是目标字符串长度。其思想是要覆盖的字符初始在map里都是正数，随着窗口涵盖后出现一次总数减少一次，减少到0后变量总数就不变了，

然后当窗口覆盖时，那些未在目标中出现的字符和多于目标的字符都只能是负数，等到窗口释放时又会逐步向零的方向恢复。

               |-------- tar1
          -----|
               |
               |------  tar2
             --|
               |---- tar3<-
               |

[Leetcode Link](https://leetcode.com/problems/minimum-window-substring/)
