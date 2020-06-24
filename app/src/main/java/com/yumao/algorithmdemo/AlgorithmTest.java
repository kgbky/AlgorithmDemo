package com.yumao.algorithmdemo;

/**
 * 各种常见算法的O
 */
public class AlgorithmTest {

    private int[] array = new int[]{1, 4, 7, 10, 3, 100, 99, 10000};

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

}
