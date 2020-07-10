package com.yumao.algorithmdemo.binarytree;

import com.yumao.algorithmdemo.TestRule;

/**
 * 二叉树
 * <p>
 * 每个结点的子结点数量可为 0、1、2
 * <p>
 * 有两个子结点，则其中一个子结点的值必须小于父结点，另一个子结点的值必须大于
 * 父结点
 */
public
class BinaryTree implements Tree, TestRule {
    private Note rootNote;

    public BinaryTree(Note rootNote) {
        this.rootNote = rootNote;
    }

    @Override
    public void read() {

    }

    //查找 O(log N)
    @Override
    public void find() {
        Note n = findNote(20, rootNote);
        System.out.println(n);
    }

    private Note findNote(int findValue, Note note) {
        //查找的值在根节点
        if (note == null || note.value == findValue) return note;

        if (note.value < findValue) { //值在树的右边
            return findNote(findValue, note.rightNote);
        } else {
            return findNote(findValue, note.leftNote);
        }
    }

    // O(log N) + 1 忽略常数大 O   O(log N)
    @Override
    public void insert() {
        insertNote(13, rootNote);
    }

    private void insertNote(int insertValue, Note note) {
        if (note.value < insertValue) { //值在树的右边
            if (note.rightNote == null)
                note.rightNote = new Note(insertValue, null, null);
            else
                insertNote(insertValue, note.rightNote);
        } else {
            if (note.leftNote == null)
                note.leftNote = new Note(insertValue, null, null);
            else
                insertNote(insertValue, note.leftNote);
        }
    }


    @Override
    public void delete() {
        deleteNote(22, rootNote);
    }

    private Note deleteNote(int deleteValue, Note note) {
        //当前位置的上一层无子结点，已到达树的底层，即基准情形
        if (note == null) {
            return null;
        }

        //如果要删除的值小于（或大于）当前结点，
        //则以左子树（或右子树）为参数，递归调用本方法，
        //然后将当前结点的左链（或右链）指向返回的结点
        if (deleteValue < note.value) {
            note.leftNote = deleteNote(deleteValue, note.leftNote);
            //将当前结点（及其子树，如果存在的话）返回，
            //作为其父结点的新左子结点（或新右子结点）
            return note;
        } else if (deleteValue > note.value) {
            note.rightNote = deleteNote(deleteValue, note.rightNote);
            return note;
        }

        //如果要删除的正是当前结点
        if (deleteValue == note.value) {
            //如果当前结点没有左子结点，
            //则以右子结点（及其子树，如果存在的话）替换当前结点成为当前结点之父结点的新子结点
            if (note.leftNote == null)
                // 如果当前结点没有左子结点，也没有右子结点，那这里就是返回 None
                return note.rightNote;
            else if (note.rightNote == null)
                return note.leftNote;
            else {
                //如果当前结点有两个子结点，则用 lift 函数来做删除，它会使当前结点的值变成其后继结点的值
                note.rightNote = lift(note.rightNote, note);
            }
        }

        return note;
    }

    private Note lift(Note note, Note nodeToDelete) {
        // 如果此函数的当前结点有左子结点，
        //则递归调用本函数，从左子树找出后继结点
        if (note.leftNote != null) {
            note.leftNote = lift(note.leftNote, nodeToDelete);
            return note;
        } else {
            // 如果此函数的当前结点无左子结点，
            // 则代表当前结点是后继结点，于是将其值设置为被删除结点的新值
            nodeToDelete.value = note.value;
            // 用后继结点的右子结点替代后继结点的父节点的左子结点
            return note.rightNote;
        }
    }

    public void printlnTree() {
        printlnNote(rootNote);
    }

    //树的遍历 效率 O(N)
    private void printlnNote(Note note) {
        //先打印左节点
        if (note.leftNote != null) printlnNote(note.leftNote);
        //在打印自己
        System.out.println(note.value);
        //最后打印右节点
        if (note.rightNote != null) printlnNote(note.rightNote);
    }

}