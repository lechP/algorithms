package edu.algs.experimental;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeTest {

    @Test
    public void shouldCreateNewTreeWithValueAtRoot() throws Exception {
        //given
        Integer val = 10;
        //when
        BinaryTree<Integer> tree = new BinaryTree<>(val);
        //then
        assertThat(tree.value()).isEqualTo(val);
    }

    @Test
    public void shouldAddSmallerValueToTheLeftBranch() throws Exception {
        //given
        Integer rootVal = 10;
        Integer toTheLeft = 5;
        //when
        BinaryTree<Integer> tree = new BinaryTree<>(rootVal);
        tree.add(toTheLeft);
        //then
        assertThat(tree.left().value()).isEqualTo(toTheLeft);
    }

    @Test
    public void shouldAddGreaterValueToTheLeftBranch() throws Exception {
        //given
        Integer rootVal = 10;
        Integer toTheRight = 11;
        //when
        BinaryTree<Integer> tree = new BinaryTree<>(rootVal);
        tree.add(toTheRight);
        //then
        assertThat(tree.right().value()).isEqualTo(toTheRight);
    }

    @Test
    public void shouldAddElementDeeperInTheTree() throws Exception {
        //given
        Integer rootVal = 10;
        Integer level1_left = 5;
        Integer level1_right = 15;
        Integer leaf = 13;
        BinaryTree<Integer> tree = new BinaryTree<>(rootVal);
        tree.add(level1_left);
        tree.add(level1_right);
        //when
        tree.add(leaf);
        //then
        assertThat(tree.right().left().value()).isEqualTo(leaf);
    }
    
    @Test
    public void shouldBeLeaf() throws Exception {
        //when
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        //then
        assertThat(tree.isLeaf()).isTrue();
    }

    @Test
    public void newElementShouldBeLeafButRootShouldNot() throws Exception {
        //when
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        tree.add(5);
        //then
        assertThat(tree.isLeaf()).isFalse();
        assertThat(tree.left().isLeaf()).isTrue();
    }
    
    @Test
    public void shouldProcessSomeMoreComplexExample() throws Exception {
        //given
        Integer root = 10;
        List<Integer> nextInts = Arrays.asList(3, -4, -12, 7, 2, 11, 4, 6, 10);
        /*
                       10
                      /  \
                      3  11
                     / \
                   -4   7
                   /\   /\
                -12  2 4  10
                        \
                        6
         */
        //when
        BinaryTree<Integer> tree = new BinaryTree<>(root);
        nextInts.forEach(tree::add);
        //then
        assertThat(tree.value()).isEqualTo(10);
        assertThat(tree.right().value()).isEqualTo(11);
        BinaryTree<Integer> left = tree.left();
        assertThat(left.value()).isEqualTo(3);
        assertThat(left.left().value()).isEqualTo(-4);
        assertThat(left.left().left().value()).isEqualTo(-12);
        assertThat(left.left().right().value()).isEqualTo(2);
        assertThat(left.right().value()).isEqualTo(7);
        assertThat(left.right().left().value()).isEqualTo(4);
        assertThat(left.right().right().value()).isEqualTo(10);
        assertThat(left.right().left().right().value()).isEqualTo(6);
    }

}