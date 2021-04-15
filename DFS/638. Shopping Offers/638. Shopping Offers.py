class Solution(object):
    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        memo = {}
        return self.DFS(price, special, needs, memo)
    
    def DFS(self, price, special, needs, memo):
        if sum(needs)==0: return 0
        if tuple(needs) in memo: return memo.get(tuple(needs))
        rets = sum([price[i]*needs[i] for i in range(len(price))])
        for spec in special:
            newNeeds = [needs[j]-spec[j] for j in range(len(needs))]
            if min(newNeeds) >= 0:
                rets = min(rets, self.DFS(price, special, newNeeds, memo)+spec[-1])
                
        memo[tuple(needs)] = rets;
        return rets;
