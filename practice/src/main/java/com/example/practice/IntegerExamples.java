package com.example.practice;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerExamples {
    public static void main(String[] args) {

        arrayPrograms();

        bubbleSort();

        countRepeatedCharacters();

        nonRepeatedCharacters();

        findDuplicateElements();

        reverseNumber();

        moverZeros();

        printOddAndEvenNumbersAtOnce();

        findMissingNumbers();

        findLargestAndSmallestElements();

        reverseAnArray();

        kadanesAlgorithm();

        int[] result = twoSum();
        System.out.println(result[0] + ", " + result[1]);


    }

    private static int[] twoSum() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 7;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{}; // if no solution found
    }


    private static void kadanesAlgorithm() {
        System.out.println("******************************** Kadane’s Algorithm (Max Subarray Sum) ********************************");
        int[] nums ={1,2,3,4,5};
        int max = nums[0], curr = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(max, curr);
        }
        System.out.println(max);
    }

    private static void reverseAnArray() {
        System.out.println("******************************** Reverse an Array ********************************");
        int[] arr ={9,8,7,6,5,1,2,3,4};
        int k = 5;
        reverseArray(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        reverseArray(arr,0,k-1);
        System.out.println(Arrays.toString(arr));

        reverseArray(arr,k,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void reverseArray(int[] arr, int i, int j) {
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }


    private static void findLargestAndSmallestElements() {
        System.out.println("******************************** Find Largest and smallest Number ********************************");

        int[] arr = {-10,-1,8,120,1,-2,0,3,4,1,2,3,4,0,0,3,1,-100};

        int max = Arrays.stream(arr).sorted().max().getAsInt();
        int min = Arrays.stream(arr).sorted().min().getAsInt();

        System.out.println("Min: " + min + " " + "max: " + max);

        List<Integer> integers = List.of(-10,-1,8,120,1,-2,0,3,4,1,2,3,4,0,0,3,1,-100);

        int max1 = integers.stream().max(Comparator.comparingInt(Integer::intValue)).get();
        int min1 = integers.stream().min(Comparator.comparingInt(Integer::intValue)).get();

        System.out.println("Min: " + min1 + " " + "max: " + max1);

        int min2 =0;
        int max2 =0;

        int minIndex=0;
        int maxIndex=0;

        for(int i =0; i <arr.length; i++){
            if(arr[i] <= min2){
                min2 = arr[i];
                minIndex = i;
            }
            if(arr[i] >= max2){
                max2 = arr[i];
                maxIndex =i;
            }
        }
        System.out.println("Min: " + min2 + " index= " +minIndex +", " + "max: " + max2 + " index =" + maxIndex);
    }

    private static void findMissingNumbers() {
        System.out.println("******************************** Missing Numbers ********************************");
        int[] arr ={-1,10,1,2,4,5};
        int[] missingNumbers = IntStream.rangeClosed(
                Arrays.stream(arr).sorted().findFirst().getAsInt(),
                Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).findFirst().get())
                .filter(a-> !Arrays.stream(arr).boxed().collect(Collectors.toList()).contains(a)).toArray();

        System.out.println(Arrays.toString(missingNumbers));

        List<Integer> missingNumbers1 = IntStream.rangeClosed(
                        Arrays.stream(arr).sorted().findFirst().getAsInt(),
                        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).findFirst().get())
                .boxed()
                .filter(a-> !Arrays.stream(arr).boxed().collect(Collectors.toList()).contains(a)).toList();

        System.out.println(missingNumbers1);
    }

    private static void printOddAndEvenNumbersAtOnce() {
        System.out.println("******************************** Print Odd and Even Numbers ********************************");
        int[] arr= {-1,0,1,2,3,4,5,6,7,8,9,10};
        Map<Boolean,List<Integer>> integers = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(a-> a % 2 == 0));
        System.out.println(integers);
    }

    private static void findDuplicateElements() {
        System.out.println("******************************** Find Duplicates ********************************");
        int[] arr = {1,1,2,3,4,4,5};

        Set<Integer> duplicates = new HashSet<>();
        List<Integer> integers = Arrays.stream(arr).boxed().filter(a-> !duplicates.add(a)).collect(Collectors.toList());
        System.out.println(integers);

    }

    private static void nonRepeatedCharacters() {
        int[] arr = {-1,8,10,1,-2,0,3,4,1,2,3,4,0,0,3,1};

        System.out.println("******************************** First non repeated character ********************************");
        Map.Entry<Integer,Long> nonrepeatedCharacter = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(a->a.getValue() ==1).findFirst().get();

        System.out.println(nonrepeatedCharacter);

        Map<Integer,Long> nonRepeatedCharacters = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(a->a.getValue() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(nonRepeatedCharacters);

        Set<Integer> nonRepeatedCharactersKeys =
                Arrays.stream(arr)
                        .boxed()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toSet());

        System.out.println(nonRepeatedCharactersKeys);

    }

    private static void moverZeros() {
        System.out.println("******************************** Move Zero's to Start ********************************");

        int[] arr = {-1,8,10,1,-2,0,3,4,1,2,3,4,0,0,3,1};

        List<Integer> moveZerosToStart = Stream.concat(
                Arrays.stream(arr).boxed().filter(a-> a == 0),
                Arrays.stream(arr).boxed().filter(a-> a != 0)
        ).toList();
        System.out.println(moveZerosToStart);


        System.out.println("******************************** Move Zero's to End ********************************");

        List<Integer> moveZerosToEnd = Stream.concat(
                Arrays.stream(arr).boxed().filter(a-> a != 0),
                Arrays.stream(arr).boxed().filter(a-> a == 0)
        ).toList();
        System.out.println(moveZerosToEnd);
    }

    private static void reverseNumber() {
        System.out.println("******************************** Reverse a number ********************************");
        int num = 1234;
        int rev =0;

        while (num != 0){
            int digit = num % 10;
            rev = (rev * 10) + digit;
            num /=10;
        }
        System.out.println(rev);
    }

    private static void countRepeatedCharacters() {
        System.out.println("******************************** Count Repeated Characters ********************************");
        int[] arr = {-1,10,-2,-10,1,2,3,1,2,3,4,5,6,5,6,7,8,9,10};

        Map<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        System.out.println(map);
        int count = 0;
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            count++;
            System.out.print(m.getKey() + "=" + m.getValue());


            if(count != map.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.println("******************************** Count Repeated Characters Java 8 ********************************");

        Map<Integer,Long> map1 = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map1);


    }

    private static void bubbleSort() {
        System.out.println("******************************** Bubble Sort ********************************");
        int[] bubbleSort = {1,2,3,9,9,10,2,3,4,10,15};

        for(int i = 0; i < bubbleSort.length; i++){
            for(int j = 0; j < bubbleSort.length - 1 ; j++){
                if(bubbleSort[j] < bubbleSort[j + 1]){
                    int temp = bubbleSort[j];
                    bubbleSort[j] =  bubbleSort[j+1];
                    bubbleSort[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(bubbleSort));

        for(int i = 0; i < bubbleSort.length; i++){
            for(int j = 0; j < bubbleSort.length - 1 ; j++){
                if(bubbleSort[j] > bubbleSort[j + 1]){
                    int temp = bubbleSort[j];
                    bubbleSort[j] =  bubbleSort[j+1];
                    bubbleSort[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(bubbleSort));
    }

    private static void arrayPrograms() {
        int[] arr = {-1,10,-2,-10,1,2,3,1,2,3,4,5,6,5,6,7,8,9,10};

        int[] sort = Arrays.stream(arr).sorted().distinct().toArray();
        int[] rev = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).distinct().mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(sort));
        System.out.println(Arrays.toString(rev));
    }
}
