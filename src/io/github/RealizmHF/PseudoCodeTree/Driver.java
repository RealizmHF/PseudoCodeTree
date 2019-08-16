package io.github.RealizmHF.PseudoCodeTree;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Driver extends JPanel implements ListSelectionListener{
	
	private JPanel main;
	
	private JTabbedPane tabs;
	
	private JPanel tabFile;
	private JPanel tabTree;
	
	private JButton newFile;
	
	private JButton delFile;
	
	private JButton refreshFile;

    public Driver() throws IOException {
        super(new GridBagLayout());
        
        main = new JPanel(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();

        tabs = new JTabbedPane();
        
        newFile = new JButton("New File");
        c.gridx = 0;
        c.gridy = 0;
        main.add(newFile, c);
        
        delFile = new JButton("Delete");
        c.gridx = 0;
        c.gridy = 1;
        main.add(delFile, c);
        
        refreshFile = new JButton("Refresh");
        c.gridx = 0;
        c.gridy = 2;
        main.add(refreshFile, c);
        
        JComponent panel1 = makeTabFile();
        panel1.setPreferredSize(new Dimension(500, 200));
        tabs.addTab("File", panel1);
        tabs.setMnemonicAt(0, KeyEvent.VK_1);
        
        
        JComponent panel2 = makeTab2("Panel #2");
        tabs.addTab("Tree", panel2);
        tabs.setMnemonicAt(1, KeyEvent.VK_2);

        add(main);
        add(tabs);
        
         
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    protected JComponent makeTabFile() throws IOException {
        tabFile = new JPanel(false);
        JList<String> list = new JList<String>(createFiles());
        tabFile.setLayout(new GridLayout(1, 1));
        tabFile.add(list);
        return tabFile;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) 
    { 
        //set the text of the label to the selected value of lists
          
    }
    
    protected JComponent makeTab2(String text) {
        tabTree = new JPanel(false);
        JTextArea filler = new JTextArea(text);
        tabTree.setLayout(new GridLayout(1, 1));
        tabTree.add(filler);
        return tabTree;
    }
    
    private String[] createFiles() throws IOException {
    	//Reads all files created to display a list
    	
    	File file = new File("files.txt");
    	ArrayList<String> names = new ArrayList<String>();
    	
    	file.createNewFile();
    	
    	refreshFiles();
    	
    	Scanner scan = new Scanner(file);
    	
    	while(scan.hasNext()) {
    		names.add(scan.next());
    	}
    	
    	scan.close();
    	
    	return names.toArray(new String[names.size()]);
    }
    
    public static void refreshFiles() throws IOException {
    	File file = new File("files.txt");
    	File fl = new File(file.getAbsolutePath().substring(0,file.getAbsolutePath().lastIndexOf(File.separator)));
        File[] matchingFiles = fl.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
            	//Accepts all .txt files except the files.txt file
                return !name.startsWith("files") && name.endsWith("txt");
            }
        });
        
        FileWriter writer = new FileWriter(file);
        for(int k = 0; k < matchingFiles.length; k++) {
        	writer.write(matchingFiles[k].getName() + "\n");
        }
        writer.close();
    }
    
    private static void createAndShowGUI() throws IOException {
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
        try {
			createAndShowGUI();
		} catch (IOException e) {
			System.out.println("createAndShowGUI Function Failed");
		}
            }
        });
    }
}