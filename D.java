import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int n = Integer.parseInt(br.readLine());
//        String elm = br.readLine();
//
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt("" + elm.charAt(i));
//        }
//
//        int ans = 0;
//
//        if (n == 1) {
//            ans = 0;  // If only one element, it's the peak.
//        } else {
//            if (arr[0] > arr[1]) ans = 0;
//            if (arr[n - 1] > arr[n - 2]) ans = n - 1;
//
//            int low = 1;
//            int high = n - 2;
//
//            while (low <= high) {
//                int mid = low + (high - low) / 2;
//
//                if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
//                    ans = mid;
//                    break;
//                }
//
//                if (arr[mid] > arr[mid - 1]) {
//                    low = mid + 1;
//                } else {
//                    high = mid - 1;
//                }
//            }
//        }
//
//        System.out.println(ans);
        System.out.println(sqrtOfANumber(49));
        System.out.println(nthRootOfANo(8,3));
    }
    static int sqrtOfANumber(int n){
         int ans=1;
         int low=1;
         int high=n;
         while(low<=high){
             int mid=((low)+(high))/2;
            if(mid*mid==n) {
               ans=mid;
               break;
            }
            else if(mid*mid>n){
                 high=mid-1;
             }else if(mid*mid<n){
                 ans=mid;
                 low=mid+1;
             }
         }
         return ans;
    }
    static int nthRootOfANo(int n,int m){
        int ans=-1;
        int low=0;
        int high=n;
        while(low<=high){
            int mid=(low+((high-low)>>1));
            int possibility=fn(mid,m);
            if(possibility==n){
                ans=mid;
                break;
            }else if(possibility<n){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;

    }

    private static int fn(int mid, int m) {
        int ans = 1;
        int power = m ;
        while (power > 0) {
            if ((power & 1) == 1) {
                ans *= mid;
            }
            mid *=mid;
            power >>= 1;
        }
        return ans;
    }

}
