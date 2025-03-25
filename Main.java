package de.ostfalia.aud.ss25;

import de.ostfalia.aud.ss25.a0.Member;
import de.ostfalia.aud.ss25.a1.ManagementA1;
import de.ostfalia.aud.ss25.base.IMember;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            long l = System.nanoTime();
            ManagementA1 managementA1 = new ManagementA1("10_member.csv");
            printArray(managementA1.toArray());
            managementA1.remove("GI-100144");
            System.out.println(managementA1.members.size());
            printArray(managementA1.toArray());
            managementA1.remove("GI-100145");
            System.out.println(managementA1.members.size());
            printArray(managementA1.toArray());
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printArray(IMember[] managementA1){
        System.out.print("{");
        for (int i = 0; i < managementA1.length; i++) {
            System.out.print(managementA1[i]);
        }
        System.out.println("}");
    }

}
