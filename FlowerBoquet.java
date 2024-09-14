import java.util.Scanner;

public class FlowerBoquet {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        int low=99999999;
        int high=-99999999;
        for (int i = 0; i <n; i++) {
            arr[i]=sc.nextInt();
            low=Math.min(low,arr[i]);
            high=Math.max(high,arr[i]);
        }
        while(low<=high){
            int mid=low+((high-low)>>1);
            int poss=fn(mid,arr,k);
            if(poss>=m){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        System.out.println(low);

    }
    public static int fn(int mid, int [] arr,int k){
       int cnt=0;
       int ans=0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i]<=mid)cnt++;
            else{
                ans+=(cnt/k);
                cnt=0;
            }
        }
        ans+=(cnt/k);
        return ans;
    }
}
