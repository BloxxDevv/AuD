package de.ostfalia.aud.ss25.a1;

import de.ostfalia.aud.ss25.a0.Member;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;

import java.util.Comparator;

public class AlgoLinkedList implements IAlgoCollection<IMember> {

    private Node firstNode = null;
    private Node lastNode = null;

    private int size = 0;

    public Node getFirstNode() {
        return firstNode;
    }

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
        Node current = firstNode;
        while (current != null){
            if (current.getData().equals(m)) {
                if (current.getNextNode() != null) {
                    current.setData(current.getNextNode().getData());
                    current.setIndex(current.getNextNode().getIndex());
                    current.setNextNode(current.getNextNode().getNextNode());
                } else {
                    current.setData(null);
                    current.setIndex(-1);
                    current.setNextNode(null);
                    return true;
                }
                updateIndexes(current.getNextNode(), current.getIndex());

            }

            if (current.getNextNode() != null) {
                if (current.getNextNode().getData().equals(m)) {
                    current.setNextNode(current.getNextNode().getNextNode());
                    updateIndexes(current, current.getIndex());
                    break;
                }
            }
            current = current.getNextNode();
        }

        return false;
    }

    private void updateIndexes(Node node, int startIndex) {
        while (node != null) {
            node.setIndex(startIndex);
            startIndex++;
            node = node.getNextNode();
        }
    }

    @Override
    public IMember get(IMember m) {
        Node current = firstNode;
        IMember member = null;
        while (current != null){
            member = current.get(m);
            if (member != null)
                break;
            else current = current.getNextNode();
        }
        return member;
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
        Node current = firstNode;
        while (current != null){
            if (current.get(m) != null)
                break;
            else current = current.getNextNode();
        }
        return current != null ? current.getIndex() : -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int size(Comparator<IMember> c, IMember m) {
        if (size == 0) return 0;

        Node current = firstNode;

        int counter = 0;

        while (current != null){
            if (c.compare(current.getData(), m) == 0){
                counter++;
            }
            current = current.getNextNode();
        }

        return counter;
    }

    @Override
    public IMember[] toArray() {
        if (size() == 0) return new IMember[]{};

        IMember[] members = new IMember[size];

        Node current = firstNode;
        int c = 0;

        while (current != null){
            members[c] = current.getData();
            c++;
            current = current.getNextNode();
        }
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
