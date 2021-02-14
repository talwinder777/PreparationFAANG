//394
class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            //push everything until ]
            if(s.charAt(i) != ']'){
                st.push(s.charAt(i));
            }
            else{
                //building up the string
                String curr = "";
                while(st.peek() != '['){
                    curr = st.pop() + curr;
                }
                
                st.pop();//removes the ] bracket
                
                //building the number
                String number = "";
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    number = st.pop() + number;
                }
                
                int num = Integer.valueOf(number);
                //pushing the string back to stack num number of times. suppose curr = s and num = 3 then a is pushed 3 times
                while(num-- > 0){
                    
                    for(int j = 0; j < curr.length(); j++){
                        st.push(curr.charAt(j));
                    }
                }
            }
            
        }
        String res = "";
        while(!st.isEmpty()){
            res = st.pop() + res;
        }
        return res;
    }
}
