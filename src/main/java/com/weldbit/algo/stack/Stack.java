package com.weldbit.algo.stack;

public class Stack<T> {

    private Node<T> topNode = null;
    private Integer size = 0;

    private class Node<J> {
        J item;
        Node<J> prevNode;
    }

    public void push(T item) {
        Node<T> orgTopNode = topNode;
        topNode = new Node<>();
        topNode.item = item;
        topNode.prevNode = orgTopNode;
        size++;
    }

    public T pop() {
        if (topNode == null)
            return null;
        T item = topNode.item;
        topNode = topNode.prevNode;
        size--;
        return item;
    }

    public T getTop() {
        return topNode.item;
    }

    public Integer size() {
        return size;
    }
}
