//406
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, new Comparator<int[]>() {
           
            public int compare(int[] e1, int[] e2) {
                
                return e1[0] == e2[0] ? e1[1] - e2[1] : e2[0] - e1[0];
            }
        });
        
        List<int[]> output = new LinkedList<>();
        
        for(int[] p : people) {
            // System.out.println("p0 = "+p[0]+" p1 = "+p[1]);
            output.add(p[1], p);
        }
        
        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}
