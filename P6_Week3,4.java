import java.util.*;

public class Week6RiskThreshold {

    public static boolean linearSearch(int[] arr, int target) {
        int comps = 0;
        for (int val : arr) {
            comps++;
            if (val == target) {
                System.out.println("Found with " + comps + " comparisons");
                return true;
            }
        }
        System.out.println("Not found, comparisons: " + comps);
        return false;
    }

    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1, res = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                res = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public static int ceil(int[] arr, int target) {
        int low = 0, high = arr.length - 1, res = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                res = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static int insertPosition(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] risks = {10, 25, 50, 100};

        System.out.println("Linear Search:");
        linearSearch(risks, 30);

        System.out.println("\nBinary Results:");
        System.out.println("Floor(30): " + floor(risks, 30));
        System.out.println("Ceiling(30): " + ceil(risks, 30));
        System.out.println("Insert Position(30): " + insertPosition(risks, 30));
    }
}