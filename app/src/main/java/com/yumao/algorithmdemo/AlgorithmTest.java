package com.yumao.algorithmdemo;

import java.util.Arrays;

/**
 * 各种常见算法的O
 */
public class AlgorithmTest {

    private int[] array = new int[]{1, 720, 7, 10, 2, 10000, 693, 99};

    //冒泡排序(升序)  效率：N*N-N
    //O只保留最高阶的N 效率：N*N
    public int[] a() {
        for (int i = array.length - 1; i > 0; i--) {  //N-1个循环
            for (int j = 0; j < i; j++) {   //array.length-1 -->  1
                int start = array[j];
                int end = array[j + 1];
                if (start > end) {  //1 步交换
                    //交换
                    array[j] = end;
                    array[j + 1] = start;
                }
            }
        }
        return array;
    }

    //选择排序(升序)  效率：(N*N+N-2)/2
    //O只保留最高阶的N,并忽略常数 效率：N*N/2
    public int[] b() {
        for (int i = 0; i < array.length; i++) { //N个循环
            int index = i;
            for (int j = i + 1; j < array.length; j++) { //N-1 --> 1
                if (array[index] > array[j]) {  //选出最小的值
                    index = j;
                }
            }
            if (index != i) {   //1步交换
                int tag = array[i];
                array[i] = array[index];
                array[index] = tag;
            }
        }
        return array;
    }

    //插入排序
    //移除 N-1 、比较1+ .... + n-1、平移、插入
    //效率 N*N+2N-2
    public int[] c() {
        for (int i = 1; i < array.length; i++) {
            int dex = i;
            int value = array[dex];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > value) {
                    //右移
                    array[j + 1] = array[j];
                    dex = j;
                } else {
                    break;
                }
            }
            //value 插入空的地方
            array[dex] = value;
        }
        return array;
    }

    //插入排序
    public int[] d() {
        return null;
    }

    //分区实现 1.25N - N
    private int partition(int leftIndex, int rightIndex) {
        //总是取最右的值作为轴
        int pivotIndex = rightIndex;
        int pivot = array[pivotIndex];

        //将右指针指向轴左边的一格
        rightIndex -= 1;

        while (true) {
            //左指针逐个格子向右移动，当遇到大于或等于轴的值时，就停下来
            while (array[leftIndex] < pivot) {
                leftIndex++;
            }

            //右指针逐个格子向左移动，当遇到小于或等于轴的值时，就停下来
            while (array[rightIndex] > pivot) {
                rightIndex--;
            }

            //两指针重合，或左指针移到右指针的右边。
            if (leftIndex >= rightIndex) {
                break;
            } else {
                //将两指针所指的值交换位置
                int tag = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = tag;
            }
        }

        //将轴与左指针所指的值交换位置。
        array[pivotIndex] = array[leftIndex];
        array[leftIndex] = pivot;

        //根据快速排序的需要，返回分区后轴的索引
        return leftIndex;
    }

    //快速排序 O(N * log N)
    public void quickSort(int leftIndex, int rightIndex) {
        //基准情形：分出的子数组长度为 0 或 1
        if (rightIndex - leftIndex <= 0) return;

        //将数组分成两部分，并返回分隔所用的轴的索引
        int pivot_position = partition(leftIndex, rightIndex);

        //对轴左侧的部分递归调用 quickSort
        quickSort(leftIndex, pivot_position - 1);
        //对轴右侧的部分递归调用 quickSort
        quickSort(pivot_position + 1, rightIndex);
    }

    //快速选择 O(2N)
    public int quickSelect(int target, int leftIndex, int rightIndex) {
        //基准情形：分出的子数组长度为 0 或 1
        if (rightIndex - leftIndex <= 0) return array[leftIndex];

        //将数组分成两部分，并返回分隔所用的轴的索引
        int pivot_position = partition(leftIndex, rightIndex);

        if (target < pivot_position)
            return quickSelect(target, leftIndex, pivot_position - 1);
        else if (target > pivot_position)
            return quickSelect(target, pivot_position + 1, rightIndex);
        else return array[pivot_position];
    }

    public void printlnArray() {
        System.out.println(Arrays.toString(array));
    }

}