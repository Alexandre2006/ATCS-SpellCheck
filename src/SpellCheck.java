import java.util.LinkedHashSet;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 * <p>
 * Completed by: Alexandre Haddad-Delaveau
 * */

public class SpellCheck {
    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all misspelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
        // Create root node
        Node rootNode = new Node();
        LinkedHashSet<String> missingWords = new LinkedHashSet<>();

        // Add all dictionary words to trie
        for (String word : dictionary) {
            rootNode.addWord(word);
        }

        // Check each word in the text
        for (String word : text) {
            // If the word is not in the trie, add it to the missing words
            if (!rootNode.findWord(word)) {
                missingWords.add(word);
            }
        }

        // Convert missing words to array
        String[] missingWordsArray = new String[missingWords.size()];
        return missingWords.toArray(missingWordsArray);
    }
}
