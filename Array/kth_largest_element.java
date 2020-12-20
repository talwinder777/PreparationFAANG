class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (a-b));
        
        for(int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        
        //I would like to maintain all the k largest elements in the array at current position and would keeo on removin the min elelemnts
        for (int i = k; i < nums.length; i++) {
            
            if(pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        
        return pq.poll();
    }
}