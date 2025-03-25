package de.ostfalia.aud.ss25.a1;

import de.ostfalia.aud.ss25.a0.Member;
import de.ostfalia.aud.ss25.base.Group;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IManagement;
import de.ostfalia.aud.ss25.base.IMember;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManagementA1 implements IManagement {

    public IAlgoCollection<IMember> members = new AlgoLinkedList();

    public ManagementA1(String[] data){
        for (int i = 0; i < data.length; i++) {
            insert(new Member(data[i]));
        }
    }

    public ManagementA1(String dateiname) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(dateiname));
        br.readLine();
        while (br.ready()){
            insert(new Member(br.readLine()));
        }
    }

    @Override
    public boolean insert(IMember member) {
        if (members.size() == 0){
            members.add(member);
            return true;
        }

        if (members.get(member) != null)
            return false;
        members.add(member);
        return true;
    }

    @Override
    public boolean remove(String id) {
        IMember m = search(id);

        if (m != null) {
            members.remove(m);
            return true;
        }

        return false;
    }

    @Override
    public IMember search(String id) {
        for (int i = 0; i <members.size(); i++) {
            if (members.toArray()[i].getId().equals(id)){
                return members.toArray()[i];
            }
        }
        return null;
    }

    @Override
    public IAlgoCollection<IMember> members(String surname, String forename) {
        IAlgoCollection<IMember> coll = new AlgoLinkedList();

        for (int i = 0; i <members.size(); i++) {
            if (members.toArray()[i].getSurname().equals(surname) && members.toArray()[i].getForename().equals(forename)){
                coll.add(members.toArray()[i]);
            }
        }

        return coll;
    }

    @Override
    public IAlgoCollection<IMember> members(Group group) {
        IAlgoCollection<IMember> coll = new AlgoLinkedList();

        for (int i = 0; i <members.size(); i++) {
            if (members.toArray()[i].getGroup().equals(group)){
                coll.add(members.toArray()[i]);
            }
        }

        return coll;
    }

    @Override
    public int size() {
        return members.size();
    }

    @Override
    public int size(Group group) {
        int number =0;
        for (int i = 0; i <members.size(); i++) {
            if (members.toArray()[i].getGroup().equals(group)){
                number++;
            }
        }
        return number;
    }

    @Override
    public int indexOf(String id) {
        if (search(id) != null) {
            return members.indexOf(search(id));
        }
        return -1;
    }

    @Override
    public IMember[] toArray() {
        return members.toArray();
    }
}
