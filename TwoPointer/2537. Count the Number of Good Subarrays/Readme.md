### Intuition
First thing we need to think about,
is how we calculate the the pair (i,j) in an array.


### Explanation
We can apply the method of sliding window.
Use a hashmap count to count the frequency of each A[i].

When add a new number A[j] at the right of the window,
we already have count[A[j]] elements with value A[j] in the window,
so we will have count[A[j]] more pairs.

If we have pairs more than k,
we can reduce the size of window,
until there are pairs < k in the sliding window.
Then A[i]...A[j] is not a good subarray,
for other index i2 < i,
A[i2]...A[j] is a good subarray.
so we can update res += i for i2 = 0,1,2,...i-1.

Finally we return the result res.
