import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class MedianProbs {

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

    public static void solve1( FastReader sc) {
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
        int []ans=new int[m+n];
        int i=0;
        int j=0;
        int ind=0;
        while (i<n && j<n){
            if(a1[i]<a2[j]){
                ans[ind++]=a1[i];
                i++;
            }else {
                ans[ind++]=a2[j];
                j++;
            }
        }
        while(i<n){
            ans[ind++]=a1[i++];
        }
        while(j<m){
            ans[ind++]=a2[j++];
        }
        if((m+n)%2==0){
            System.out.println(ans[(m+n-1)/2]+" "+ans[(m+n+1)/2]);
        }else{
            System.out.println(ans[(m+n)/2]);
        }
    }
    public static void solve( FastReader sc) {
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
        findMedianSortedArrays(a1,a2);

    }
    public static double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        if (n1 > n2) return findMedianSortedArrays(b, a);

        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2;
        int n = n1 + n2;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0.0;
    }

    public static void solve2( FastReader sc) {
    //let s try to optimize
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
        int i=0;
        int j=0;
        int idx=0;
        int tot=(m+n);
       int medidx=-1;
       int medidx1=-1;
        int ans=0;
        if(tot%2==0){
            medidx=((m+n-1)/2);
            medidx1=((m+n+1)/2);
        }else{
            medidx=(m+n/2);
        }
        while(i<n && j<m) {
            if (a1[i] < a2[j]) {
                i++;
                idx++;
                if (medidx == idx) {
                    ans += a1[i-1];
                    if (medidx1 == -1) break;
                }
                if (medidx1 == idx) {
                    ans += a1[i-1];
                }
            } else {
                j++;
                idx++;
                if (medidx == idx) {
                    ans += a2[j-1];
                    if (medidx1 == -1) break;
                }
                if (medidx1 == idx) {
                    ans += a2[j-1];
                }
            }
        }
            while(i<n){
                i++;
                idx++;
                if(medidx==idx){
                    ans+=a1[i-1];
                    if(medidx1==-1)break;
                }
                if(medidx1==idx){
                    ans+=a1[i-1];
                }
            }
            while(j<m){
                j++;
                idx++;
                if(medidx==idx){
                    ans+=a2[j-1];
                    if(medidx1==-1)break;
                }
                if(medidx1==idx){
                    ans+=a2[j-1];
                }
            }
            if(medidx1==-1){
                System.out.println(ans);
            }else{
                System.out.println(ans/2);
            }


    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        solve1(sc);
    }
}
