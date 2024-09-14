public class MaximizeGasSta {
    public static void main(String[] args) {

    }
}
//class Solution {
//    public static double findSmallestMaxDist(int arr[], int k) {
//        // code here
//        int[] noOfGs=new int[arr.length-1];
//        for(int l=0;l<k;l++){
//            int maxIndex=-1;
//            double maxValue=0.0;
//            for(int i=0;i<arr.length-1;i++){
//                double diff = (double)(arr[i+1] - arr[i]) / (double)(noOfGs[i] + 1);
//
//                if(maxValue<diff){
//                    maxValue=diff;
//                    maxIndex=i;
//                }
//            }
//            noOfGs[maxIndex]++;
//        }
//        double maxi=0;
//        for(int i=0;i<arr.length-1;i++){
//            maxi=Math.max(maxi,(double)(arr[i+1] - arr[i]) / (double)(noOfGs[i] + 1));
//        }
//        return maxi;
//    }
//}
//class Solution {
//
//    public static double findSmallestMaxDist(int[] stations, int k) {
//        PriorityQueue<Pair> pq = new PriorityQueue<>();
//
//        for (int i = 0; i < stations.length - 1; i++) {
//            double diff = stations[i + 1] - stations[i];
//            pq.add(new Pair(diff, i, 1));
//        }
//
//        for (int i = 0; i < k; i++) {
//            Pair item = pq.poll();
//            item.parts++;
//            double newDiff = (stations[item.index + 1] - stations[item.index]) / (double)item.parts;
//            pq.add(new Pair(newDiff, item.index, item.parts));
//        }
//
//        return pq.peek().diff;
//    }
//
//}
//
//class Pair implements Comparable<Pair> {
//    double diff;
//    int index;
//    int parts;
//
//    Pair(double diff, int index, int parts) {
//        this.diff = diff;
//        this.index = index;
//        this.parts = parts;
//    }
//
//    @Override
//    public int compareTo(Pair other) {
//        return Double.compare(other.diff, this.diff);
//    }
//}
