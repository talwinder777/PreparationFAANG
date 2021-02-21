//1381
//simple approach, just use and array and maintain a variable to keep track of the top of stack
class CustomStack {
    
    int[] stack;
    int topIndex;
    int max;
    public CustomStack(int maxSize) {
        
        stack = new int[maxSize];
        topIndex = 0;
        max = maxSize;
    }
    
    public void push(int x) {
        if (topIndex >= max) return;
        stack[topIndex++] = x;
        // System.out.println("push x = "+x+" top = "+topIndex);
    }
    
    public int pop() {
        if(topIndex - 1 < 0) {
            return -1;
        }
        // System.out.println("topIndex = "+topIndex);
        int topEl = stack[topIndex - 1];
        stack[--topIndex] = 0;
        return topEl;
        
    }
    
    public void increment(int k, int val) {
        // System.out.println("topIndex = "+topIndex+" k = "+k);
        for (int i = 0; i < Math.min(topIndex, k); i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
