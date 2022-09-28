package com.stevancorre.cda.mediaLibrary;

import java.util.ArrayList;
import java.util.Date;

public final class Member {
    private final long id;
    private String firstName;

    private String lastName;
    private Date birthDate;

    private final ArrayList<Long> loanedMedias;

    Member(final long id, final String firstName, final String lastName, final Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;

        loanedMedias = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
