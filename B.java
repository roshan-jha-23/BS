import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        int n1 = arr1.length;
        System.out.println(minimumInRotatedSortedArray(arr1, n1)); // Expected Output: 0

        int[] arr2 = {3, 4, 5, 1, 2};
        int n2 = arr2.length;
        System.out.println(minimumInRotatedSortedArray(arr2, n2)); // Expected Output: 1

        int[] arr3 = {2, 3, 4, 5, 6, 7, 1};
        int n3 = arr3.length;
        System.out.println(minimumInRotatedSortedArray(arr3, n3)); // Expected Output: 1

        int[] arr4 = {1, 2, 3, 4, 5};
        int n4 = arr4.length;
        System.out.println(minimumInRotatedSortedArray(arr4, n4));
//        boolean ifRepeated=sc.hasNext();
//        if(ifRepeated){
//           int ans= repeatedElmInRotatedSortedArray(arr,tar,n);
//            System.out.println(ans);
//        }else{
//        int low=0;
//        int high=n-1;
//        int ans=-1;
//        while(low<=high) {
//            int mid = low + (high - low) / 2;
//            if (arr[mid] == tar) {
//                ans = mid;
//                break;
//            }
//            //checking which part is sorted
//            //for left
//            if (arr[low] <= arr[mid]) {
//                if (arr[low] <= tar && tar <= arr[mid]) {
//                    //this means it is contained in left part itself and hence remove right space
//                    high = mid - 1;
//                } else {
//                    low = mid + 1;
//                }
//            } else {
//                //right sorted hai
//                if (arr[mid] <= tar && tar <= arr[high]) {
//                    //it is conatiend in the right patrt of the array and hence destroy the left
//                    low = mid + 1;
//                } else {
//                    high = mid - 1;
//                }
//            }
//            System.out.println(ans);
//        }
//        }
    }

    private static int repeatedElmInRotatedSortedArray(int[] arr, int tar, int n) {
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==tar){
                ans=mid;
                break;
            }
            if (arr[mid] == arr[low] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }
            if(arr[mid]>=arr[low]){
                //left sorted
                if(arr[low]<=tar && tar<=arr[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(arr[mid]<=tar && tar<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }

        }
        return ans;
    }
    static int minimumInRotatedSortedArray(int [] arr,int n){
        int low=0;
        int high=n-1;
        int ans=999999999;
        while(low<=high){
            int m=(low+high)/2;
            //check which half is sorted and elimante it
            if(arr[m]>=arr[low]){
//                compare it with the low
                ans=Math.min(arr[low],ans);
                low=m+1;
            }else{
                //compare it with the mid element
                ans=Math.min(arr[m],ans);
                high=m-1;
            }
        }
        return ans;
    }

}
