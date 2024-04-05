package model;

import java.util.List;

public record Contact(
        Long contactId,
        String firstName,
        String lastName,
        String company,
        String job,
        List<Email> email,
        List<Phone> phone)

{
    @Override
    public Long contactId() {
        return contactId;
    }

    @Override
    public String firstName() {
        return firstName;
    }

    @Override
    public String lastName() {
        return lastName;
    }

    @Override
    public String company() {
        return company;
    }

    @Override
    public String job() {
        return job;
    }

    @Override
    public List<Email> email() {
        return email;
    }

    @Override
    public List<Phone> phone() {
        return phone;
    }
}
