import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
        // Create HashSet with dictionary words
        HashSet<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));

        // Keep track of invalid words with a LinkedHashSet (preserves order)
        LinkedHashSet<String> missingWords = new LinkedHashSet<>();

        // Loop through all words in text to find missing words
        for (String word : text) {
            // Check if dictionary contains word
            if (!dictionarySet.contains(word)) {
                // If it does not contain the word, add the word to the missingWords set
                missingWords.add(word);
            }
        }

        // Return missing words as array
        String[] missingWordsArray = new String[missingWords.size()];
        return missingWords.toArray(missingWordsArray);
    }
}
