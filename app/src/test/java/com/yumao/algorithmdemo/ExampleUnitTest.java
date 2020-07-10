package com.yumao.algorithmdemo;

import com.yumao.algorithmdemo.binarytree.BinaryTree;
import com.yumao.algorithmdemo.binarytree.Note;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);

        Note rightNot2 = new Note(69, null, null);
        Note leftNot2 = new Note(71, null, null);
        Note leftNot = new Note(20, null, null);
        Note rightNot = new Note(70, rightNot2, leftNot2);
        Note rootNot = new Note(50, leftNot, rightNot);
        BinaryTree tree = new BinaryTree(rootNot);
        tree.printlnTree();

        System.out.println("插入一个值之后");
        tree.insert();
        tree.printlnTree();
    }

}