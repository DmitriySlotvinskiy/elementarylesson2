package com.slotvinskiy;

import java.util.Arrays;

public class IntArrayList implements IntList {

    public static final int DEFAULT_SIZE = 10;
    private int size = 0;
    private int[] elementData = new int[DEFAULT_SIZE];

    public IntArrayList(int[] elementData) {
        this.size = elementData.length;
        System.arraycopy(elementData, 0, this.elementData, 0, this.size);
    }

    public IntArrayList() {
    }

    @Override
    public int get(int index) {
        throwExceptionIfIndexOut(index);
        return elementData[index];
    }

    private void throwExceptionIfIndexOut(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        elementData = new int[10];
    }

    @Override
    public int[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public boolean add(int element) {
        if (elementData.length <= size + 1) {
            increaseElementData();
        }
        elementData[size] = element;
        size++;
        return true;
    }

    @Override
    public void add(int index, int element) {
        throwExceptionIfIndexOut(index);
        if (elementData.length <= size + 1) {
            increaseElementData();
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        this.set(index, element);
        size++;
    }

    private void increaseElementData() {
        int[] tmpArray = new int[elementData.length * 3 / 2 + 1];
        System.arraycopy(elementData, 0, tmpArray, 0, size);
        elementData = tmpArray;
    }

    @Override
    public boolean set(int index, int element) {
        throwExceptionIfIndexOut(index);
        elementData[index] = element;
        return true;
    }


    @Override
    public int remove(int index) {
        throwExceptionIfIndexOut(index);
        int temp = this.get(index);
        System.arraycopy(elementData, index + 1, elementData, index, size - index);
        size--;
        return temp;
    }

    @Override
    public boolean removeByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        int newSize = Math.max(toIndex - fromIndex, 10);
        IntList temp = new IntArrayList(Arrays.copyOfRange(this.elementData, fromIndex, toIndex));
        return temp;
    }
}
