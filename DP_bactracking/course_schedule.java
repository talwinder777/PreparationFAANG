//207
//reference video - https://www.youtube.com/watch?v=kXy0ABd1vwo&ab_channel=TECHDOSE
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        
        List<Integer>[] adj = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) { 
            adj[i] = new ArrayList<Integer>(); 
        } 
        
        
        for(int[] pair: prerequisites) {
            
            adj[pair[1]].add(pair[0]);
        }
        
        
//          for (int i = 0; i < numCourses; i++) { 
            
//              System.out.println("i = "+i);
//              for (int j = 0; j < adj[i].size(); j++) {
//                  System.out.println("v = "+adj[i].get(j));
//              }
//         }
        
        int[] colors = new int[numCourses];
        
        //iterate through all courses and do dfs to see is the there is a cycle
        for (int i = 0; i < numCourses; i++) {
            //have not visited this course yet if the colorrs[i] = 0
            if (colors[i] == 0) {
                
                if (isCycle(colors, i, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isCycle(int colors[], int i, List<Integer>[] adj) {
        //2- means in processing state and 1 means processed state
        //if while doing the dfs we reach a node or course which is alreading in processing state and not yet fully processed, we see a cycle
        if (colors[i] == 2) {
            return true;
        }
        
        //mark the current course as being processed 
        colors[i] = 2;
        
        //visit the children if any. This means that we are visited the courses that have to be completed before completing the current course
        
        for (int j = 0; j < adj[i].size(); j++) {
            
            //skip the already processed courses(with color[i] == 1). 
            if (colors[adj[i].get(j)] != 1) {
                
                if (isCycle(colors, adj[i].get(j), adj))
                    return true;
            }
        }
        
        colors[i] = 1;
        //for current course or node we did not find any cycle
        return false;
    }
}
