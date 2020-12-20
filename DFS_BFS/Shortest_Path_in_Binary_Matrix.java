//Leetcode Shortest Path in Binary Matrix 1091

class Solution {
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] == 1) {
            return -1;
        }
        
        int[][] dirs = {{1,0},{0, 1}, {1,1}, {0,-1}, {-1,0}, {-1,-1}, {-1,1}, {1,-1}};
        
        Queue<Point> q = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        q.add(new Point(0, 0));
        map.put((0+""+0), 1);
        // System.out.println(map);
        // System.out.println(map.get("00"));
        while(!q.isEmpty()) {
            
            Point point = q.poll();
            
            if(point.r == grid.length-1 && point.c == grid.length - 1) {
                return map.get((point.r+""+point.c));
            }
            
            for(int[] dir : dirs) {
                
                int r = point.r + dir[0];
                int c = point.c + dir[1];
                
                Point newPoint = new Point(r,c);
                if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||  grid[r][c] == 1) {
                    continue;
                }
                
                if(!map.containsKey((r+""+c))) {
                    q.add(newPoint);
//                     System.out.println("map = "+map);
//                     System.out.println("r = "+r+" c = "+c);
                    
                    //int dist = map.get((r+""+c));
                    map.put((r+""+c), map.get(point.r+""+point.c) + 1);
                }
            }
        }
        
        return -1;
    }
    
    public class Point {
        int r; int c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}