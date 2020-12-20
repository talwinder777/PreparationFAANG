class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        //sort the intervals acc to start time
        Arrays.sort(intervals, (int a[], int b[]) -> a[0] - b[0]);
        
        //iterate through the list and see 
        //1 -> if the current entry's end date > than
        // the minimum seen end date then allocate the previous room with minimum end
        //date
        //2 -> if the current end date is less than the min end date from the end dates
        //seen so far, increament the room requird counter
        
        if(intervals.length == 0){
            return 0;
        }
        //make a priority queue(min heap) to maintain the end dates seen so far
    
        PriorityQueue<Integer> minDateSoFar = new PriorityQueue<Integer>((a, b) -> a-b);
        
        minDateSoFar.add(intervals[0][1]);
        int roomsReq = 1;
        
        for(int i = 1; i < intervals.length; i++){
            
            if(intervals[i][0] >= minDateSoFar.peek()){
                
                minDateSoFar.poll();
                minDateSoFar.add(intervals[i][1]);
            }
            else{
                roomsReq++;
                minDateSoFar.add(intervals[i][1]);
            }
        }
        return roomsReq;
    }
}