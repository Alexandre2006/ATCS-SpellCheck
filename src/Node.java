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
        // Get first character of the word
        char firstChar = word.charAt(0);

        // Check if first character is current character
        if (firstChar == character) {
            // Check if this is the last character in the word
            if (word.length() == 1) {
                isWord = true;
            } else {
                // Otherwise, move to the next character
                String nextWord = word.substring(1);

                // Check if the next character exists
                if (children[1] == null) {
                    children[1] = new Node(word.charAt(1));
                }

                // Add the next character
                children[1].addWord(nextWord);
            }
        }

        // If the first character is less than the current character
        else if (firstChar < character) {
            // Check if the left child exists
            if (children[0] == null) {
                children[0] = new Node(firstChar);
            }

            // Add the word to the left child
            children[0].addWord(word);
        } else {
            // Check if the right child exists
            if (children[2] == null) {
                children[2] = new Node(firstChar);
            }

            // Add the word to the right child
            children[2].addWord(word);
        }
    }

    // Looks for a word in the trie
    public boolean findWord(String word) {
        // Get first character of the word
        char firstChar = word.charAt(0);

        // Check if first character is current character
        if (firstChar == character) {
            // Check if this is the last character in the word
            if (word.length() == 1) {
                return isWord;
            } else {
                // Otherwise, move to the next character
                String nextWord = word.substring(1);

                // Check if the next character exists
                if (children[1] == null) {
                    return false;
                }

                // Find the next character
                return children[1].findWord(nextWord);
            }
        }

        // If the first character is less than the current character
        else if (firstChar < character) {
            // Check if the left child exists
            if (children[0] == null) {
                return false;
            }

            // Find the word in the left child
            return children[0].findWord(word);
        } else {
            // Check if the right child exists
            if (children[2] == null) {
                return false;
            }

            // Find the word in the right child
            return children[2].findWord(word);
        }
    }
}
