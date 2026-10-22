// Represents one node in the Trie
public class TrieNode {

    // An array of 26 possible children, one for each lowercase letter.
    // children[0] represents 'a', children[1] represents 'b', and so on.
    TrieNode[] children = new TrieNode[26];

    // True if a complete word ends at this node.
    // Initially, no word ends here.
    boolean endOfWord = false;
}


public class PrefixTree {

    // The starting node of the Trie.
    // It does not represent any character.
    private TrieNode root;

    // Creates an empty Trie.
    public PrefixTree() {
        root = new TrieNode();
    }


    // Inserts a word into the Trie.
    public void insert(String word) {

        // Start at the root node.
        TrieNode cur = root;

        // Process each character in the word.
        for (char c : word.toCharArray()) {

            // Convert the character into an index from 0 to 25.
            int i = c - 'a';

            // If the child node for this character doesn't exist,
            // create it.
            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }

            // Move to the child node for the current character.
            cur = cur.children[i];
        }

        // We have processed the entire word.
        // Mark the final node as the end of a complete word.
        cur.endOfWord = true;
    }


    // Returns true if the complete word exists in the Trie.
    public boolean search(String word) {

        // Start at the root node.
        TrieNode cur = root;

        // Process each character in the word.
        for (char c : word.toCharArray()) {

            // Convert the character into an array index.
            int i = c - 'a';

            // If the required child doesn't exist,
            // the word cannot exist in the Trie.
            if (cur.children[i] == null) {
                return false;
            }

            // Move to the next node.
            cur = cur.children[i];
        }

        // All characters were found.
        // But the word exists only if this node marks
        // the end of a complete word.
        return cur.endOfWord;
    }


    // Returns true if any word in the Trie starts with this prefix.
    public boolean startsWith(String prefix) {

        // Start at the root node.
        TrieNode cur = root;

        // Process each character in the prefix.
        for (char c : prefix.toCharArray()) {

            // Convert the character into an array index.
            int i = c - 'a';

            // If a required child doesn't exist,
            // no stored word can have this prefix.
            if (cur.children[i] == null) {
                return false;
            }

            // Move to the next node.
            cur = cur.children[i];
        }

        // Every character in the prefix was found.
        // We don't need endOfWord to be true here.
        return true;
    }
}