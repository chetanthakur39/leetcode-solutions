import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        // Frequency of characters required from t
        Map<Character, Integer> target = new HashMap<>();

        for (char ch : t.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }

        // Frequency of characters inside current window
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;

        // Number of unique characters whose required frequency is satisfied
        int formed = 0;

        // Number of unique characters we need to satisfy
        int required = target.size();

        // Store minimum window
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {

            // Add current right character
            char rightChar = s.charAt(right);

            window.put(
                rightChar,
                window.getOrDefault(rightChar, 0) + 1
            );

            // If this character has reached its required frequency
            if (target.containsKey(rightChar)
                    && window.get(rightChar).intValue()
                    == target.get(rightChar).intValue()) {

                formed++;
            }

            // Current window is valid
            while (formed == required) {

                // Update minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);

                window.put(
                    leftChar,
                    window.get(leftChar) - 1
                );

                // If removing this character makes
                // the window invalid
                if (target.containsKey(leftChar)
                        && window.get(leftChar) < target.get(leftChar)) {

                    formed--;
                }

                left++;
            }

            right++;
        }

        // No valid window found
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLength);
    }
}


