package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>(Math.max(16, (int) Math.ceil(collection.size() / .75f)));
        addAll(collection);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        AmigoSet copy;
        try {
            copy = (AmigoSet) super.clone();
            copy.map = (HashMap) map.clone();
        } catch (Exception e) {
            throw new InternalError(e);
        }
        return copy;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean flag = true;
        for (E obj : c) {
            if (!add(obj)) {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();

        objectOutputStream.writeObject(map.size());
        for (E e : map.keySet()) {
            objectOutputStream.writeObject(e);
        }
        objectOutputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        objectOutputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();

        int size = (int) objectInputStream.readObject();
        Set<E> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add((E) objectInputStream.readObject());
        }
        int capacity = (int) objectInputStream.readObject();
        float loadFactor = (float) objectInputStream.readObject();
        map = new HashMap<>(capacity, loadFactor);
        for (E e : set) {
            map.put(e, PRESENT);
        }
    }
}
