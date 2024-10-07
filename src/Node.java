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
        Node currentNode = this;

        // Loop over each letter
        for (int i = 0; i < word.length(); i++) {
            // Get the current character
            char c = word.charAt(i);
            c-=32;

            // If the character is not in the trie, add it
            if (currentNode.children[c] == null) {
                currentNode.children[c] = new Node();
            }

            // Move to the next node
            currentNode = currentNode.children[c];
        }

        // Mark the end of the word
        currentNode.isWord = true;
    }

    // Looks for a word in the trie
    public boolean findWord(String word) {
        Node currentNode = this;

        // Loop over each letter
        for (int i = 0; i < word.length(); i++) {
            // Get the current character
            char c = word.charAt(i);
            c-=32;

            // Exit early if current character is not in the trie
            if (currentNode.children[c] == null) {
                return false;
            }

            // Move to the next node
            currentNode = currentNode.children[c];
        }

        // Return whether the word is in the trie
        return currentNode.isWord;
    }
}
