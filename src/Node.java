public class Node {
    boolean isWord;

    // Extended ASCII includes 256 characters, but the first 32 are control characters (unused in words)
    // Saves space by only using 224 characters - 13.5% less space
    Node[] children = new Node[224];

    // Constructor
    public Node() {
        isWord = false;
    }

    // Adds a word to the trie
    public void addWord(String word) {
        // Get current character
        char c = word.charAt(0);
        c-=32;

        // If the current character is not in the trie, add it
        if (children[c] == null) {
            children[c] = new Node();
        }

        // If the word is only one character long, mark it as a word
        if (word.length() == 1) {
            children[c].isWord = true;
        } else {
            // Recursively add the rest of the word
            children[c].addWord(word.substring(1));
        }
    }

    // Looks for a word in the trie
    public boolean findWord(String word) {
        // Get current character
        char c = word.charAt(0);
        c-=32;

        // If the current character is not in the trie, the word is not in the trie
        if (children[c] == null) {
            return false;
        }

        // If the word is only one character long, return whether the current character is a word
        if (word.length() == 1) {
            return children[c].isWord;
        } else {
            // Recursively search for the rest of the word
            return children[c].findWord(word.substring(1));
        }
    }
}
