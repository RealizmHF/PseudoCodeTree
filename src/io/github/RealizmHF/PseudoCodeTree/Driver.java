package io.github.RealizmHF.PseudoCodeTree;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
 
public class Driver extends JPanel {
	
	private JTabbedPane tabs;
	
	private JPanel tabFile;
	private JPanel tab2;

    public Driver() {
        super(new GridLayout(1, 1));
         
        tabs = new JTabbedPane();
        
        JComponent panel1 = makeTabFile("Panel #1");
        panel1.setPreferredSize(new Dimension(500, 200));
        tabs.addTab("File", panel1);
        tabs.setMnemonicAt(0, KeyEvent.VK_1);
         
        
        
        JComponent panel2 = makeTab2("Panel #2");
        tabs.addTab("Tab 2", panel2);
        tabs.setMnemonicAt(1, KeyEvent.VK_2);
         
        
        add(tabs);
         
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    protected JComponent makeTabFile(String text) {
        tabFile = new JPanel(false);
        JList list = new JList();
        tabFile.setLayout(new GridLayout(1, 1));
        tabFile.add(list);
        return tabFile;
    }
    
    protected JComponent makeTab2(String text) {
        tab2 = new JPanel(false);
        JTextArea filler = new JTextArea(text);
        tab2.setLayout(new GridLayout(1, 1));
        tab2.add(filler);
        return tab2;
    }
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Psuedo Code Tree by James West");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Add content to the window.
        frame.add(new Driver(), BorderLayout.CENTER);
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI();
            }
        });
    }
}