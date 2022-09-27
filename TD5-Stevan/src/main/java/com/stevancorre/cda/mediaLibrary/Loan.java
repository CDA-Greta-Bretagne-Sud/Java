package com.stevancorre.cda.mediaLibrary;

import java.util.Date;

public final class Loan {
    private final Media media;
    private final Member member;
    private final Date date;

    Loan(final Media media, final Member member, final Date date) {
        this.media = media;
        this.member = member;
        this.date = date;
    }

    public Media getMedia() {
        return media;
    }

    public Member getMember() {
        return member;
    }

    public Date getDate() {
        return date;
    }
}
