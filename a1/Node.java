package de.ostfalia.aud.ss25.a1;

import de.ostfalia.aud.ss25.base.IMember;

import java.util.Comparator;

public class Node {

    private IMember data;

    private Node nextNode = null;
    private int index = 0;

    public Node (IMember o, int index){
        data = o;
        this.index = index;
    }

    public void addNextNode(Node n){
        nextNode = n;
    }

    public Node getNextNode(){
        return nextNode;
    }

    public IMember get(IMember m){
        if (data.equals(m)){
            return m;
        }
        if (nextNode != null)
            return nextNode.get(m);
        return null;
    }

    public int indexOf(IMember m){
        if (data.equals(m)){
            return index;
        }
        if (nextNode != null)
            return nextNode.indexOf(m);
        return -1;
    }

    public void toArray(IMember[] array){
        array[index] = data;
        if (nextNode != null)
            nextNode.toArray(array);
    }

    public IMember getData(){
        return data;
    }

    public int getIndex() {
        return index;
    }

    public int size(Comparator<IMember> c, IMember m, int currentSize) {
        if (nextNode != null){
            if (c.compare(data, m) == 0){
                return nextNode.size(c, m, currentSize+1);
            }else {
                return nextNode.size(c, m, currentSize);
            }
        }else{
            return currentSize;
        }
    }

    public boolean removeMember(IMember m) {
        if (data.equals(m)) {
            if (nextNode != null) {
                this.data = nextNode.data;
                this.index = nextNode.index;
                this.nextNode = nextNode.nextNode;
            } else {
                this.data = null;
                this.index = -1;
                this.nextNode = null;
                return true;
            }
            updateIndexes(nextNode, index);

        }

        if (nextNode != null) {
            if (nextNode.data.equals(m)) {
                nextNode = nextNode.nextNode;
                updateIndexes(this, index);
            } else {
                nextNode.removeMember(m);
            }
        }
        return false;


    }

    private void updateIndexes(Node node, int startIndex) {
        while (node != null) {
            node.index = startIndex;
            startIndex++;
            node = node.nextNode;
        }
    }
}
