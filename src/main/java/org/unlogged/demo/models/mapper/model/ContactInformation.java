package org.unlogged.demo.models.mapper.model;

import java.util.List;

public class ContactInformation {
    private List<String> emails;
    private List<String> numbers;

    public ContactInformation(List<String> emails, List<String> numbers) {
        this.emails = emails;
        this.numbers = numbers;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }
}
