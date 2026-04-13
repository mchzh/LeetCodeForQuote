Intuition
The idea is that for a number to be median there should be exactly (n/2) numbers that are less than this number. So, we try to find the count of numbers less than the selected number. We select the number by using binary search.

Approach
Step 1: find the minimum and maximum present in the matrix, which will be used as range of binary search.
Step 2: run a loop while min num is less than max num
inside the while loop

Step 3: find mid position, mid = min num + (max num – min num) / 2;
Step 4: now for each row, count how many numbers are less than mid,
Step 5:
if count is less than half of the number update min num = mid +1
else max num = mid
loop end
return min.
