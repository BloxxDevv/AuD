package de.ostfalia.aud.ss25.a1;

import de.ostfalia.aud.ss25.base.IAlgoCollection;

import java.util.Comparator;

public class AlgoLinkedList implements IAlgoCollection {
    @Override
    public boolean add(Object m) {
        return false;
    }

    @Override
    public boolean remove(Object m) {
        return false;
    }

    @Override
    public Object get(Object m) {
        return null;
    }

    @Override
    public IAlgoCollection getAll(Comparator c, Object m) {
        return null;
    }

    @Override
    public int indexOf(Object m) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int size(Comparator c, Object m) {
        return 0;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
