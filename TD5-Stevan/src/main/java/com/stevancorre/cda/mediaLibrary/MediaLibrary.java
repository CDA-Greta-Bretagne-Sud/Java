package com.stevancorre.cda.mediaLibrary;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public final class MediaLibrary {
    private static long lastMediaId = 0;
    private static long lastMemberId = 0;

    private final ArrayList<Media> medias;
    private final ArrayList<Member> members;
    private final ArrayList<Loan> loans;

    public MediaLibrary() {
        medias = new ArrayList<>();
        members = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public Media createMedia(
            final String category,
            final String subCategory,
            final String description,
            final int month,
            final int year) {
        final Media newMedia = new Media(++lastMediaId, category, subCategory, description, month, year);
        ;
        medias.add(newMedia);

        return newMedia;
    }

    public Member registerMember(
            final String firstName,
            final String lastName,
            final Date birthDate
    ) {
        final Member newMember = new Member(++lastMemberId, firstName, lastName, birthDate);
        members.add(newMember);

        return newMember;
    }

    public Loan loan(final Member member, final Media media) {
        if (media.isLoaned())
            throw new IllegalArgumentException("The media is already loaned");

        final Loan loan = new Loan(media, member, new Date());
        media.setIsLoaned(true);
        loans.add(loan);

        return loan;
    }

    public ArrayList<Media> medias() {
        return medias;
    }

    public ArrayList<Loan> loans() {
        return loans;
    }

    public ArrayList<Member> members() {
        return members;
    }
}
