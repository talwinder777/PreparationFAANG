class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //we will need stack to find the next greatest element for the current element
        //there are two cases for the current element:
        //1. if for the current ele,  we already have a element greater on the top of stack, then that means we already have the next greatest element
        //2. if on the top of stack we have smaller ele then that means they can not be the next greatest ele for the current element we are looking for, so we would need to pop all the ele from the top of stack untill we reach first greatest ele(index)
        
        int res[] = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        
        for (int i = nums.length * 2 - 1; i >= 0; i-- ){
           
            //corresponds to case no 2
            while(!s.isEmpty() && nums[i % nums.length] >= nums[s.peek()]) {
                
                s.pop();
            }
            //storing the -1 if the stack get empty after first while loop or store the top of stack after reaching the next greatest ele for the current ith position ele(done by the while loop written before)
            res[i % nums.length] = s.isEmpty() ? -1: nums[s.peek()];
            //pushing the index to the stack
            s.push(i % nums.length);
        }
        return res;
        
    }
}
