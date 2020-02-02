package com.slotvinskiy;

public interface IntList {
    boolean add(int element);

    void add(int index, int element);

    void clear();

    int get(int index);

    boolean isEmpty();

    int remove(int index);

    boolean removeByValue(int value);

    boolean set(int index, int element);

    int size();

    IntList subList(int fromIndex, int toIndex);

    int[] toArray();
}
