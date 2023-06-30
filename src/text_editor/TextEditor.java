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
    private JComboBox fontBox;


    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem exitItem;

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

        /*
        * font box
        * */
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontBox = new JComboBox(fonts);
        fontBox.addActionListener(this);
        fontBox.setSelectedItem("Arial");

        /*
        * START MENU BAR AREA
        * */
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        /*
        * END MENU BAR AREA
        * */

        this.setJMenuBar(menuBar);
        this.add(fontLabel);
        this.add(fontResizespinner);
        this.add(colorButton);
        this.add(fontBox);
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

        if(e.getSource() == fontBox) {
            textArea.setFont(new Font(fontBox.getSelectedItem().toString(), Font.PLAIN, textArea.getFont().getSize()));
        }
    }
}
