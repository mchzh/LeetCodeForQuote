class Solution:
    def countCollisions(self, directions: str) -> int:
        rets = 0
        n = len(directions)
        flag = 0;
        for i in range(n):
            if flag ==0 and (directions[i] == 'R' or directions[i] == 'S'):
                flag = 1
            if flag == 1 and directions[i] == 'L':
                rets += 1

        flag = 0
        for i in range(n - 1, -1, -1):
            if flag ==0 and (directions[i] == 'L' or directions[i] == 'S'):
                flag = 1
            if flag == 1 and directions[i] == 'R':
                rets += 1
        
        return rets
