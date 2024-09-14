import java.util.HashMap;
import java.util.Scanner;

public class Divide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            HashMap<Integer,Integer>map=new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                for(int x=2;x*x<=a[i];x++){
                    if(a[i]%x==0){
                        while (a[i]%x==0){
                            map.put(x,map.getOrDefault(x,0)+1);
                           a[i]/=x;
                        }
                    }
                }
                if(a[i]>1){
                    map.put(a[i],map.getOrDefault(a[i],0)+1);
                }

            }
            boolean flag=true;
            for(int val:map.values()){
                if(val%n!=0){
                    flag=false;
                }
            }
   if(flag){
       System.out.println("yes");
   }else{
       System.out.println("No");
   }


        }
    }
}
