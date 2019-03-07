package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    private int size;
    private LinkedList<Entry<String>> queue;

    public CustomTree() {
        this.root = new Entry<>("0");

    }


    @Override
    public int size() {
        return size;
    }

    public String getParent(String s) {
        if (s == null) return null;
        queue = new LinkedList<>(Collections.singleton(root));
        Entry<String> next;
        while ((next = queue.poll()) != null) {
            if (next.elementName.equals(s)) {
                break;
            }
            if (next.leftChild != null) queue.add(next.leftChild);
            if (next.rightChild != null) queue.add(next.rightChild);
        }
        if (next == null) return null;

        return next.parent.elementName;
    }
    @Override
    public boolean add(String elementName) {
        queue = new LinkedList<>(Collections.singleton(root));

        Entry<String> next;
        while ((next = queue.poll()) != null) {
            next.checkChildren();
            if (next.isAvailableToAddChildren()) break;
            if (next.leftChild != null) queue.add(next.leftChild);
            if (next.rightChild != null) queue.add(next.rightChild);
        }

        if (next == null) {
            queue = new LinkedList<>(Collections.singleton(root));
            Entry<String> nextEntry;
            while ((nextEntry = queue.poll()) != null) {
                if (nextEntry.leftChild == null) {
                    next = nextEntry;
                    break;
                } else queue.add(nextEntry.leftChild);
                if (nextEntry.rightChild == null) {
                    next = nextEntry;
                } else queue.add(nextEntry.rightChild);
            }
        }

        Entry<String> newChild = new Entry<>(elementName);
        newChild.parent = next;
        if (next.availableToAddLeftChildren)  {
            next.leftChild = newChild;
            next.availableToAddLeftChildren = false;
        }
        else  {
            next.rightChild = newChild;
            next.availableToAddRightChildren = false;
        }
        size++;
        return true;
    }

    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        queue = new LinkedList<>(Collections.singleton(root));
        Entry<String> next;
        while ((next = queue.poll()) != null) {
            if (next.elementName.equals(o)) {
                break;
            }
            if (next.leftChild != null) queue.add(next.leftChild);
            if (next.rightChild != null) queue.add(next.rightChild);
        }
        if (next == null) return false;

        Entry<String> parent;
        if ((parent = next.parent) != null) {
            if (parent.leftChild != null && parent.leftChild.elementName.equals(o)) /// отвязываем ссылку от родителя
                parent.leftChild = null;
            else parent.rightChild = null;
        }

        queue = new LinkedList<>(Collections.singleton(next));
        Entry<String> nextChild;
        while ((nextChild = queue.poll()) != null) {
            if (nextChild.leftChild != null) {
                queue.add(nextChild.leftChild);
            }
            if (nextChild.rightChild != null) {
                queue.add(nextChild.rightChild);
            }
            nextChild = null;
            size--;
        }
        return true;
    }
    


    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (leftChild != null) availableToAddLeftChildren = false;
            if (rightChild != null) availableToAddRightChildren = false;
        }

        boolean isAvailableToAddChildren() {
            checkChildren();
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
}
