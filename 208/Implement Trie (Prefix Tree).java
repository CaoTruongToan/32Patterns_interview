import java.util.HashMap;
import java.util.Map;

class TrieNode {
    boolean isEnd;
    Map<Character, TrieNode> children;

    TrieNode() {
        isEnd = false;
        children = new HashMap<>();
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return null;
            }
            node = node.children.get(c);
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("táo");
        System.out.println(trie.search("táo"));     
        System.out.println(trie.search("ứng dụng")); 
        System.out.println(trie.startsWith("ứng dụng")); 
    }
}
