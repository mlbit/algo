/**
 * MIT License
 *
 * <p>Copyright (c) 2021 Mervyn Badiang
 *
 * <p>Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * <p>The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.weldbit.algo.stack;

/**
 * A generic Stack class that allow multiple ways to traverse records.
 *
 */
public class Stack<T> {

    private Node<T> topNode = null;
    private Node<T> bottomNode = null;
    private Node<T> pointerNode;
    private Integer size = 0;
    private Integer indexPosition = -1;

    private class Node<J> {
        private J item;
        private Node<J> prevNode;
        private Node<J> nextNode;

        public void setItem(J item) {
            this.item = item;
        }

        public J getItem() {
            return item;
        }

        public void setPrevNode(Node<J> prevNode) {
            this.prevNode = prevNode;
        }

        public Node<J> getPrevNode() {
            return this.prevNode;
        }

        public void setNextNode(Node<J> nextNode) {
            this.nextNode = nextNode;
        }

        public Node<J> getNextNode() {
            return this.nextNode;
        }
    }

    private void setTopNode(Node<T> node) {
        topNode = node;
    }

    private Node<T> getTopNode() {
        return topNode;
    }

    private void setBottomNode(Node<T> node) {
        bottomNode = node;
    }

    private Node<T> getBottomNode() {
        return bottomNode;
    }

    private void setPointerNode(Node<T> node) {
        this.pointerNode = node;
    }

    private Node<T> getPointerNode() {
        return this.pointerNode;
    }

    /**
     * Add new record to the top of the stack.
     *
     * @param item - add new item
     */
    public void push(T item) {
        Node<T> orgTopNode = getTopNode();

        topNode = new Node<>();
        topNode.setItem(item);
        topNode.setPrevNode(orgTopNode);

        if (orgTopNode == null) {
            setBottomNode(topNode);
            setPointerNode(getBottomNode());
        } else {
            orgTopNode.setNextNode(topNode);
        }

        setSize(getSize() + 1);

    }

    /**
     * Remove the top record in the stack.
     *
     * @return value of the top record.
     */
    public T pop() {
        if (topNode == null) {
            return null;
        }
        T item = topNode.getItem();
        setTopNode(topNode.getPrevNode());
        setSize(getSize() - 1);
        return item;
    }

    public T getTop() {
        return topNode.getItem();
    }

    public T getBottom() {
        return getBottomNode().getItem();
    }

    private void setSize(Integer lsize) {
        size = lsize;
    }

    public Integer getSize() {
        return size;
    }

    private void setIndexPosition(Integer index) {
        indexPosition = index;
    }

    public void resetRecordPosition() {
        setIndexPosition(0);
        setPointerNode(getBottomNode());
    }

    public Integer getIndexPosition() {
        return this.indexPosition;
    }

    public T iteratorValue() {
        return this.getPointerNode().getItem();
    }

    /**
     * Move node pointer to next available and return value.
     *
     * @return - item value.
     */
    public T iteratorNext() {
        if (this.getPointerNode().getNextNode() == null) {
            return null;
        }

        this.setPointerNode(this.getPointerNode().getNextNode());
        indexPosition++;

        return this.getPointerNode().getItem();
    }
}
