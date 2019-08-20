package io.github.RealizmHF.PseudoCodeTree;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class EventHandler implements ActionListener, ListSelectionListener {

	private static Driver main;
	
	public EventHandler(Driver main) {
		this.main = main;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(e.getActionCommand());
		
		switch(e.getActionCommand()) {
		
		case "New File": newFilePressed(e);
		case "Delete": deletePressed(e);
		case "Refresh": refreshPressed(e);
		case "Add Node": addNodePressed(e);
		case "Delete Node": deleteNodePressed(e);
		case "Create": createPressed(e);
		case "Cancel": cancelPressed(e);
		case "Add": addPressed(e);
		
		}
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		/*
		 * Start reading from the file with the name of selected file
		 */
		
		//String file = main.getFileNames(e.getSource().toString());
		
		int temp = Integer.parseInt(e.toString().substring(474, 475));
		
		String file = main.getFileNames(temp);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(file.substring(file.length()-3, file.length()));

		file = file.substring(0, file.length()-1);
		Scanner filescan = null;
		
		try {
			filescan = new Scanner(new FileReader(file));
		} catch (FileNotFoundException e1) {
			System.out.println("Failed to find " + file);
		}
		
		DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode();
		
		
	}
	
	private DefaultMutableTreeNode createNode(String name, String text) {
		
		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(text);
		
		newNode.setUserObject(text);
		
		return newNode;
	}
	

	private Object[] resizeTree(Object[] tree) {
		
		Object[] temp = new Object[tree.length * 2];
		
		for(int k = 0; k < tree.length; k++) {
			temp[k] = tree[k];
		}
		return temp;
	}

	private void addNodePressed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void deleteNodePressed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void createPressed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void cancelPressed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void addPressed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void refreshPressed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void deletePressed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void newFilePressed(ActionEvent e) {
		/*
		 * newFile Button is pressed
		 * Creates popup to display
		 * popup will want the name of the file
		 * A-Z && a-z && 0-9 && !-) allowed for characters
		 * Has a Cancel button
		 * Has a Create button
		 */
		
		Object[] choices = {"Create", "Cancel"};
		
		//String popup = (String)JOptionPane.showInputDialog(null, "File Name: ", "Create File", JOptionPane.PLAIN_MESSAGE, popup, "ham");
		
	}
	
	public static JButton createJButton(String text) {
		
		JButton newButton = new JButton(text);
		
		newButton.addActionListener(new EventHandler(main));
		
		return new JButton(text);
	}

}
