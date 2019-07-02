/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 *
 * autogenerated using scripts/convert.py
 */
import java.util.HashMap;
import java.util.Stack;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode curr, currClone, next, nextClone, random, randomClone;
        Stack<RandomListNode> stack = new Stack<RandomListNode>();
        
        if (head == null)
            return null;
        stack.push(head);
        
        while (! stack.empty()) {
            curr = stack.pop();
            
            if ((currClone = hm.get(curr)) == null) {
                currClone = new RandomListNode(curr.label);
                hm.put(curr, currClone);
            }
            
            if ((next = curr.next) != null) {
                if ((nextClone = hm.get(next)) == null) {
                    nextClone = new RandomListNode(next.label);
                    hm.put(next, nextClone);
                    stack.push(next);
                }
                currClone.next = nextClone;
            }
            
            if ((random = curr.random) != null) {
                if ((randomClone = hm.get(random)) == null) {
                    randomClone = new RandomListNode(random.label);
                    hm.put(random, randomClone);
                    stack.push(random);
                }
                currClone.random = randomClone;
            }
        }
        
        return hm.get(head);
    }
}