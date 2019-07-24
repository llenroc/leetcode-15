/*
 * @lc app=leetcode id=126 lang=csharp
 *
 * [126] Word Ladder II
 */

using System.Collections.Generic;

public class Solution {

    private static int CountDiff(string s1, string s2) {
        int ret = 0;
        for (int i = 0; i < s1.Length; ++i) {
            if (s1[i] != s2[i]) {
                ++ret;
            }
        }
        return ret;
    }

    private static void UpdateDict(IDictionary<string, IList<string>> dict, string key, IList<string> wordList) {
        IList<string> words = new List<string>();
        foreach (string word in wordList) {
            if (CountDiff(word, key) == 1) {
                words.Add(word);
            }
        }
        dict[key] = words;
    }

    public IList<IList<string>> FindLadders(string beginWord, string endWord, IList<string> wordList) {
        IList<IList<string>> ret = new List<IList<string>>();
        Queue<IList<string>> queue = new Queue<IList<string>>();
        ISet<string> available = new HashSet<string>(wordList);
        IList<string> used = new List<string>(), first = new List<string>(1);
        int len = 1, minLen = int.MaxValue, n = beginWord.Length;

        var edges = new Dictionary<string, IList<string>>();
        UpdateDict(edges, beginWord, wordList);
        foreach (string word in wordList) {
            UpdateDict(edges, word, wordList);
        }

        first.Add(beginWord);
        queue.Enqueue(first);
        while (queue.Count > 0) {
            var curr = queue.Dequeue();
            if (curr.Count > len) {
                if (curr.Count > minLen) {
                    break;
                }
                foreach (string word in used) {
                    available.Remove(word);
                }
                used.Clear();
                len = curr.Count;
            }
            if (curr.Count == minLen) {
                if (edges[curr[curr.Count - 1]].Contains(endWord)) {
                    curr.Add(endWord);
                    ret.Add(curr);
                }
                continue;
            }
            foreach (string nextWord in edges[curr[curr.Count - 1]]) {
                if (!available.Contains(nextWord)) {
                    continue;
                }
                if (nextWord == endWord) {
                    curr.Add(endWord);
                    ret.Add(curr);
                    minLen = len;
                } else {
                    var next = new List<string>(curr);
                    used.Add(nextWord);
                    next.Add(nextWord);
                    queue.Enqueue(next);
                }
            }
        }
        return ret;
    }
}

