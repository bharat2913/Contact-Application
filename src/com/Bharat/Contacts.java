package com.Bharat;

import java.util.Locale;

public class Contacts {
    public String name;
    public String number;

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() { return name.toLowerCase(Locale.ROOT); }

    public String getNumber() { return number; }

    public static Contacts createContact(String name, String phoneNumber){
        return new Contacts(name,phoneNumber);
    }


}
