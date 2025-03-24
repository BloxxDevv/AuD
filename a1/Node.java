package de.ostfalia.aud.ss25.a1;

import de.ostfalia.aud.ss25.base.IMember;

import java.util.Comparator;

public class Node {

    //Inhalt des Nodes
    private IMember data;

    //Benachbartes node
    private Node nextNode = null;
    //Stelle der Node
    private int index = 0;

    //Node Konstruktor (Inhalt, Stelle)
    public Node (IMember o, int index){
        this.data = o;
        this.index = index;
    }

    //Hänge nächstes node ran. (für addNode das letzte Element)
    public void addNextNode(Node n){
        nextNode = n;
    }

    //Getter
    public Node getNextNode(){
        return nextNode;
    }

    //Returned Member wenn der Inhalt dieses Nodes = m ist (sonst null)
    public IMember get(IMember m){
        if (data.equals(m)){
            return m;
        }
        return null;
    }

    //Getter von IMember aus der Node
    public IMember getData(){
        return data;
    }

    //Inhalt Setter
    public void setData(IMember data) {
        this.data = data;
    }

    //Stelle Setter
    public void setIndex(int index) {
        this.index = index;
    }

    //Nächstes Node Setter
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    //Getter der Stelle
    public int getIndex() {
        return index;
    }
}
