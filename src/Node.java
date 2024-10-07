public class Node {
    boolean isWord;
    char character;
    Node[] children = new Node[3];

    // Constructor
    public Node(char character) {
        isWord = false;
        this.character = character;
    }

    // Adds a word to the trie
    public void addWord(String word) {
        // Keep track of the current node
        Node currentNode = this;

        // Iterate through the word
        for (int i = 0; i < word.length(); i++) {
            // Get current character
            char currentChar = word.charAt(i);

            // Loop until next character is found, or if it is not found, where to add it
            while (currentChar != currentNode.character) {
                // If the next character is less than the current character, add it to the left
                if (currentChar < currentNode.character) {
                    if (currentNode.children[0] == null) {
                        currentNode.children[0] = new Node(currentChar);
                    }
                    currentNode = currentNode.children[0];
                }
                // If the next character is greater than the current character, add it to the right
                else {
                    if (currentNode.children[2] == null) {
                        currentNode.children[2] = new Node(currentChar);
                    }
                    currentNode = currentNode.children[2];
                }
            }

            // When found, move down to middle child (if word is not finished)
            if (i < word.length() - 1) {
                if (currentNode.children[1] == null) {
                    currentNode.children[1] = new Node(word.charAt(i + 1));
                }
                currentNode = currentNode.children[1];
            }
        }

        // Once the end of the word is reached, mark the node as a word
        currentNode.isWord = true;
    }

    // Looks for a word in the trie
    public boolean findWord(String word) {
        // Keep track of the current node
        Node currentNode = this;

        // Iterate through the word
        for (int i = 0; i < word.length(); i++) {
            // Get current character
            char currentChar = word.charAt(i);

            // Loop until next character is found, or if it is not found, return false
            while (currentChar != currentNode.character) {
                // If the next character is less than the current character, return false
                if (currentChar < currentNode.character) {
                    if (currentNode.children[0] == null) {
                        return false;
                    }
                    currentNode = currentNode.children[0];
                }
                // If the next character is greater than the current character, return false
                else {
                    if (currentNode.children[2] == null) {
                        return false;
                    }
                    currentNode = currentNode.children[2];
                }
            }

            // When found, move down to middle child (if word is not finished)
            if (i < word.length() - 1) {
                if (currentNode.children[1] == null) {
                    return false;
                }
                currentNode = currentNode.children[1];
            }
        }

        // Once the end of the word is reached, return if the node is a word
        return currentNode.isWord;
    }
}
