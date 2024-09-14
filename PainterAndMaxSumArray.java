import java.util.Arrays;
import java.util.Scanner;

public class PainterAndMaxSumArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int[n];
        int painterOrK=sc.nextInt();
        if(n<painterOrK){
            System.out.println("Not Possible");
        }else{
            int max=(int)(1e9);
            for (int i = 0; i <n; i++) {
                arr[i]=sc.nextInt();
                max=Math.max(arr[i],max);
            }
            //here also arise aap min kisi ko kitna de sakte ho lets say u have an arrray
//             of [23,45,29,75] can u take 45 as min?? no then how will u allocate for 75?
//                    so what shoud be min yes??the largest possible
            int low=max;
            int high= Arrays.stream(arr).sum();
            while (low<=high){
                int mid=low+((high-low)>>1);
                int poss=fn(arr,mid);
                if(poss==painterOrK){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            System.out.println(low);
        }
    }

    private static int fn(int[] arr, int mid) {
        int worker=1;
        int part=0;
        for (int i = 0; i <arr.length; i++) {
            if(arr[i]+part<=mid){
                part+=arr[i];
            }else{
                worker++;
                part=arr[i];
            }
        }
        return worker;
    }
}
