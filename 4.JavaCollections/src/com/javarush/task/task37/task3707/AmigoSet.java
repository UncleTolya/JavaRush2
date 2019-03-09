package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet(){
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int cap = Math.max(16, (int)((collection.size()/0.75f) + 1));
        map = new HashMap<>(cap);
        addAll(collection);
    }

    @Override
    public boolean add(E e) {
        int startSize = map.size();
        map.put(e, PRESENT);
        return map.size() > startSize;
    }

    @Override
    public Iterator iterator() {
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
        return map.keySet().contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o).equals(PRESENT);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone(){
        try {
            AmigoSet<E> newSet = (AmigoSet<E>) super.clone();
            newSet.map = (HashMap<E, Object>) map.clone();
            return newSet;
        } catch (Exception error) {
            throw new InternalError(error);
        }
    }


}
