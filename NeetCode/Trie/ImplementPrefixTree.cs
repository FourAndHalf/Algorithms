
/**
 * Implement Prefix Tree
 *
 * A prefix tree (also known as a trie) is a tree data structure used to efficiently store and retrieve keys in a set of strings. 
 * Some applications of this data structure include auto-complete and spell checker systems.
 *
 * Implement the PrefixTree class:
 *
 *  PrefixTree(): Initializes the prefix tree object.
 *  void insert(String word): Inserts the string word into the prefix tree.
 *  boolean search(String word): Returns true if the string word is in the prefix tree (i.e., was inserted before), and false otherwise.
 *  boolean startsWith(String prefix): Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 * Input: 
 * ["Trie", "insert", "dog", "search", "dog", "search", "do", "startsWith", "do", "insert", "do", "search", "do"]
 * 
 * Output:
 * [null, null, true, false, true, null, true]
 *
 * Explanation:
 * PrefixTree prefixTree = new PrefixTree();
 * prefixTree.insert("dog");
 * prefixTree.search("dog");    // return true
 * prefixTree.search("do");     // return false
 * prefixTree.startsWith("do"); // return true
 * prefixTree.insert("do");
 * prefixTree.search("do");     // return true
 *
 * Time Complexity: O(n) time for each function n: Length of the given string
 * Space Complexity: O(k) k: Total number of nodes created in trie
 *
*/

/*
 * Implementation of the function using a hashmap
 *
 * Time Complexity: O(n) time for each function n: Length of the given string
 * Space Complexity: O(k) k: Total number of nodes created in trie
 *
*/

public class TrieNode {
    public Dictionary<char, TrieNode> children = new Dictionary<char, TrieNode>();
    public bool endOfWord = false;
}

public class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();    
    }
    
    public void Insert(string word) {
        TrieNode cur = root;
        foreach (char c in word) {
            if (!cur.children.ContainsKey(c)) {
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        cur.endOfWord = true;
    }
    
    public bool Search(string word) {
        TrieNode cur = root;
        foreach(char c in word) {            
            if (!cur.children.ContainsKey(c))
                return false;
            
            cur = cur.children[c];
        }
        return cur.endOfWord;
    }
    
    public bool StartsWith(string prefix) {
        TrieNode cur = root;
        foreach (char c in prefix) {
            if (!cur.children.ContainsKey(c))
                return false;

            cur = cur.children[c];    
        }
        return true;
    }
}


/*
 * Implementation of the solution using an array
 *
 * Time Complexity: O(n) time for each function n: Length of the given string
 * Space Complexity: O(k) k: Total number of nodes created in trie
 *
*/

public class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public bool endOfWord = false;
}

public class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();    
    }
    
    public void Insert(string word) {
        TrieNode cur = root;
        foreach (char c in word) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.endOfWord = true;
    }
    
    public bool Search(string word) {
        TrieNode cur = root;
        foreach(char c in word) {
            int i = c - 'a';
            if (cur.children[i] == null)
                return false;
            
            cur = cur.children[i];
        }
        return cur.endOfWord;
    }
    
    public bool StartsWith(string prefix) {
        TrieNode cur = root;
        foreach (char c in prefix) {
            int i = c - 'a';
            if (cur.children[i] == null)
                return false;

            cur = cur.children[i];    
        }
        return true;
    }
}

