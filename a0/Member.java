package de.ostfalia.aud.ss25.a0;

import de.ostfalia.aud.ss25.base.Group;
import de.ostfalia.aud.ss25.base.IMember;

import java.time.LocalDate;

public class Member implements IMember {

    private String memberInfo;

    private String id;
    private String forename;
    private Group group;
    private LocalDate joiningdate;
    private String surname;
    private boolean newsletter;

    @Override
    public String getForename() {
        return forename;
    }

    @Override
    public Group getGroup() {
        return group;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public LocalDate getJoiningdate() {
        return joiningdate;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public boolean hasNewsletter() {
        return newsletter;
    }

    @Override
    public int compareTo(IMember o) {
        return 0;
    }
    
    public Member(String dataInput){
        memberInfo = dataInput;
        distributeMemberInfo(memberInfo.split(";"));
    }

    @Override
    public String toString(){
        return memberInfo;
    }

    @Override
    public boolean equals(Object memberObject){
        return this.getId().equals(((Member)memberObject).getId());
    }

    private void distributeMemberInfo(String[] info)
    {
        id = info[0].trim();
        joiningdate = LocalDate.parse(info[1].trim());
        surname = info[2].trim();
        forename = info[3].trim();
        group = Group.valueOf(info[4].trim());
        newsletter = info[5].trim().equals("true");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
