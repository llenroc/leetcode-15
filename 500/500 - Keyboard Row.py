class Solution:
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        board = {}
        for i, r in enumerate(['qwertyuiop', 'asdfghjkl', 'zxcvbnm']):
            for c in r:
                board[c] = i
        return [w for w in words if all(board[w[0].lower()] == board[c] for c in w.lower())]