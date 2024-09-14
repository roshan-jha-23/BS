import java.util.Arrays;
import java.util.Scanner;

public class Cows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of stalls: ");
        int n = sc.nextInt();

        System.out.print("Enter the number of cows: ");
        int cows = sc.nextInt();

        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        System.out.println("Enter the positions of the stalls:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }


        Arrays.sort(arr);

        int low = 1;
        int high = max - min;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, mid, cows)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("The largest minimum distance possible is: " + high);
    }

    static boolean isPossible(int arr[], int m, int k) {
        int cnt = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= m) {
                cnt++;
                last = arr[i];
            }
        }
        return cnt >= k;
    }
}
