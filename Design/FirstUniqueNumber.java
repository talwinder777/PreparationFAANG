class FirstUnique {
    /*
    
    getting the first unique number implies something similar to FIFO technique
    we have to remove the first unique number that we see in the given array (represents    line)
    
    We would maintain a queue to get the FUN(FirstUniqueNUmber) and map to store the occuences of the number
    
    always looking at top of queue if the element is still unique at this point by seeing its occurence in map, if this is the case then return this elemnet and NOTE REMOVE since the same number can be unique in future
    
    
    
    */
    HashMap<Integer, Integer> map;
    Queue<Integer> q;
    
    public FirstUnique(int[] nums) {
        
        map = new HashMap<>();
        q = new LinkedList<>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
            if(map.get(nums[i]) == 1) {
                q.add(nums[i]);
            }
        }
    }
    
    public int showFirstUnique() {
        
        while(!q.isEmpty()) {
            
            if(map.get(q.peek()) == 1){
                return q.peek();
            }
            q.poll();
        }
        return -1;
    }
    
    public void add(int value) {
        
        map.put(value, map.getOrDefault(value, 0) + 1);
            
        if(map.get(value) == 1) {
            q.add(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */