package com.stevancorre.cda.gui;

import com.stevancorre.cda.gui.medias.MediasPanel;
import com.stevancorre.cda.gui.members.MembersPanel;
import com.stevancorre.cda.mediaLibrary.MediaLibrary;

import javax.swing.*;
import java.awt.*;

import static com.stevancorre.cda.gui.GUIUtils.makeTextPanel;

public class MainView extends JPanel {
    public MainView(final MediaLibrary mediaLibrary) {
        super(new BorderLayout());

        add(new JTabbedPane() {{
            addTab("Medias", new MediasPanel(mediaLibrary));
            addTab("Members", new MembersPanel(mediaLibrary));

            final JComponent panel3 = makeTextPanel("Panel #3");
            addTab("Loans", panel3);
        }});
    }
}
