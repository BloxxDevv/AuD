package de.ostfalia.aud.ss25;

import de.ostfalia.aud.ss25.a0.Member;
import de.ostfalia.aud.ss25.a1.AlgoLinkedList;
import de.ostfalia.aud.ss25.a1.ManagementA1;
import de.ostfalia.aud.ss25.base.IMember;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            ManagementA1 managementA1 = new ManagementA1("10_member.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //GI-105031;1986-07-28;Wolfenbüttel;Björn;FULL;true

    private static void printArray(IMember[] managementA1){
        System.out.print("{");
        for (int i = 0; i < managementA1.length; i++) {
            System.out.print(managementA1[i]);
        }
        System.out.println("}");
    }

}
