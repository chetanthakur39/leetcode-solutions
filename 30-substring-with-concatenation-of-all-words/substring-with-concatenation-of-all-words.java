class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        if (s == null || s.length() == 0 || words.length == 0)
            return ans;

        int wordLength = words[0].length();
        int numberOfWords = words.length;
        int windowLength = wordLength * numberOfWords;

        // Step 1: Expected Frequency Map
        HashMap<String, Integer> expected = new HashMap<>();

        for (String word : words) {
            expected.put(word, expected.getOrDefault(word, 0) + 1);
        }

        // Step 2: Check every possible starting index
        for (int start = 0; start <= s.length() - windowLength; start++) {

            HashMap<String, Integer> current = new HashMap<>();

            // Step 3: Read every word inside current window
            for (int j = 0; j < numberOfWords; j++) {

                int left = start + j * wordLength;
                int right = left + wordLength;

                String word = s.substring(left, right);

                current.put(word, current.getOrDefault(word, 0) + 1);
            }

            // Step 4: Compare maps
            if (current.equals(expected)) {
                ans.add(start);
            }
        }

        return ans;
    }
}