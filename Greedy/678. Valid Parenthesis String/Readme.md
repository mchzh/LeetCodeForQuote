### 678.Valid-Parenthesis-String

回想一下，如果没有“\*”的话，我们怎么处理？我们其实只需要一个计数器count表示未匹配的括号，遇到左括号就加一，遇到右括号就减一。在遍历的过程中，count不能小于零；在结束遍历后，count必须等于零。

那么有“\*”的情况下，我们的计数器需要表示一个范围[lower,upper]，表示未匹配的左括号的可能的数目。遇到左括号，未匹配的左括号数就加一；遇到右括号，未匹配的左括号数就减一，这个规则没有变。但是遇到\*的时候，它可以当做左括号，也可以当做右括号,也可以当做空号。所以我们需要处理的方法是：lower--; upper++。换句话说，lower表示我们在探索过程中尽可能地将星号转化为右括号，upper表示我们在探索过程中尽可能地将星号转化为左括号，但是同时保证当前的字符串不违法。最终遍历结束后，未匹配的左括号的数目范围需要包括零。

那么遍历的过程中这个范围会有什么变化呢？

首先，当lower小于0的时候，说明右括号太多了。那么之前出现的某个\*不能再代表右括号了，可以表示成空号。所以lower此时重置为0。而upper保持不变。

（特别注意,如果题目中说的是\*不能作为空号而只能用作左右括号的话,此时的lower应该置为1,因为我们是把一个可能用作右括号的\*确定必须为左括号.一正一反相当于lower的值会增2。此时upper的值仍然不变。）

其次，当upper小于0的时候，依然说明右括号太多了。但因为记录upper的原则是：之前的星号都尽可能地转化为左括号。说明此刻此刻，我们并没有任何多余的星号可以再变成左括号了。因此可以提前判断终止.

最后，遍历结束时，lower和upper还需要满足什么条件？显然[lower,upper]必须包括零点（事实上，lower永远不会小于零），这样表示有可能整体未被匹配的左括号数目为零。

if * only replace to ( or ), change Line 31-32 :      if countMin<0: countMin += 2

类似的题有[lintcode 1475.Minimum-Legal-Bracket-Sequence](https://github.com/wisdompeak/LintCode/tree/master/Greedy/1475.Minimum-Legal-Bracket-Sequence)

[Leetcode Link](https://leetcode.com/problems/valid-parenthesis-string)
