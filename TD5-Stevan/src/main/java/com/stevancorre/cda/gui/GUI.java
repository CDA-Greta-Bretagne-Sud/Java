package com.stevancorre.cda.gui;

import com.stevancorre.cda.mediaLibrary.MediaLibrary;

import javax.swing.*;

public final class GUI {
    private final JFrame frame;
    private final MediaLibrary mediaLibrary;

    public GUI(final String title, final MediaLibrary mediaLibrary) {
        this.mediaLibrary = mediaLibrary;

        frame = new Window(title, mediaLibrary);
    }

    public void show() {
        frame.setVisible(true);
    }
}
