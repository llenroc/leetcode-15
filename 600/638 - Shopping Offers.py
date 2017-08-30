class Solution(object):
    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        l = len(price)
        ret = 0
        for p, n in zip(price, needs):
            ret += p * n
            
        for s in special:
            valid = True
            
            for i in range(l):
                needs[i] -= s[i]
                if needs[i] < 0:
                    valid = False

            if valid:
                ret = min(ret, self.shoppingOffers(price, special, needs) + s[-1])
            
            for i in range(l):
                needs[i] += s[i]
        
        return ret
    