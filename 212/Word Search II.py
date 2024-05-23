class TrieNode:
    def __init__(self):
        self.children = {}
        self.end_of_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.end_of_word = True

def findWords(board, words):
    def dfs(node, i, j, path):
        if node.end_of_word:
            result.add(path)
        if not (0 <= i < len(board)) or not (0 <= j < len(board[0])) or board[i][j] not in node.children:
            return
        char = board[i][j]
        board[i][j] = '#'
        for x, y in [(0,1), (1,0), (0,-1), (-1,0)]:
            dfs(node.children[char], i + x, j + y, path + char)
        board[i][j] = char

    trie = Trie()
    for word in words:
        trie.insert(word)
    
    result = set()
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] in trie.root.children:
                dfs(trie.root, i, j, "")
    
    return list(result)

board = [['o', 'a', 'a', 'n'],
         ['e', 't', 'a', 'e'],
         ['i', 'h', 'k', 'r'],
         ['i', 'f', 'l', 'v']]

words = ["oath", "pea", "eat", "rain"]
print(findWords(board, words))
