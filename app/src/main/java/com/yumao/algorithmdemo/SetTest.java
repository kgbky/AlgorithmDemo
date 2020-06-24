package com.yumao.algorithmdemo;

import java.util.HashSet;
import java.util.Set;

public class SetTest implements TestRule {

    private Set<Integer> set = new HashSet<>();

    public SetTest() {
        set.add(1);
        set.add(100);
        set.add(-1);
        set.add(88);
        set.add(99);
        set.add(1000);
        set.add(1897);
    }

    @Override
    public void read() {
    }

    @Override
    public void find() {

    }

    @Override
    public void insert() {

    }

    @Override
    public void delete() {

    }

}