#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

class TrieNode {
public:
    TrieNode* children[26];
    bool end_of_word;

    TrieNode() {
        end_of_word = false;
        for (int i = 0; i < 26; ++i)
            children[i] = nullptr;
    }
};

class Trie {
public:
    TrieNode* root;
    
    Trie() {
        root = new TrieNode();
    }

    void insert(string word) {
        TrieNode* node = root;
        for (char c : word) {
            int idx = c - 'a';
            if (!node->children[idx])
                node->children[idx] = new TrieNode();
            node = node->children[idx];
        }
        node->end_of_word = true;
    }
};

class Solution {
public:
    void dfs(vector<vector<char>>& board, TrieNode* node, int i, int j, string path, unordered_set<string>& result) {
        if (node->end_of_word)
            result.insert(path);

        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size() || board[i][j] == '#')
            return;
        
        char c = board[i][j];
        node = node->children[c - 'a'];
        if (!node)
            return;

        board[i][j] = '#';
        dfs(board, node, i+1, j, path + c, result);
        dfs(board, node, i-1, j, path + c, result);
        dfs(board, node, i, j+1, path + c, result);
        dfs(board, node, i, j-1, path + c, result);
        board[i][j] = c;
    }

    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        Trie trie;
        for (string word : words)
            trie.insert(word);

        unordered_set<string> result;
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[0].size(); ++j) {
                if (trie.root->children[board[i][j] - 'a'])
                    dfs(board, trie.root, i, j, "", result);
            }
        }

        return vector<string>(result.begin(), result.end());
    }
};

int main() {
    vector<vector<char>> board = {
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}
    };
    vector<string> words = {"oath", "pea", "eat", "rain"};
    Solution solution;
    vector<string> foundWords = solution.findWords(board, words);
    for (string word : foundWords) {
        cout << word << " ";
    }
    return 0;
}
