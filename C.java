import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        int ans=-1;
        if(n==1){
           ans=arr[0];
        }
        if(arr[0]!=arr[1])ans=arr[0];
        if(arr[n-1]!=arr[n-2])ans=arr[0];
        int l=1;
        int h=n-2;
        while (l<=h){
            int m=((l+(h-l))>>1);
            if(arr[m]!=arr[m-1] && arr[m]!=arr[m+1]){
                ans=arr[m];
            }
            if(m%2==1 && arr[m]==arr[m-1] || m%2==0 && arr[m]==arr[m+1]){
                //it means left half pe we are standing and need to elimante it
                //we are doing this bcoz
                // 0 1 2 3 4 5 6 7 8 9 10
                // a a b b c d d e e f f
                //a->(even,odd) b>(even,odd) c is alone d->(odd,even) e->(0dd,even) ...
                //so before single elemnt we have our left which has tendemcy of(even,odd)
                //if we at odd check for 1 minus
                //if we at even check for 1 plus
                l=m+1;
            }else if((m%2==1 && arr[m]==arr[m+1]) || (m%2==1 &&arr[m]==arr[m-1])){
                h=m-1;
            }
        }
        System.out.println(ans);
    }
}
