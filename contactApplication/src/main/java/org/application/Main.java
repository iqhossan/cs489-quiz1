package org.application;

import model.Contact;
import model.Email;
import model.Phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Email> emaiList = new ArrayList<>();
        List<Phone> phoneList = new ArrayList<>();
        emaiList.add(new Email("dave.sang@gmail.com", "Home"));
        emaiList.add(new Email("dsanger@argos.com", "Mobile"));

        phoneList.add(new Phone("240-133-0011", "Home"));
        phoneList.add(new Phone("240-112-0123", "Work"));

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(101L, "David", "Sanger", "Argos LLC", "Sales Manager",
                emaiList,phoneList));
        contacts.add(new Contact(101L, "David", "Sanger", "Argos LLC", "Sales Manager",
                null, null));

        emaiList.add(new Email("ali@bmi.com", "Work"));
        phoneList.add(new Phone("412-116-9988", "Work"));

        contacts.add(new Contact(101L, "David", "Sanger", "Argos LLC", "Sales Manager",
                emaiList, phoneList));


        Collections.sort(contacts, Comparator.comparing(Contact::lastName));

        System.out.println("JSON-formatted list of all Contacts:");
        printToJson1(contacts);

//        var contact = List.of(new Contact(101L,"David","Sanger","Argos LLC","Sales Manager",
//                (Email) emaiList, (Phone)phoneList));


    }

    private static void printToJson1(List<Contact> contacts) {

        System.out.println("[");
        for (int i = 0; i<contacts.size(); i++) {
            List<Email> emails = contacts.get(i).email();
            List<Phone> phone = contacts.get(i).phone();
            System.out.println("""
                            {  
                                "First Name":%s,
                                "Last Name":"%s",
                                "Company":"%s",
                                "Job Title":"%s",
                                "Phone":%s, 
                                "Email":%s
                            },
                            """.formatted(
                        contacts.get(i).firstName(),
                        contacts.get(i).lastName(),
                        contacts.get(i).company(),
                        contacts.get(i).job(),
                        getEmail(emails),
                        getPhone(phone)
            ));
        }
        System.out.println("]");
    }

    private static String getEmail(List<Email> emails){
       String str = "";
        if(emails != null) {
            for (Email email : emails) {
                str += " { email: " + email.getEmail() + ", label : " + email.getLabel() + " }, ";
            }
        }
        return str;
    }

    private static String getPhone(List<Phone> phones){
        String str = "";
        if(phones != null) {
            for (Phone phone : phones) {
                str += " { phone no : " + phone.getPhone() + ", label : " + phone.getLabel() + " }, ";
            }
        }
        return str;
    }

}