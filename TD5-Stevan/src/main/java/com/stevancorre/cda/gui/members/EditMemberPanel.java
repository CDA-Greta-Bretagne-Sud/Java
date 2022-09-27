package com.stevancorre.cda.gui.members;

import com.stevancorre.cda.gui.medias.ThumbnailPanel;
import com.stevancorre.cda.mediaLibrary.MediaLibrary;
import com.stevancorre.cda.mediaLibrary.Member;

import javax.swing.*;
import java.awt.*;

import static com.stevancorre.cda.gui.GUIUtils.*;

public class EditMemberPanel extends JPanel {
    private final MediaLibrary mediaLibrary;
    private Member selectedMember;

    private final JTextField firstNameField;
    private final JTextField lastNameField;

    private Runnable onEditingDone;

    public EditMemberPanel(final MediaLibrary mediaLibrary) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.mediaLibrary = mediaLibrary;

        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Edit"));

        setMinimumSize(new Dimension(200, 0));

        firstNameField = makeTextField();
        lastNameField = makeTextField();

        add(new JPanel() {{
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            add(makeLabel("Description", l -> l.setLabelFor((firstNameField))));
            add(firstNameField);
        }});

        add(Box.createRigidArea(new Dimension(0, 10)));

        add(new JPanel() {{
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            add(makeLabel("Category", l -> l.setLabelFor((lastNameField))));
            add(lastNameField);
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

                add(makeButton("Save", b -> b.addActionListener(e -> saveMember())));
                add(makeButton("Cancel", b -> b.addActionListener(e -> unselectMember())));
                add(makeButton("Unsubscribe", b -> b.addActionListener(e -> unselectMember())));
            }});
        }};
    }

    private void updateView() {
        firstNameField.setText(selectedMember.getFirstName());
        lastNameField.setText(selectedMember.getLastName());
    }

    public void setSelectedMember(final Member member) {
        selectedMember = member;

        updateView();
        setVisible(true);
    }

    private void saveMember() {
        selectedMember.setFirstName(firstNameField.getText());
        selectedMember.setLastName(lastNameField.getText());

        unselectMember();
    }

    private void unselectMember() {
        selectedMember = null;
        setVisible(false);
        onEditingDone.run();
    }

    public void setMemberUpdatedListener(final Runnable listener) {
        onEditingDone = listener;
    }
}
