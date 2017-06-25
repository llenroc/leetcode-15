# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        d1 = []
        d2 = []
        curr = l1
        while (curr):
            d1.append(curr.val)
            curr = curr.next
        curr = l2
        while (curr):
            d2.append(curr.val)
            curr = curr.next
        if len(d1) > len(d2):
            l = d1
            s = d2
        else:
            l = d2
            s = d1
        s.extend([0] * (len(l) - len(s)))
        t = [x + y for x, y in zip(l, s)]
        print(t)
        prev = None
        head = None
        curr = None
        a = 0
        for v in t:
            k = v + a
            a = (k >= 10)
            k -= a * 10
            curr = ListNode(k)
            if prev:
                prev.next = curr
            else:
                head = curr
            prev = curr
        if a:
            prev.next = ListNode(1)
        return head
        