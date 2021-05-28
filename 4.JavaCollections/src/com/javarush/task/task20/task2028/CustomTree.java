package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{

    List<Entry<String>> list;

    Entry<String> root;

    public CustomTree() {
        root = new Entry<>("0");
        list = new ArrayList<>();
        list.add(root);
    }

    @Override
    public boolean add(String s) {
        Entry<String> newEntry = new Entry<>(s);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).availableToAddLeftChildren) {
                list.get(i).availableToAddLeftChildren = false;
                list.get(i).leftChild = newEntry;
                newEntry.parent = list.get(i);
                list.add(newEntry);
                return true;
            } else if (list.get(i).availableToAddRightChildren) {
                list.get(i).availableToAddRightChildren = false;
                list.get(i).rightChild = newEntry;
                newEntry.parent = list.get(i);
                list.add(newEntry);
                return true;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (!list.contains(list.get(i).leftChild)) {
                list.get(i).leftChild = null;
            }
            if (!list.contains(list.get(i).rightChild)) {
                list.get(i).rightChild = null;
            }
        }

        Entry<String> parent;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).leftChild == null) {
                parent = list.get(i);
                list.get(i).availableToAddLeftChildren = true;
            }
            if (list.get(i).rightChild == null) {
                parent = list.get(i);
                list.get(i).availableToAddLeftChildren = true;
            }
        }

        return add(s);
    }

    @Override
    public int size() {
        return list.size() - 1;
    }

    public String getParent(String s) {
        int index = list.indexOf(new Entry<String>(s));
        return index != -1 ? list.get(index).parent.elementName : "null";
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        int initialListSize = list.size();

        int index = list.indexOf(new Entry<String>((String) o));
        Entry<String> entry = list.get(index);

        if (entry.leftChild != null) {
            remove(entry.leftChild.elementName);
        }
        if (entry.rightChild != null) {
            remove(entry.rightChild.elementName);
        }

        list.remove(entry);

        int sizeAfterRemove = list.size();

        return initialListSize != sizeAfterRemove;
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
    public boolean addAll(int index, Collection<? extends String> c) {
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

    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddRightChildren | availableToAddLeftChildren;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?> entry = (Entry<?>) o;
            return Objects.equals(elementName, entry.elementName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(elementName);
        }
    }
}

