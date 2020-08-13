O(M * N) by Using Stack
Now in the code, the h[j] means: number of continius 1 in column j from row i up to row 0. By using mono-stack, what we want to achieve is to find the first previous index "preIndex", whose number of continuous 1 is less than current column index i. And the value of index between preIndex and i are all equal or larger than index i. So it can form a big sub-metrics.

Note: sum[i] means the number of submatrices with the column "i" as the right border.

If stack is empty, meaning: all previous columns has more/equal ones than current column. So, the number of metrics can form is simply A[i] * (i + 1); (0-index)
If stack is not empty, meaning: there is a shorter column which breaks our road. Now, the number of metrics can form is sum[i] += A[i] * (i - preIndex). And plus, we can form a longer submetrics with that previou shorter column sum[preIndex].
The best way to understand is to draw a graph.
