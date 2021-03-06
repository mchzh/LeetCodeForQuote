Given that The robot performs the instructions given in order, and repeats them forever.

What does Bounded in circle mean?
It means at some point in time the robot will be back to the point where it started (origin).

How to solve this problem?
Either If after first iteration the robot is back to the starting point or it is facing any other direction other than north. It will at some point be back to the starting point.

After first iteration, If robot is not at start position and is facing North, it would mean the robot will drift away from the origin with each iteration.

Check out some sample instructions and the route of robot after few iterations, for better understanding

![Tux, the Linux mascot](https://assets.leetcode.com/users/images/c0a94239-43e0-4275-89f3-89a5e01e59bb_1600335884.9367726.png)



First of all, this isn't an easy question. I thought hard about this one. there are two things I found important. One, if you end up where you started, it is a circle. Two, if you end up in a different place with facing north (again), hence you are drifting away. All other scenarios are going to be in a circle (or come back) in infinity no matter. You can think that the starting and the end point form a vector. Unless the end direction is north, concataned vectors will always end up on the starting point eventually (infinity).
