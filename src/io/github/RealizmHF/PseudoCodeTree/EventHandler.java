package io.github.RealizmHF.PseudoCodeTree;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		System.out.println(main.getFileNames(e.getLastIndex()));
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
