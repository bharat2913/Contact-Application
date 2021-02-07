package com.Bharat;

import java.util.ArrayList;
import java.util.Locale;


public class MobilePhone {

    public String number;
    public ArrayList<Contacts> myContacts;

    public MobilePhone(String number) {
        this.number = number;
        this.myContacts = new ArrayList<>();
    }

    public void printContacts(){
        System.out.println("Contact List");
        for (int i=0; i<myContacts.size(); i++){
            System.out.println((i+1) + ". " +
                    myContacts.get(i).getName() + " --> " +
                    myContacts.get(i).getNumber());
        }
    }

    public void addContact(Contacts  contact){
        if (findContact(contact.getName()) < 0 ) {
            myContacts.add(contact);
            System.out.println("Your Contact is Successfully added");
//            return true;
        }else {
            System.out.println(contact.getName() + ", is already in the list");
//            return false;
        }
    }
    public boolean modifyContact(Contacts oldContact,Contacts newContact){
//        int findPosition = findContact(oldName);
        if(findContact(oldContact) < 0) {
            System.out.println(oldContact.getName() + ", was not Found");

            return false;
        } else if (findContact(newContact.getName()) != -1){
            System.out.println("Contact with Name " + newContact.getName() + ", Already in the List, Update not Successful");
            return false;
        }

        myContacts.set(findContact(oldContact), newContact);
        System.out.println(oldContact.getName() + ", is Replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contacts contact){
        if (findContact(contact) >= 0){
            myContacts.remove(findContact(contact));
            System.out.println(contact.getName() + ", is Successfully Deleted");
            return true;
        }else {
            System.out.println(contact.getName() + ", does not Exists");
            return false;
        }
    }

    public int findContact(Contacts name){
        return myContacts.indexOf(name);
    }

    public int findContact(String name){
        for (int i=0; i<myContacts.size(); i++) {
            Contacts contacts = myContacts.get(i);
            if (contacts.getName().equals(name.toLowerCase(Locale.ROOT))) {
                return i;
            }
        }
        return -1;
    }

    public Contacts queryContact(String name){
        if (findContact(name.toLowerCase(Locale.ROOT))>=0){
          return myContacts.get(findContact(name));
        }
        return null;
    }

}
