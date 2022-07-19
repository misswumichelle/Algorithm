package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }

        for (int i = 1; i < arr.length-1; i++) {
                int j = i-1;
                int temp = arr[i];
                while(j>=0){
                    if(temp<arr[j]){
                        arr[j+1] = arr[j];
                    }
                    else break;
                    j--;
                }
                if(i!=(j+1)){
                    arr[j+1] = temp;
                }

        }
    }


    public static void main(String[] args) {
        int[] arr = {10, 5, 8, 3, 9, 6, 12};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
