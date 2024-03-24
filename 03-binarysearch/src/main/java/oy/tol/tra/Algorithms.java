package oy.tol.tra;

public class Algorithms {
    public static <T extends Comparable<T>> void sort(T[] array) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {

                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static <T extends Comparable<T>> int binarySearch(T valueToFind, T[] sortedArray, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedArray[mid].compareTo(valueToFind) == 0) {
                return mid;
            } else if (sortedArray[mid].compareTo(valueToFind) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
