//362
class HitCounter {

    /** Initialize your data structure here. */
    int counter = 0;
    int lastTimeStamp = 0;
    TreeMap<Integer, Integer> map;
    public HitCounter() {
        
        map = new TreeMap<>();
        map.put(0, 0);
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        //add the timpestamp and the counter values associated with it in the map
        counter += 1; 
        map.put(timestamp, counter);
        
        //need to maintain the last timestamp so that we can want to remove the 300 s from this timestamp to get the result by substracting the hits from the lasttimestamp and the correspoding timestamp 5 minutes before
        lastTimeStamp = timestamp;
        
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        
        
        if (timestamp - 300 < 0) {
            
            return map.get(lastTimeStamp);
        }
        
        int lasthits = map.get(lastTimeStamp);
        //If the difference is not present in the map then move back to the timestamp smaller than than the diff
        if(!map.containsKey(timestamp - 300)){
            
            //get the lists from map so we can traverse map backwards
            ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
            
            int i;
            for(i=keys.size()-1; i>=0;i--){

                
                if (keys.get(i) >=  (timestamp - 300)){
                    continue;
                }
                else{
                    break;
                }
            }
            
            //substracting the hits
            return lasthits - map.get(keys.get(i));
        }
        
        int fiveMinutesBefore = map.get(timestamp - 300);
        
        return lasthits - fiveMinutesBefore;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
