package com.yumao.algorithmdemo.binarytree;

/**
 * 二叉树节点
 */
public
class Note {
    public int value;
    public Note leftNote, rightNote;

    public Note(int value, Note leftNote, Note rightNote) {
        this.value = value;
        this.leftNote = leftNote;
        this.rightNote = rightNote;
    }
}
