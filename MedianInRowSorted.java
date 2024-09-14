import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class MedianInRowSorted  {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return parseInt(next());
        }

        long nextLong() {
            return parseLong(next());
        }

        double nextDouble() {
            return parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static final int MOD = 1000000007;

    public static void solve(FastReader sc) {
           int n= sc.nextInt();
           int m= sc.nextInt();
           int[][]arr=new int[n][m];

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                arr[i][j]= sc.nextInt();;
            }
        }
        int low=arr[0][0];
        int req=(m*n)>>1;
        int high=arr[n-1][m-1];
        while (low<=high){
            int mid=low+(high-low)>>1;
            int cnt=blackBox(arr,mid);
            if(cnt<=req){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

    }

    private static int blackBox(int[][] arr, int mid) {
           int cnt=0;
        for (int i = 0; i < arr.length; i++) {
            cnt+=upper_Boudn(arr[i],mid);
        }
        return cnt;
    }

    private static int upper_Boudn(int[] arr, int mid) {
         int ans=0;
        int low=0;
        int high= arr.length;
        while(low<=high){
             int mi=low+(high-low)>>1;
             if(arr[mi]>mid){
                 ans=mi;
                 high=mid-1;

             }else{
                 low=mid+1;
             }
         }
        return ans;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        solve(sc);
    }
}
