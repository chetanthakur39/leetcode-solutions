class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char  ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()) return false;

                char opening = stack.pop();

                if(ch == ')' && opening != '(' || ch == '}' && opening != '{' || ch == ']' && opening != '[' ){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}