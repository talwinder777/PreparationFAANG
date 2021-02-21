//950
//The concept here was how we can maintain the ordering of the indexs which here is done by deque  
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            dq.add(i);
        }
        
        int[] res = new int[deck.length];
        Arrays.sort(deck);
        
        for(int card: deck) {
            res[dq.pollFirst()] = card;
            
            //means there are some unrevealed indexes still left
            if (!dq.isEmpty()) {
                dq.add(dq.pollFirst());
            }
        }
        
        return res;
    }
}
