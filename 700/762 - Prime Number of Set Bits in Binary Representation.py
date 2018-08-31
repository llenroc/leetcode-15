PRIMES = set([2, 3, 5, 7, 11, 13, 17, 19])

class Solution:
    def countPrimeSetBits(self, L, R):
        """
        :type L: int
        :type R: int
        :rtype: int
        """
        ret = 0
        for i in range(L, R + 1):
            count = 0
            while i:
                count += i & 1
                i >>= 1
            if count in PRIMES:
                ret += 1
        return ret