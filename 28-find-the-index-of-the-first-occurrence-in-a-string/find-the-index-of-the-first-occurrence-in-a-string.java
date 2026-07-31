class Solution {
    public int strStr(String haystack, String needle) {

        // If needle is empty, return 0
        if (needle.length() == 0) {
            return 0;
        }

        // Try every possible starting index
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            int j;

            // Compare characters one by one
            for (j = 0; j < needle.length(); j++) {

                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            // If all characters matched
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}