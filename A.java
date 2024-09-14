import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        int x=sc.nextInt();
        Arrays.sort(arr);
        int l=0;
        int r=n-1;
        int fi=-1;
        int si=-1;
        while (l<=r){
            int m=(l+r)/2;
            if(arr[m]>=x){
                fi=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        if(fi==-1||arr[fi]!=x){//if it gives some random n or
            System.out.println(-1+" "+-1);
        }else {
            l = 0;
            r = n - 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (arr[m] > x) {
                    si = m;
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            System.out.println(fi + " " + (si == -1 ? n - 1 : si - 1));
        }
    }
    int firstOccurrence(int [] arr ,int n,int tar){
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
    int lastOccurrence(int [] arr ,int n,int tar){
        int l=0;
        int h=n-1;
        int la=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(arr[m]==tar){
                la=m;
                l=m+1;
            }else if(arr[m]<tar){
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return la;
    }
}
