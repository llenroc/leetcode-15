class RandomizedSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.h = dict()
        self.l = []
        

    def insert(self, val):
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        if val in self.h:
            return False
        else:
            self.h[val] = len(self.l)
            self.l += [val]
            return True
        

    def remove(self, val):
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        :type val: int
        :rtype: bool
        """
        try:
            old_i = self.h[val]
            if old_i is not len(self.l) - 1:
                self.l[old_i] = self.l[len(self.l) - 1]
                self.h[self.l[old_i]] = old_i
            self.l.pop()
            self.h.pop(val, None)
            return True
        except:
            return False
        

    def getRandom(self):
        """
        Get a random element from the set.
        :rtype: int
        """
        if not len(self.l):
            return None
        return self.l[random.randint(0, len(self.l) - 1)]
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
