package com.rdkwood;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Robert Wood Jr
 * @version 1.0
 * 02/06/2020
 */
public class Main {
    private static final int SIZE = 100;
    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final int VALUE = 33;

    /**
     * Here we will make calls to do our searches and get results
     * @param args potential variable that is not used in this case
     */
    public static void main(String[] args) {
        //int[] testArray = genArray();
        int[] testArray = { 23,45,43,32,21,46,72,12,23,34,45,56,67,23,45, 33};
        System.out.println();
        System.out.println("Here we will search the array for specified number, in this case 33");
        System.out.println("If it is not found it will result in -1");
        System.out.println();

        System.out.println(Arrays.toString(testArray));
        System.out.println("Using a linearSearch " + VALUE + " Will be found at index " +
                linearSearch(testArray, VALUE));
        System.out.println();

        Arrays.sort(testArray);
        System.out.println(Arrays.toString(testArray));
        System.out.println("Using a binarySearch " + VALUE + " Will be found at index " +
                binarySearch(testArray, VALUE));

        System.out.println();
        Arrays.sort(testArray);
        System.out.println(Arrays.toString(testArray));
        System.out.println("Using a interpolationSearch " + VALUE + " Will be found at index " +
                interpolationSearch(testArray, VALUE));
    }

    /**
     * @param arr the array to be searched through
     * @param value the value searching the array for
     * @return returns the index the value is found at. If the value is not found returns -1
     */
    public static int linearSearch(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    /**
     * @param arr the sorted array to be searched through
     * @param value the value searching the array for
     * @return returns the index the value is found at. If the value is not found returns -1
     */
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

    /**
     * @param arr the sorted array to be searched through
     * @param value the value searching the array for
     * @return returns the index the value is found at. If the value is not found returns -1
     */
    public static int interpolationSearch(int[]arr, int value){
        int low = 0;
        int high = arr.length - 1;

        while(low < high && arr[low] <= value && arr[high] >= value){
            int pos = low + ((value - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            if(arr[pos] == value){
                return pos;
            }
            else if(arr[pos] < value){
                low = pos + 1;
            }
            else{
                high = pos - 1;
            }
        }
        return -1;
    }

    private static int[] genArray(){
        Random random = new Random();
        int[] array = new int[Main.SIZE];
        for (int i = 0; i < array.length; i++){
            array[i] = Main.MIN + random.nextInt(Main.MAX - Main.MIN + 1);
        }
        return array;
    }
}
