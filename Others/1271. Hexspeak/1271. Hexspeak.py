class Solution:
    def toHexspeak(self, num: str) -> str:
        h = hex(int(num))[2:].upper().replace('0','O').replace('1','I')
        myset={"A","B","C","D","E","F","I","O"}
        for i in h:
            if str(i) not in myset:
                return "ERROR"
        return h
