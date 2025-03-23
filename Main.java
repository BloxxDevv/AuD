package de.ostfalia.aud.ss25;

import de.ostfalia.aud.ss25.a0.Member;

public class Main {

    public static void main(String[] args) {
        Member member = new Member("GI-105031;1986-07-28;Wolfenbüttel;Björn;FULL;true");
        System.out.println(member.hasNewsletter());
    }

}
