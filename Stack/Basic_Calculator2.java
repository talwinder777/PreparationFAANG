//Leetcode 227
//iterate over the string and if there is a digit then check if there are more digits followed by that digit. If so then iterate over those digits and form the //number.
//If the character is not a digit and its a sign then preserve that sign for the operation to be performed on the following digit.
//If the preserved sign is positive or negative then add the number(formed from digit/digits) to the stack along with the sign.
//If the preserved sign is multiply or divide then you can perform the operation and then store it in the stack because multiply and divide precede over add and /subtract.
//finally IIterate over the stack and add all the results
class Solution {
    public int calculate(String s) {
        
        char sign = '+';
        s = s.replaceAll(" ","");
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            
            if(!Character.isDigit(s.charAt(i))){
                sign = s.charAt(i);
                continue;
            }
            
            String num = s.charAt(i)+"";
            while(i + 1 < s.length() && Character.isDigit(s.charAt(i)) && Character.isDigit(s.charAt(i+1))){
                num += s.charAt(i+1);
                i++;
            }
        
            if(Character.isDigit(s.charAt(i))){
                //need not to perform operation on + and -,just add them to stack
                int number = Integer.parseInt(num);
                if(sign == '-') st.add(number * -1);
                else if(sign == '*') st.add(st.pop() * number);
                else if(sign == '/') st.add(st.pop() / number);
                else
                    st.add(number);
                
            }
            
        }
        
        int result = 0;
        //adding all the number in stack. By this time I would have only positive or negative number in stack so just add those to the result;
        while(!st.isEmpty()){
            int val = st.pop();
            result += val;
        }
        return result;
    }
}