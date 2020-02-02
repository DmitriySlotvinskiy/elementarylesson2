package com.slotvinskiy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static final Random RANDOM = new Random();
    public static final int BOUND = 30;
    public static final int ARRAYS_SIZE = 10;

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        IntList list2 = new IntArrayList();
        printBothLists(list1, list2);
        checkAndPrintIsEmptyAndSize(list1, list2);
        initListsWithEqualsValues(list1, list2);
        printBothLists(list1, list2);
        list1.add(10);
        list2.add(10);
        printBothLists(list1, list2);
        list1.add(2, 777);
        list2.add(2, 777);
        printBothLists(list1, list2);
        list1.remove(1);
        list2.remove(1);
        printBothLists(list1, list2);
        Integer value = 777;
        list1.remove(value);
        list2.removeByValue(value);
        printBothLists(list1, list2);
        List<Integer> subList1 = new ArrayList<>(list1.subList(1, 3));
        IntList subList2 = list2.subList(1, 3);
        checkAndPrintIsEmptyAndSize(list1, list2);
        System.out.print("Testing subList(1, 3) for both lists: ");
        printBothLists(subList1, subList2);
        IntArrayList list3 = new IntArrayList();
        initIntArray(list3);
        System.out.println("Init IntArrayList: " + list3);
        sortIntList(list3);
        System.out.println("Sorted IntArrayList: " + list3);
    }

    private static void sortIntList(IntList list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; list.get(j) < list.get(j - 1) && j >= 1; j--) {
                int temp = list.get(j);
                list.set(j, list.get(j - 1));
                list.set(j - 1, temp);
                if (j == 1) {
                    break;
                }
            }
        }
    }

    private static void initListsWithEqualsValues(List<Integer> list1, IntList list2) {
        for (int i = 0; i < ARRAYS_SIZE; i++) {
            int temp = RANDOM.nextInt(BOUND);
            list1.add(temp);
            list2.add(temp);
        }
    }

    private static void initIntArray(IntList list) {
        for (int i = 0; i < ARRAYS_SIZE; i++) {
            list.add(RANDOM.nextInt(BOUND));
        }
    }

    private static void checkAndPrintIsEmptyAndSize(List<Integer> list1, IntList list2) {
        if (list1.isEmpty() && list2.isEmpty()) {
            System.out.print("Arrays are empty and their sizes are:   ");
            System.out.printf("ArrayList - %s;   IntList - %s\n", list1.size(), list2.size());
        } else if (!list1.isEmpty() && !list2.isEmpty()) {
            System.out.print("Arrays aren't empty and their sizes are:   ");
            System.out.printf("ArrayList - %s;   IntList - %s\n", list1.size(), list2.size());
        } else {
            System.out.println("Something wrong!");
        }
    }

    private static void printBothLists(List<Integer> list1, IntList list2) {
        System.out.println("ArrayList - " + list1 + ";  IntArrayList - " + list2);
    }
}
