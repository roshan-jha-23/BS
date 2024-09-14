import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kOKO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String elm = br.readLine();

        String[] elements = elm.split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(elements[i]);
        }

        int hr = Integer.parseInt(br.readLine());
        System.out.println(minHrReqToCompleteBanana(arr,n,hr));
    }
  static   int minHrReqToCompleteBanana(int[] arr,int n,int h){
        int maxi=-999999;
        for(int x:arr)maxi=Math.max(x,maxi);
        int ans=0;
        int low=1;
        int high=maxi;
        while(low<=high){
            int mid=(low+((high-low)>>1));
            int poss=fn(arr,mid);
            if(poss<h){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    static int fn(int[] arr,int mid){
        int totHr=0;
        for (int i = 0; i <arr.length ; i++) {
            totHr+=(arr[i]+mid-1/mid);
        }
        return totHr;
    }
}
