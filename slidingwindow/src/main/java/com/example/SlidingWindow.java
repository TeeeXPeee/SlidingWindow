package com.example;

import java.lang.reflect.Array;

public class SlidingWindow<T> {

    private T data[];
    private int dataSize;
    private int width;
    private int index;

    /**
     * Generic Sliding Window Constructor
     * @param data[] data array
     * @param width width of the sliding window
     */
    public SlidingWindow(T data[], int width) {
        this.data = data;
        this.width = width;
        this.index = 0;
        this.dataSize = data.length;
    }

    /**
     * Generic Sliding Window Constructor with starting index
     * @param data[] data array
     * @param width width of the sliding window
     * @param startingIndex starting index of the sliding window
     */
    public SlidingWindow(T data[], int width, int startingIndex){
        this.data = data;
        this.width = width;
        this.index = startingIndex;
        this.dataSize = data.length;
    }

    /**
     * Advance the sliding window by one position
     * @return boolean indicating if advance was successful
     */
    public boolean advance() {
        if (index + 1 < dataSize) {
            index++;
            return true;
        }
        return false;  
    }

    /**
     * Advance the sliding window by {step} number of positions
     * @param step int number of positions to advance
     * @return boolean indicating if advance was successful
     */
    public boolean advance(int step) {
        if (index + step < dataSize) {
            index += step;
            return true;
        }
        return false;  
    }

    /**
     * String representation of the current window
     * @return String representing the current window
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int maxIndex = Math.min(index + width, dataSize);
        for(int i = index; i < maxIndex; i++) {
            sb.append(data[i].toString());
        }
        return sb.toString();
    }

    /**
     * Get the current window data
     * @return T[] array representing the current window data
     */
    @SuppressWarnings("unchecked")
    public T[] data() {
        T[] windowData = (T[]) Array.newInstance(data.getClass().componentType(), width);
        System.arraycopy(data, index, windowData, 0, width);
        return windowData;
    }

    /**
     * Get the current index of the sliding window
     * @return int current index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Get the width of the sliding window
     * @return int width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the size of the data array
     * @return int data size
     */
    public int getDataSize() {
        return dataSize;
    }
    
    /**
     * Get the value at a specific index in the data array
     * @param index int index to retrieve value from
     * @return T value at the specified index
     */
    public T getValueAt(int index) {
        return data[index];
    }
}