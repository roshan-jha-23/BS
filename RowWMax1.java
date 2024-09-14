import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class RowWMax1 {

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
        // Your solution logic here
        int m= sc.nextInt();
        int n= sc.nextInt();
        int [][] arr=new int[n][m];
        int max=0;
        int index=-1;
        for (int i = 0; i <n; i++) {
            int cnt=m-firstOccurrence(arr[i],m,1);
            if(cnt>max){
                max=cnt;
                index=i;
            }
        }
        System.out.println(index);

    }
  static   int firstOccurrence(int [] arr ,int n,int tar){
        int l=0;
        int h=n-1;
        int f=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(arr[m]==tar){
                f=m;
                h=m-1;
            }else if(arr[m]<tar){
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return f;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        solve(sc);
    }
}
