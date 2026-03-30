import java.util.*;

public class Week5AccountLookup {

    public static int linearSearch(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear Comparisons: " + comparisons);
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1, comps = 0;

        while (low <= high) {
            comps++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                System.out.println("Binary Comparisons: " + comps);
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int countOccurrences(String[] arr, String target) {
        int count = 0;
        for (String s : arr) {
            if (s.equals(target)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] logs = {"accA", "accB", "accB", "accC"};

        System.out.println("Linear Search index: " + linearSearch(logs, "accB"));

        Arrays.sort(logs); // Required for binary search
        System.out.println("Sorted logs: " + Arrays.toString(logs));

        int index = binarySearch(logs, "accB");
        System.out.println("Binary Search index: " + index);

        System.out.println("Count of accB: " + countOccurrences(logs, "accB"));
    }
}