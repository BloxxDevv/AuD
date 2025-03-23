package de.ostfalia.aud.ss25.a1;

import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;

import java.util.Comparator;

public class AlgoLinkedList implements IAlgoCollection<IMember> {

    private Node firstNode = null;
    private Node lastNode = null;

    private int size = 0;

    @Override
    public boolean add(IMember m) {
        if (m == null)
            return false;

        Node n = new Node(m, size);
        if (size++ == 0){
            firstNode = n;
        }else{
            lastNode.addNextNode(n);
        }
        lastNode = n;
        return true;
    }

    @Override
    public boolean remove(IMember m) {
        return false;
    }

    @Override
    public IMember get(IMember m) {
        return firstNode.get(m);
    }

    @Override
    public IAlgoCollection<IMember> getAll(Comparator<IMember> c, IMember m) {
        AlgoLinkedList all = new AlgoLinkedList();

        Node current = firstNode;

        while (current != null){
            if (c.compare(current.getData(), m) == 0)
                all.add(current.getData());
            current = current.getNextNode();
        }

        return all;
    }

    @Override
    public int indexOf(IMember m) {
        return firstNode.indexOf(m);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int size(Comparator<IMember> c, IMember m) {
        if (size == 0) return 0;
        return firstNode.size(c, m, 0);
    }

    @Override
    public IMember[] toArray() {
        if (size() == 0) return new IMember[]{};

        IMember[] members = new IMember[size];

        firstNode.toArray(members);

        return members;
    }

    @Override
    public String toString() {
        Node current = firstNode;
        String out = "";

        while (current != null){
            out += current.getData();

            current = current.getNextNode();
        }

        return out;
    }
}
