package Sorting;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }

        int heapSize = arr.length;
        swap(arr,0,--heapSize);

        while(heapSize > 0){
            heapify(arr, 0, heapSize);
            swap(arr,0,--heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index - 1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize){
        int left = index *2 + 1; //左孩子

        while(left < heapSize){  //有孩子
            int largest = left + 1 < heapSize && arr[left+1] > arr[left]? left+1:left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index) break;
            swap(arr,largest,index);
            index = largest;
            left = index *2 +1;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 8, 3, 9, 6, 12};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
