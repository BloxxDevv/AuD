package de.ostfalia.aud.ss25;

import de.ostfalia.aud.ss25.a1.ManagementA1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            ManagementA1 managementA1 = new ManagementA1("40k_member.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
