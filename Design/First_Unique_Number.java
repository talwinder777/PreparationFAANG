//Leetcode 1429
class FirstUnique {
    
    List<Integer> l;
    HashMap<Integer, Integer> map;
    int itr = 0;
    public FirstUnique(int[] nums) {
        l = new ArrayList<>();
        map = new HashMap<>();
        
        for (int num: nums) {
            l.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // System.out.println(map);
    }
    
    public int showFirstUnique() {
        
        while(itr < l.size() && map.get(l.get(itr)) != 1) {
            itr++;
        }
        
        if(itr < l.size()) {
            return l.get(itr);
        }
        
        return -1;
    }
    
    public void add(int value) {
        l.add(value);
        map.put(value, map.getOrDefault(value, 0) + 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */

