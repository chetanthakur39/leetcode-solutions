class Solution {
    public String longestCommonPrefix(String[] strs) {
      
    if (strs == null || strs.length == 0){
        return "";
    }

        String prefix = strs[0];

        for(int i=1;i<strs.length;i++){
            String word = strs[i];
            int j=0;
          StringBuilder temp = new StringBuilder();
            while(j<word.length() && j < prefix.length() && word.charAt(j) == prefix.charAt(j)){
                 temp.append(word.charAt(j));
                 j++;
            }
            prefix = temp.toString();

        }
        return prefix;
    }
}

       