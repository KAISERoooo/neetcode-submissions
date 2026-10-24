class MedianFinder {
    ArrayList<Integer> res;
    public MedianFinder() {
       res = new ArrayList<>();
    }
    
    public void addNum(int num) {
        res.add(num);
    }
    
    public double findMedian() {
        Collections.sort(res);
        int n = res.size();
        if( n % 2 == 0){
            return (res.get(n/2) + res.get(n/2 - 1 ))/2.0;

        }
        else {
            return res.get(n/2);
        }

    }
}
