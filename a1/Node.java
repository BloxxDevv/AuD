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
}
