class Solution {
    public String reverseWords(String s) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder word = new StringBuilder();

       
       for(int i =0;i<=s.length()-1;i++){
             if(s.charAt(i) == ' '){
                if(word.length() > 0){
                    list.add(word.toString());
                    word.setLength(0);
                }
             }
                else{
                    word.append(s.charAt(i));
                }
             }
          // to add last word
          if(word.length() > 0){
            list.add(word.toString());
          }

          StringBuilder ans = new StringBuilder();
          
    for(int i=list.size()-1;i>=0;i--){
       ans.append(list.get(i));

       if(i!=0){
          ans.append(" ");
       }
    }

    return ans.toString();

        
         
    }
}