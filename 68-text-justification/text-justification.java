class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {

            // Find how many words fit in one line
            int lineLength = words[i].length();
            int j = i + 1;

            while (j < words.length &&
                    lineLength + 1 + words[j].length() <= maxWidth) {

                lineLength += 1 + words[j].length();
                j++;
            }

            StringBuilder line = new StringBuilder();

            int numberOfWords = j - i;

            // Last line OR only one word
            if (j == words.length || numberOfWords == 1) {

                line.append(words[i]);

                for (int k = i + 1; k < j; k++) {
                    line.append(" ");
                    line.append(words[k]);
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                // Total characters of words only
                int totalChars = 0;
                for (int k = i; k < j; k++) {
                    totalChars += words[k].length();
                }

                int totalSpaces = maxWidth - totalChars;
                int gaps = numberOfWords - 1;

                int evenSpaces = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k != j - 1) {

                        for (int s = 0; s < evenSpaces; s++)
                            line.append(" ");

                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            result.add(line.toString());

            i = j;
        }

        return result;
    }
}