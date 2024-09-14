import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class KthElementOfTwoSortedArray {

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

    public static void solve(FastReader sc ) {
        // Your solution logic here
        int n= sc.nextInt();
        int m= sc.nextInt();
        int []a1=new int[n];
        int []a2=new int[m];
        for (int i = 0; i <n; i++) {
            a1[i]=sc.nextInt();
        }
        for (int i = 0; i <m; i++) {
            a2[i]=sc.nextInt();
        }
        int k= sc.nextInt();
        int ans =kthSortedElemnt(a1,a2,n,m,k);
        System.out.println(ans);
    }

    private static int kthSortedElemnt(int[] a1, int[] a2, int n, int m,int k) {
        if(n>m)kthSortedElemnt(a2,a1,m,n,k);
        int low=Math.max(0,k-m);
        int high=Math.min(k,n);
        int leftSide=k;
        int tot=n+m;
        while(low<=high){
            int mid1=(low)+(high-low)/2;
            int mid2=leftSide-mid1;

            int l1 = (mid1 > 0) ? a1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? a2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n) ? a1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < m) ? a2[mid2] : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        solve(sc);
    }
}

