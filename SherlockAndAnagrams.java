import java.util.*;

public class SherlockAndAnagrams {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("cdcd"));
    }

    public static int sherlockAndAnagrams(String s) {
        if (s.isEmpty()) return 0;

        int anagramCounter = 0;
        Map<String, Integer> repeatedFirm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {

                char[] orderedSubstring = s.substring(i, j).toCharArray();
                Arrays.sort(orderedSubstring);
                String key = new String(orderedSubstring);

                Integer frequency = repeatedFirm.get(key);
                if (frequency == null) continue;

                repeatedFirm.put(key, frequency + 1);
             }
        }

        for (Integer value : repeatedFirm.values()) {
            anagramCounter += value * (value - 1);
        }

        return anagramCounter;
    }
}
