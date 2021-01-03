class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        return dfs(rooms, new HashSet<Integer>(){{add(0);}}, 0);
    }
    
    public boolean dfs(List<List<Integer>> rooms, Set<Integer> hs, int start) {
        
        if (hs.size() == rooms.size()) {
            // System.out.println("in");
            return true;
            
        }
        
        List<Integer> neigh = rooms.get(start);
       
        for (int room : neigh) {
            
            if (!hs.contains(room)) {
                hs.add(room);
                
                //if returned answer is true then return true and don't let the program execute the below code or else it will return false
                if(dfs (rooms, hs, room))
                   return true;
            }
        }
                
        return false;
    }
}
