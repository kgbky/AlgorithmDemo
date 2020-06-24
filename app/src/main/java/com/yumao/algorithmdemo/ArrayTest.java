package com.yumao.algorithmdemo;

/**
 * 数组的 O 效率
 */
public class ArrayTest implements TestRule {

    private int[] array = new int[]{1, 4, 7, 10, 3, 100, 99, 10000};

    @Override
    public void read() {
        int a = array[1];

        //O(1)
    }

    @Override
    public void find() {
        int tag = 100;  //要查找的目标

        int tagIndex = -1;  //-1 表示数组中不包含要查找的元素

        for (int i = 0; i < array.length; i++) {    //遍历数据结构
            if (tag == array[i]) {
                tagIndex = i;
                break;
            }
        }

        //tag在数组开头效率O(1)    tag在数组末尾效率O(N)
        //O计法指最坏的情况，所以效率O(N)
    }

    @Override
    public void insert() {
        int tag = 100;  //要插入的值

        int tagIndex = 0;  //要插入的位置

        //插入末尾 O(1) 插入开头 O(N+1)
        //O计法指最坏的情况，且忽略常数。所以效率O(N)
    }

    @Override
    public void delete() {
        //删除末尾 O(1) 删除开头 O(N)  中间 O(Arrary.lenght()-index)
        //O计法指最坏的情况，且忽略常数。所以效率O(N)
    }

}