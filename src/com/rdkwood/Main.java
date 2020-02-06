package com.rdkwood;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] testArray = genArray(100, 0, 100);
        System.out.println(Arrays.toString(testArray));
        System.out.println(linearSearch(testArray, 33));
        System.out.println();
        Arrays.sort(testArray);
        System.out.println(Arrays.toString(testArray));
        System.out.println(binarySearch(testArray, 33));
    }

    public static int linearSearch(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[]arr, int value){
        int low = 0;
        int high = arr.length -1;

        while(low <= high){
            int mid = (high + low) / 2;
            if(arr[mid] == value){
                return mid;
            }
            else if(arr[mid] < value){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void interpolationSearch(){

    }


    public static int[] genArray(int size, int min, int max){
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            array[i] = min + random.nextInt(max - min + 1);
        }
        return array;
    }
}
