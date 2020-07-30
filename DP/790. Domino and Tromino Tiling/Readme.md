```when N==0, we need return 0, but in dp , we need make dp[0]=1 for easy to construct formula
```

![Test Image 7](https://s3-lc-upload.s3.amazonaws.com/users/zhengkaiwei/image_1519539268.png)

## Formula!

dp[n]=dp[n-1]+dp[n-2]+ 2*(dp[n-3]+...+d[0])
=dp[n-1]+dp[n-2]+dp[n-3]+dp[n-3]+2*(dp[n-4]+...+d[0])
=dp[n-1]+dp[n-3]+(dp[n-2]+dp[n-3]+2*(dp[n-4]+...+d[0]))
=dp[n-1]+dp[n-3]+dp[n-1]
=2*dp[n-1]+dp[n-3]
