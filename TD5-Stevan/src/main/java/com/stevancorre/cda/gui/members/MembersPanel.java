package com.stevancorre.cda.gui.members;

import com.stevancorre.cda.mediaLibrary.MediaLibrary;
import com.stevancorre.cda.mediaLibrary.Member;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MembersPanel extends JPanel {
    private final MediaLibrary mediaLibrary;

    private final EditMemberPanel editMemberPanel;
    private final JSplitPane layout;
    private final DefaultTableModel model;

    public MembersPanel(final MediaLibrary mediaLibrary) {
        super(new BorderLayout());

        this.mediaLibrary = mediaLibrary;

        model = new DefaultTableModel(0, 0);
        editMemberPanel = new EditMemberPanel(mediaLibrary) {{
            setMemberUpdatedListener(() -> onMemberEditingDone());
        }};
        layout = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, makeTable(), editMemberPanel) {{
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
        selectionModel.addListSelectionListener(this::handleSelectMember);

        return new JScrollPane(table) {
            @Override
            public Dimension getMinimumSize() {
                int parentWidth = getParent().getSize().width;
                Dimension d = getSize();
                d.width = parentWidth - 300;

                return d;
            }
        };
    }

    private void handleSelectMember(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) return;

        final DefaultListSelectionModel target = (DefaultListSelectionModel) e.getSource();
        final int index = target.getAnchorSelectionIndex();
        if (index == -1) return;

        final Member member = mediaLibrary.members().get(index);

        if (!editMemberPanel.isVisible()) {
            layout.setDividerSize(10);
            layout.setDividerLocation(getParent().getWidth() - 216);
        }

        editMemberPanel.setSelectedMember(member);
    }

    private Object[] extractData(final Member member) {
        return new Object[]{
                member.getId(),
                member.getFirstName(),
                member.getLastName()};
    }

    private void updateData() {
        model.setDataVector(
                mediaLibrary.members()
                        .stream()
                        .map(this::extractData)
                        .toArray(Object[][]::new),
                new String[]{"Id", "Description", "Category"}
        );
    }

    private void onMemberEditingDone() {
        layout.setDividerSize(0);
        updateData();
    }
}