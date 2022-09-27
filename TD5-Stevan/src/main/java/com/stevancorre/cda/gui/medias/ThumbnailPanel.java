package com.stevancorre.cda.gui.medias;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ThumbnailPanel extends JPanel {
    static final int MAX_HEIGHT = 500;
    static final int MAX_WIDTH = 400;

    private BufferedImage image;

    public ThumbnailPanel() {
        try {
            image = ImageIO.read(new File("src/main/resources/watchtower-1.png"));
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final float width = Math.min(getWidth(), MAX_WIDTH);
        final float height = image.getHeight() * (width / image.getWidth());

        final float sourceHeight = (float) (image.getWidth() * MAX_HEIGHT) / width;

        setSize((int) width, (int) Math.min(height, MAX_HEIGHT));

        if (height > MAX_HEIGHT) {
            g.drawImage(image,
                    0, 0,
                    (int) width, MAX_HEIGHT,
                    0, 0,
                    image.getWidth(), (int) sourceHeight,
                    null);
        } else
            g.drawImage(image,
                    0, 0,
                    (int) width, (int) height,
                    null);
    }
}
