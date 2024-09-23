import java.util.ArrayList;
import java.util.Arrays;

public class SpellCheckNode {
    private final boolean isWord;
    private final SpellCheckNode[] children;

    private SpellCheckNode(boolean isWord) {
        this.isWord = isWord;
        // TODO: Find solution to only use 26 letters
        this.children = new SpellCheckNode[256];
    }

    // TODO: Convert to iterative rather than recursive
    private void addWordString(String word) {
        // Separate word into characters
        char[] letters = word.toCharArray();

        // Send to addWordChars
        addWordChars(letters);
    }

    private void addWordChars(char[] word) {
        // Pick first letter
        char firstLetter = word[0];

        // Verify node exists
        if (children[firstLetter] == null) {
            children[firstLetter] = new SpellCheckNode(word.length == 1);
        }

        if (word.length != 1) {
            children[firstLetter].addWordChars(Arrays.copyOfRange(word, 1, word.length));
        }
    }

    static SpellCheckNode convertFromDictionary(String[] dictionary) {
        // Create root node
        SpellCheckNode rootNode = new SpellCheckNode(false);

        // Add all words from dictionary
        for (String word : dictionary) {
            rootNode.addWordString(word);
        }

        // Return root node
        return rootNode;
    }

    // TODO: Convert to iterative rather than recursive
    private boolean isWordChars(char[] word) {
        // Pick first letter
        char firstLetter = word[0];

        if (children[firstLetter] != null) {
            if (word.length == 1) {
                return children[firstLetter].isWord;
            }

            return children[firstLetter].isWordChars(Arrays.copyOfRange(word, 1, word.length));
        } else {
            return false;
        }
    }

    public boolean isWord(String word) {
        // Convert to chars
        char[] letters = word.toCharArray();

        // Return existence
        return isWordChars(letters);
    }
}
