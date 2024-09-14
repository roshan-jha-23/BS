import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class Peak2 {

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
       int n=sc.nextInt();
       int m=sc.nextInt();
       int [][] arr=new int[n][m];
       int low=0;
       int high=m;
       while (low<=high){
           int mid=low+high/2;
           int row=fxn(mid,arr,n,m);
           if(arr[row][mid]>arr[row-1][mid]&&arr[row][mid]>arr[row+1][mid]&&arr[row][mid]>arr[row][mid-1]&&arr[row][mid]>arr[row][mid+1]) {
               System.out.println(arr[row][mid]);
               return;
           }
               else if(arr[row][mid]<arr[row][mid-1]){
                   high=mid-1;
           }else{
                   low=mid+1;
           }
       }
    }

    private static int fxn(int mid, int[][] arr, int n, int m) {
        int maxi=-1;
        int index=-1;
        for(int i=0;i<n;i++){
            if(arr[i][mid]>maxi){
                maxi=arr[i][mid];
                index=i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        solve(sc);
    }
}
