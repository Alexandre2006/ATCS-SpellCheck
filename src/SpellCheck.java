import java.util.ArrayList;
import java.util.Arrays;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Alexandre Haddad-Delaveau
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
        // Parse dictionary into graph
        SpellCheckNode node = SpellCheckNode.convertFromDictionary(dictionary);

        // Store missing words
        ArrayList<String> missingWords = new ArrayList<>();

        // Loop through all words in text, checking if they are valid
        for (String word : text) {
            // Lowercase word
            String lowercaseWord = word.toLowerCase();

            // Check for validity
            if (!node.isWord(lowercaseWord)) {
                // Check if word is already in incorrectWords array
                if (!missingWords.contains(lowercaseWord)) {
                    missingWords.add(lowercaseWord);
                }
            }
        }

        // Return missing words
        String[] missingWordsArray = new String[missingWords.size()];
        return missingWords.toArray(missingWordsArray);
    }
}
