package com.stevancorre.cda.gui.medias;

import com.stevancorre.cda.mediaLibrary.Media;
import com.stevancorre.cda.mediaLibrary.MediaLibrary;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MediasPanel extends JPanel {
    private final MediaLibrary mediaLibrary;

    private final EditMediaPanel editMediaPanel;
    private final JSplitPane layout;
    private final DefaultTableModel model;

    public MediasPanel(final MediaLibrary mediaLibrary) {
        super(new BorderLayout());

        this.mediaLibrary = mediaLibrary;

        model = new DefaultTableModel(0, 0);
        editMediaPanel = new EditMediaPanel(mediaLibrary) {{
            setMediaUpdatedListener(() -> onMediaEditingDone());
        }};
        layout = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, makeTable(), editMediaPanel) {{
            setDividerSize(0);
        }};

        add(layout);
    }

    private JComponent makeTable() {
        updateData();

        final JTable table = new JTable(model) {{
            setDefaultEditor(Object.class, null);
            setAutoCreateRowSorter(true);
            setFillsViewportHeight(true);
        }};

        final ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(this::handleSelectMedia);

        return new JScrollPane(table) {
            @Override
            public Dimension getMinimumSize() {
                int parentWidth = getParent().getSize().width;
                Dimension d = getSize();
                d.width = parentWidth - ThumbnailPanel.MAX_WIDTH;

                return d;
            }
        };
    }

    private void handleSelectMedia(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) return;

        final DefaultListSelectionModel target = (DefaultListSelectionModel) e.getSource();
        final int index = target.getAnchorSelectionIndex();
        if (index == -1) return;

        final Media media = mediaLibrary.medias().get(index);

        if (!editMediaPanel.isVisible()) {
            layout.setDividerSize(10);
            layout.setDividerLocation(getParent().getWidth() - 216);
        }

        editMediaPanel.setSelectedMember(media);
    }

    private Object[] extractData(final Media media) {
        return new Object[]{
                media.getId(),
                media.getDescription(),
                media.getCategory(),
                media.getSubCategory(),
                media.getDate()};
    }

    private void updateData() {
        model.setDataVector(
                mediaLibrary.medias()
                        .stream()
                        .map(this::extractData)
                        .toArray(Object[][]::new),
                new String[]{"Id", "Description", "Category", "Subcategory", "Date"}
        );
    }

    private void onMediaEditingDone() {
        layout.setDividerSize(0);
        updateData();
    }
}