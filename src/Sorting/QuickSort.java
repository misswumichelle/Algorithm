package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static int[] quickSort(int[] arr){
        return quickSort(arr, 0, arr.length-1);
    }

    public static int[] quickSort(int[] arr, int L, int R){
        if( L < 0 || R >= arr.length || arr.length < 1 || L > R){
            return null;
        }

        int zoneIndex = partition(arr,L, R);
        if(zoneIndex > L) quickSort(arr, L, zoneIndex-1);
        if(zoneIndex < R) quickSort(arr, zoneIndex+1 , R);
        return arr;
    }


    public static int partition(int[] arr, int L, int R){
        if(L == R) return L;
        int zoneIndex = L-1;
        int pivot = (int)(L + Math.random()*(R-L+1));
        swap(arr, pivot,R);
        for (int i = L; i < R; i++) {
            if(arr[i] <= arr[R]){
                zoneIndex++;
                if(zoneIndex < i){
                    swap(arr,zoneIndex,i);
                }
            }
        }
        return zoneIndex;

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 8, 3, 9, 6, 12, 18, 14, 15, 20, 19, 7};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
