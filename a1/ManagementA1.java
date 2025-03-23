package de.ostfalia.aud.ss25.a1;

import de.ostfalia.aud.ss25.base.Group;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IManagement;
import de.ostfalia.aud.ss25.base.IMember;

import java.io.IOException;

public class ManagementA1 implements IManagement {

    public ManagementA1(String[] data){

    }

    public ManagementA1(String dateiname) throws IOException {

    }

    @Override
    public boolean insert(IMember member) {
        return false;
    }

    @Override
    public boolean remove(String id) {
        return false;
    }

    @Override
    public IMember search(String id) {
        return null;
    }

    @Override
    public IAlgoCollection<IMember> members(String surname, String forename) {
        return null;
    }

    @Override
    public IAlgoCollection<IMember> members(Group group) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int size(Group group) {
        return 0;
    }

    @Override
    public int indexOf(String id) {
        return 0;
    }

    @Override
    public IMember[] toArray() {
        return new IMember[0];
    }
}
