package com.stevancorre.cda.gui;

import com.stevancorre.cda.mediaLibrary.MediaLibrary;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(final String title, final MediaLibrary mediaLibrary) {
        super(title);

        setSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new MainView(mediaLibrary));
    }
}
