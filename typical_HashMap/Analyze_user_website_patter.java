class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
       
        TreeMap<Integer, Pair> map = new TreeMap<>();
        
        int itr = 0;
        for(int time : timestamp) {
            
            map.put(time, new Pair(username[itr], website[itr]));
            itr++;
        }
        
        // System.out.println("sorted time"+map);
        
        
        
        Map<String, List<String>> userWebsites = new HashMap<>();
        
        //int itr = 0;
        for(Map.Entry<Integer,Pair> entry : map.entrySet()) {
            
            String user = entry.getValue().user;
            String websi = entry.getValue().website;
            
            List<String> websites = userWebsites.getOrDefault(user, new ArrayList<>());
            
            // System.out.println("websites = "+websites);
            
            websites.add(websi);
            userWebsites.put(user, websites);
            
            
        
        }
        
        // System.out.println("sorted time"+userWebsites);
        
        Map<String, Set<String>> visits = new HashMap<>();
        
        for (Map.Entry<String,List<String>> entry : userWebsites.entrySet()) {
            
            int len = entry.getValue().size();
            // System.out.println("llist for this user = "+entry.getKey() + " is = "+entry.getValue());
            
            for (int i = 0; i + 2 < len; i++) {
                
                for (int j = i + 1; j + 1 < len; j++) {
                    
                    for (int k = j + 1; k < len; k++) {
                        
                        String threeSeq = entry.getValue().get(i) + ' ' + entry.getValue().get(j) +  ' ' + entry.getValue().get(k);
                        // System.out.println("seq = "+threeSeq);
                        // String user = entry.getKey();
                        Set<String> users = visits.getOrDefault(threeSeq, new HashSet<String>());
                        users.add(entry.getKey());
                        visits.put(threeSeq, users);
                    }
                    
                }
            }
        }
        
        // System.out.println("map = "+userWebsites);
        // System.out.println("visits = "+visits);
        PriorityQueue<Map.Entry<String, Set<String>>> pq = new PriorityQueue<>((a, b) -> (a.getValue().size() == b.getValue().size() ? 
                                                                                     a.getKey().compareTo(b.getKey()): b.getValue().size() - a.getValue().size()) );
        
        for (Map.Entry<String,Set<String>> entry : visits.entrySet()) {
            pq.add(entry);
        }
        
        
        // System.out.println("ans = "+pq.poll());
//         String res = pq.poll().getKey();
        
//         List<String> result = new ArrayList<>();
//         for (String s : res.split(" ")) {
//             result.add(s);
//         }
        return Arrays.asList(pq.poll().getKey().split(" "));
    }
//     public class Pair1 {
//         String threeSeq = "";
//         int count = 0;
        
//         public Pair1(String threeSeq, int count) {
//             this.threeSeq = threeSeq;
//             this.count = count;
//         }
//     }
    
    public class Pair {
        
        String user = "";
        String website = "";
        // int time = 0;
        
        public Pair(String user, String website) {
            this.user = user;
            this.website = website;
            // this.time = time;
        }
    }
}
