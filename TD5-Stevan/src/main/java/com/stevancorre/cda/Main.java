// Projet 1 CDA
// 
// NOM,Prenom
// NOM,Prenom
//
package com.stevancorre.cda;

import com.stevancorre.cda.gui.GUI;
import com.stevancorre.cda.mediaLibrary.Loan;
import com.stevancorre.cda.mediaLibrary.Media;
import com.stevancorre.cda.mediaLibrary.MediaLibrary;
import com.stevancorre.cda.mediaLibrary.Member;

import java.util.Date;

import static javax.swing.SwingUtilities.invokeLater;

public final class Main {
    public static void main(final String[] args) {
        final MediaLibrary mediaLibrary = new MediaLibrary();

        final Media media1 = mediaLibrary.createMedia("Livre", null, "desc1", 12, 2022);
        final Media media3 = mediaLibrary.createMedia("Livre", null, "desc1", 12, 2022);
        final Media media2 = mediaLibrary.createMedia("DVD", "horreur", "desc2", 10, 2022);

        System.out.println(media1.equals(media3));

        final Member member1 = mediaLibrary.registerMember("fffafa", "groignegre", new Date());
        final Member member2 = mediaLibrary.registerMember("gzggrzg", "zz", new Date());

        final Loan loan1 = mediaLibrary.loan(member1, media1);

        // https://stackoverflow.com/a/3551578
        invokeLater(() -> {
            final GUI gui = new GUI("Media Library", mediaLibrary);
            gui.show();
        });
    }
}
