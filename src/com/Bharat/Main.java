package com.Bharat;


import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static MobilePhone mobilePhone = new MobilePhone("8178053874");

    public static void main(String[] args) {
        System.out.println("Starting Phone ...");
        printInformation();
        boolean flag = false;

        while (!flag){
            int choice = scanner.nextInt();
            scanner.nextLine();
//            flag = true;
            switch (choice){
                case 0:
                    printInformation();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContacts();
                    break;
                case 3:
                    modifyContacts();
                    break;
                case 4:
                    removeContacts();
                    break;
                case 5:
                    searchContacts();
                    break;
                case 6:
//                    quit();
                    System.out.println("Switching off Phone ....");
                    flag = true;
                    break;
            }
        }

    }
    public static void printInformation(){
        System.out.println(" Available Actions ");
        System.out.println(" 0 - To Print Information");
        System.out.println(" 1 - To Print Contacts");
        System.out.println(" 2 - To Add Contacts");
        System.out.println(" 3 - To Modify Contacts");
        System.out.println(" 4 - To Delete Contacts");
        System.out.println(" 5 - To Search Contacts");
        System.out.println(" 6 - To Switch off Phone");
    }


    public static void addContacts(){

        System.out.println("Enter New Contact Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        Contacts contacts = Contacts.createContact(name.toLowerCase(Locale.ROOT),phoneNumber);
        mobilePhone.addContact(contacts);
    }

    public static void modifyContacts(){
        System.out.println("Enter Old Contact Name: ");
        String  oldContactName = scanner.nextLine();
        Contacts oldContact = mobilePhone.queryContact(oldContactName.toLowerCase(Locale.ROOT));
        if (oldContact == null){
            System.out.println("Contact Name " + oldContactName + ", Does not Exists");
            return;
        }
        System.out.println("Enter New Contact Name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter New Phone Number: ");
        String newPhoneNumber = scanner.nextLine();
        Contacts newContacts = Contacts.createContact(newName.toLowerCase(Locale.ROOT),newPhoneNumber);

        if (mobilePhone.modifyContact(oldContact,newContacts)){
            System.out.println("Modification Successfully");
        }else {
            System.out.println("Contact not found on the list");
        }

    }

    public static void removeContacts(){
        System.out.println("Enter Contact Name you want to Delete ");
        String name = scanner.nextLine();
        Contacts removeContact = mobilePhone.queryContact(name.toLowerCase(Locale.ROOT));
        if (removeContact == null){
            System.out.println("Contact Name " + name + ", Does not Exists");
            return;
        }
        if (mobilePhone.removeContact(removeContact)){
            System.out.println("Removed Successfully");
        }else{
            System.out.println("Contact not Found");
        }
    }

    public static void searchContacts(){
        System.out.println("Enter Contact Name you want to Search ");
        String name = scanner.nextLine();
        Contacts Contact = mobilePhone.queryContact(name.toLowerCase(Locale.ROOT));
        if (Contact==null){
            System.out.println("Contact not Found");
            return;
        }
        System.out.println("Name --> " + Contact.getName() +
                            "\nPhoneNumber --> " + Contact.getNumber());

    }





}
