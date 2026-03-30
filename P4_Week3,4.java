import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    public String toString() {
        return name + ": " + returnRate + "% (Vol: " + volatility + ")";
    }
}

public class Week4PortfolioSorting {

    public static void mergeSort(Asset[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(Asset[] arr, int l, int m, int r) {
        Asset[] temp = new Asset[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (arr[i].returnRate <= arr[j].returnRate) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, l, temp.length);
    }

    public static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Asset[] arr, int low, int high) {
        Asset pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].returnRate > pivot.returnRate ||
               (arr[j].returnRate == pivot.returnRate &&
                arr[j].volatility < pivot.volatility)) {

                i++;
                Asset temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Asset temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Asset[] assets = {
            new Asset("AAPL", 12, 5),
            new Asset("TSLA", 8, 7),
            new Asset("GOOG", 15, 4)
        };

        System.out.println("Merge Sort (ASC):");
        mergeSort(assets, 0, assets.length - 1);
        for (Asset a : assets) System.out.println(a);

        System.out.println("\nQuick Sort (DESC + Volatility):");
        quickSort(assets, 0, assets.length - 1);
        for (Asset a : assets) System.out.println(a);
    }
}