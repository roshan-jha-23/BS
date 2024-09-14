import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class SearchIn2D {

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
         int m=sc.nextInt();
         int[][]a=new int[n][m];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                a[i][j]= sc.nextInt();
            }
        }
        int tar=sc.nextInt();
        boolean flag=false;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                if(a[i][j]==tar){
                    flag=true;
                }
            }
        }
        if(flag){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
        solve2(a,n,m,tar);
    }
    static void solve2(int[][]a,int n,int m,int tar){
        for (int i = 0; i <n; i++) {
            if(bs(a[i],m,tar))break;
        }
    }
  static   boolean bs(int [] arr,int m,int tar){
        int low=0;
        int high=m;
        while(low<=high){
            int mi=low+high/2;
            if(arr[mi]==tar)return true;
            if(arr[mi]>tar){
                high=mi-1;
            }else{
                low=mi+1;
            }
        }
        return false;
    }
    static void solve3(int[][]arr,int n,int m,int tar){
        //flatten a 2d in 1d
        int totalElement=m*n;
        int high=m*(n-1)+n;
        int low=0;
        while (high>=low){
            int mid=(low+high)/2;
            if(arr[mid/m][mid%m]==tar){
                System.out.println(mid);
                break;
            }else if(arr[mid/m][mid%m]>tar){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        System.out.println(-1);
    }
   static int[] solve4(int[][]arr,int t){
        //when row-wise and col-wise sorted
       int row=0;
       int col=arr[0].length-1;
       while(row<arr.length &&col>=0 ){
           if(arr[row][col]==t){
               return new int[]{row,col};
           }else if(arr[row][col]<t){
               row++;
           }else{
               col--;
           }
       }
       return new int[]{-1,-1};
   }
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        solve(sc);
    }
}
