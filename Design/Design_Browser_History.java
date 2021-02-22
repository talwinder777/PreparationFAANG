//1472
//can use doubly linked list by making your own custom node
class BrowserHistory {

    List<String> l;
    int cur = 0;
    public BrowserHistory(String homepage) {
        
        l = new ArrayList<>();
        l.add(homepage);
        
    }
    
    public void visit(String url) {
        l.add(cur + 1, url);
        cur += 1;
        while (l.size() > cur + 1) {
            l.remove(l.size() - 1);
        }
    }
    
    public String back(int steps) {
        cur = Math.max(cur - steps, 0);
        return l.get(cur);
        
    }
    
    public String forward(int steps) {
        cur = Math.min(cur + steps, l.size()-1);
        return l.get(cur);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
