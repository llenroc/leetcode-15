class Solution:
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        import re
        d = {}
        ret = []
        r = re.compile('[(|)]')
        
        for p in paths:
            s = p.split(' ')
            t = s[0] + '/'
            
            for f in s[1:]:
                n, c, _ = r.split(f)
                n = t + n
                try:
                    d[c].append(n)
                except KeyError:
                    d[c] = [n]
                    
        for _, val in d.items():
            if len(val) > 1:
                ret.append(val)
                
        return ret
