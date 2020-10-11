/*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.



Example:

Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.


Note:

1 <= paragraph.length <= 1000.
0 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

class MostCommonWord {
    public static String mostCommonWord(String para, String[] banned) {
        /*
          iterate through the tokens, put it in a hashtable
          hashtable (token key, frequency)

          eliminate banned words by iterating through the banned words array and removing them from hashtable

          Find the key with the max frequency and return it.
        */

        String[] tokens = para.split(",|\\s+");

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String token : tokens) {
            token = token.toLowerCase();
            Integer count = map.get(token);
            if ( count == null) {
                map.put(token, 1);
            } else {
                map.put(token, count+1);
            }
        }

        eliminateBanned(map, banned);
        int max = 0;
        String maxString = "";
        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxString = entry.getKey();
            }
        }
        return maxString;
    }

    public static void eliminateBanned(Map<String, Integer> map, String[] banned) {
        for (String ban : banned) {
            map.remove(ban);
        }
    }

    public static class Unittest{
        @Test
        public void testMostCommon() {
            String para = "Bob hit a ball, the hit BALL flew far after it was hit.";
            String[] banned = {"hit"};
            String expected = "ball";
            String mostCommon = MostCommonWord.mostCommonWord(para, banned);
            Assert.assertEquals(expected, mostCommon);
        }
    }
}