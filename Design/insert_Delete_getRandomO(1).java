class RandomizedSet {
    Map<Integer , Integer> map;
   List<Integer> list;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(!map.containsKey(val)){
            map.put(val, list.size());
            //adding value in the last
            list.add(list.size(), val);
            return true;
           
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        //getting the index of the element to be deleted from the map
        // and getting the last element from the list to replace the 
        
        int index = map.get(val);
        int le = list.get(list.size() - 1);
        
        //replace the last elements index in map to the index of the val to be deleted
        map.put(le, index);
        list.set(index, le);
        
        //remove the last element from the list as it has been moved to the index where deleted element was present
        //remove the val from thre map
        
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
        
//         int randomNumber = (int) ((Math.random() * (size - 0)) + 0);
//         System.out.print(randomNumber + " " +size);
//         int itr = 0, res = -1;
//         for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            
//             if(itr == randomNumber){
//                 //map.put(entry.getKey(), 1);
//                 res =  entry.getKey();
//                 break;
//             }
//             itr++;
//         }
//         return res;
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */