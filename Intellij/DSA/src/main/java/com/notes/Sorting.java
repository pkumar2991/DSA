package com.notes;

public class Sorting {
    void bubbleSort(int[] arr) {
        boolean sorted;
        for (int i = 0; i < arr.length; i++) {
            sorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    sorted = false;
                }
            }
            if (sorted) return;
        }
    }

    void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int hole = i;
            while (hole > 0 && arr[hole - 1] > value) {
                arr[hole] = arr[hole - 1];
                hole = hole - 1;
            }
            arr[hole] = value;
        }
    }

    void merge(int[] left, int[] right, int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;

        //Left Array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    void mergeSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        int mid = (n / 2);
        int left[] = new int[mid];
        int right[] = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        int k = mid;
        for (int i = 0; i < (n - mid); i++) {
            right[i] = arr[k];
            k++;
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    int partition(int[] arr, int start, int end) {
        if (arr.length == 0) return -1;
        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = arr[pIndex];
        arr[pIndex] = pivot;
        arr[end] = temp;
        return pIndex;
    }

    void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex + 1, end);
        }
    }

    boolean binarySearch(int[] arr, int data) {
        if (arr.length == 0) return false;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == data) return true;
            if (arr[mid] < data) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    boolean binarySearchRecursion(int[] arr, int data, int low, int high) {

        int mid = low + (high - low) / 2;
        if (low > high) return false;
        if (arr[mid] == data) return true;

        if (arr[mid] < data) {
            return binarySearchRecursion(arr, data, mid + 1, high);
        } else {
            return binarySearchRecursion(arr, data, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int array[] = {3, 4, 5, 6, 7, 8, 9};
        Sorting sorting = new Sorting();
//        sorting.binarySearch(array,4);
        System.out.println(sorting.binarySearchRecursion(array, 44, 0, array.length - 1));
    }
}
