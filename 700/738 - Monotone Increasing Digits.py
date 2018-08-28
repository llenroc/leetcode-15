class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        s = list(str(N))
        l = len(s)
        x = l
        
        for i in range(l - 1, 0, -1):
            if s[i] >= s[i - 1]:
                continue
            s[i - 1] = chr(ord(s[i - 1]) - 1)
            x = i
        
        for i in range(x, l):
            s[i] = '9'
        
        return int(''.join(s))