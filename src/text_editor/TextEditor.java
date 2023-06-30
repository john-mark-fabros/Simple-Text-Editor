package text_editor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TextEditor extends JFrame implements ActionListener{

    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JSpinner fontResizespinner;
    private JLabel fontLabel;
    private JButton colorButton;

    public TextEditor(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Text Editor");
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null); // default center


        /*
        * text area
        * */
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));

        /*
         * font label
         * */
        fontLabel = new JLabel("Font: ");

        /*
        * scroll pane
        * */
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(480, 470));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        /*
        * font size spinner
        * */
        fontResizespinner = new JSpinner();
        fontResizespinner.setPreferredSize(new Dimension(50, 25));
        fontResizespinner.setValue(12);
        fontResizespinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, (int) fontResizespinner.getValue()));
            }
        });

        /*
        * color button
        * */
        colorButton = new JButton("Color: ");
        colorButton.addActionListener(this);

        this.add(fontLabel);
        this.add(fontResizespinner);
        this.add(colorButton);
        this.add(scrollPane);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == colorButton) {
            JColorChooser colorChooser = new JColorChooser();

            Color color = colorChooser.showDialog(null, "Choose a color", Color.BLACK);
            textArea.setForeground(color);
        }
    }
}
