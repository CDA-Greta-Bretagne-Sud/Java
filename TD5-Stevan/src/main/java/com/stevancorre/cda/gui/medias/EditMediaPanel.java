package com.stevancorre.cda.gui.medias;

import com.stevancorre.cda.mediaLibrary.Media;
import com.stevancorre.cda.mediaLibrary.MediaLibrary;
import com.stevancorre.cda.mediaLibrary.Member;

import javax.swing.*;
import java.awt.*;

import static com.stevancorre.cda.gui.GUIUtils.*;

public class EditMediaPanel extends JPanel {
    private final MediaLibrary mediaLibrary;
    private Media selectedMedia;

    private final JTextField descriptionField;
    private final JTextField categoryField;
    private final JTextField subCategoryField;
    private JButton loanButton;
    private JButton deleteButton;

    private Runnable onEditingDone;

    public EditMediaPanel(final MediaLibrary mediaLibrary) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.mediaLibrary = mediaLibrary;

        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Edit"));

        setMinimumSize(new Dimension(200, 0));

        descriptionField = makeTextField();
        categoryField = makeTextField();
        subCategoryField = makeTextField();

        add(new JPanel() {{
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            add(makeLabel("Description", l -> l.setLabelFor((descriptionField))));
            add(descriptionField);
        }});

        add(Box.createRigidArea(new Dimension(0, 10)));

        add(new JPanel() {{
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            add(makeLabel("Category", l -> l.setLabelFor((categoryField))));
            add(categoryField);
        }});

        add(Box.createRigidArea(new Dimension(0, 10)));

        add(new JPanel() {{
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            add(makeLabel("Subcategory", l -> l.setLabelFor((subCategoryField))));
            add(subCategoryField);
        }});

        add(Box.createRigidArea(new Dimension(0, 10)));

        add(makeButtonsPanel());

        setVisible(false);
    }

    private JComponent makeThumbnail() {
        return new ThumbnailPanel();
    }

    private JComponent makeButtonsPanel() {
        return new JPanel() {{
            add(new JPanel() {{
                final GridLayout layout = new GridLayout(2, 2) {{
                    setVgap(5);
                    setHgap(5);
                }};

                setLayout(layout);

                loanButton = makeButton("Loan", b -> b.addActionListener(e -> loanMedia()));
                deleteButton = makeButton("Delete", b -> b.addActionListener(e -> deleteMedia()));

                add(makeButton("Save", b -> b.addActionListener(e -> saveMedia())));
                add(makeButton("Cancel", b -> b.addActionListener(e -> unselectMedia())));
                add(loanButton);
                add(deleteButton);
            }});
        }};
    }

    private void updateView() {
        descriptionField.setText(selectedMedia.getDescription());
        categoryField.setText(selectedMedia.getCategory());
        subCategoryField.setText(selectedMedia.getSubCategory());

        loanButton.setEnabled(!selectedMedia.isLoaned());
        deleteButton.setEnabled(!selectedMedia.isLoaned());
    }

    public void setSelectedMember(final Media media) {
        selectedMedia = media;

        updateView();
        setVisible(true);
    }

    private void saveMedia() {
        selectedMedia.setDescription(descriptionField.getText());
        selectedMedia.setCategory(categoryField.getText());
        selectedMedia.setSubCategory(subCategoryField.getText());

        unselectMedia();
    }

    private void loanMedia() {
        final Member[] members = mediaLibrary.members().toArray(new Member[0]);

        final Member member = (Member) JOptionPane.showInputDialog(
                this,
                "Pick a member",
                "Loaner selection",
                JOptionPane.QUESTION_MESSAGE, null,
                members,
                members[0]);

        if (member == null) return;

        mediaLibrary.loan(member, selectedMedia);

        unselectMedia();
    }

    private void deleteMedia() {
        mediaLibrary.medias().remove(selectedMedia);

        unselectMedia();
    }

    private void unselectMedia() {
        selectedMedia = null;
        setVisible(false);
        onEditingDone.run();
    }

    public void setMediaUpdatedListener(final Runnable listener) {
        onEditingDone = listener;
    }
}
