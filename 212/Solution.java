import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.endOfWord = true;
    }
}

public class Solution {
    private void dfs(char[][] board, TrieNode node, int i, int j, String path, Set<String> result) {
        if (node.endOfWord)
            result.add(path);

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#')
            return;

        char c = board[i][j];
        node = node.children[c - 'a'];
        if (node == null)
            return;

        board[i][j] = '#';
        dfs(board, node, i + 1, j, path + c, result);
        dfs(board, node, i - 1, j, path + c, result);
        dfs(board, node, i, j + 1, path + c, result);
        dfs(board, node, i, j - 1, path + c, result);
        board[i][j] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.root.children[board[i][j] - 'a'] != null)
                    dfs(board, trie.root, i, j, "", result);
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> foundWords = solution.findWords(board, words);
        for (String word : foundWords) {
            System.out.println(word);
        }
    }
}

