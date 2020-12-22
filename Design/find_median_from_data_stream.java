class MedianFinder {

    /** initialize your data structure here. */
    List<Integer> stream;
    public MedianFinder() {
        stream = new ArrayList<>();
    }
    
    public void addNum(int num) {
        
        if (stream.isEmpty()) {
            stream.add(num);
        }
        else {
            
            stream.add(binarySearch(stream, num, 0, stream.size()), num);
        }
    }
    
    public double findMedian() {
        int size = stream.size();
        // System.out.println("list = "+stream);
        return size % 2 == 0? (stream.get((size / 2) - 1) + stream.get(size/2)) / 2.0: stream.get(size/2); 
    }
    
    public int binarySearch(List<Integer> list, int num, int l, int h) {
        
        if(l >= h){
            return l;
        }
        
        int mid = l + ((h - l) / 2);
        
        if (list.get(mid) <= num)
            return binarySearch(list, num, mid + 1, h);
        else
            return binarySearch(list, num, l, mid);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
