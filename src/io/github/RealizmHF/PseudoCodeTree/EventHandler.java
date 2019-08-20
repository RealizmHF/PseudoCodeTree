package io.github.RealizmHF.PseudoCodeTree;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

public class EventHandler implements ActionListener, ListSelectionListener {

	private static Driver main;
	
	boolean ranAlready = false;
	
	public EventHandler(Driver main) {
		this.main = main;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(e.getActionCommand());
		
		switch(e.getActionCommand()) {
		
		case "New File": try {
				newFilePressed(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		
		ranAlready = !ranAlready;
		
		if(ranAlready) {
			//String file = main.getFileNames(e.getSource().toString());
			System.out.println(e.toString().substring(474, 475));
			int temp = Integer.parseInt(e.toString().substring(474, 475));
			
			String file = main.getFileNames(temp);
			
			DefaultMutableTreeNode root = new DefaultMutableTreeNode(file.substring(0, file.length()-5));

			file = file.substring(0, file.length()-1);
			
			Scanner filescan = null;
			
			try {
				filescan = new Scanner(new FileReader(file));
			} catch (FileNotFoundException e1) {
				System.out.println("Failed to find " + file);
			}
			
			ArrayList<String> lines = new ArrayList<String>();
			
			while(filescan.hasNext()) {
				lines.add(filescan.nextLine());
			}
			
			main.setRoot(createNodes(root, lines));
			main.revalidate();
		}
	}
	
	private DefaultMutableTreeNode createNodes(DefaultMutableTreeNode root, ArrayList<String> lines) {
		/*
		 * Takes in the root of the tree and a list of every line from the file
		 * Outputs the completed tree
		 * 
		 * Must remember previous nodes in order to traverse and add nodes to correct parents
		 * Must remove counter system from each line, ensuring that each line is entered under the correct node
		 */
		
		DefaultMutableTreeNode previous = root;
		int previousStar = -1;

		for(int k = 0; k < lines.size(); k++) {
			
			int stars = lines.get(k).lastIndexOf("*");
			
			if(previousStar < stars) {
				
				previousStar = stars;
				
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(lines.get(k).substring(stars + 1, lines.get(k).length()));
				newNode.setParent(previous);
				previous = newNode;
				
			}
			else if(previousStar == stars) {
				
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(lines.get(k).substring(stars + 1, lines.get(k).length()));
				newNode.setParent((MutableTreeNode) previous.getParent());
				previous = newNode;
			}
			else {
				previousStar -= stars;
				
				for(int c = 0; c < previousStar; c++) {
					previous = (DefaultMutableTreeNode) previous.getParent();
				}
				k--;
			}
		}
		
		return root;
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
	
	public static void newFilePressed(ActionEvent e) throws IOException {
		/*
		 * newFile Button is pressed
		 * Creates popup to display
		 * popup will want the name of the file
		 * Has a Cancel button
		 * Has a Create button
		 */
		
		String popup = (String)JOptionPane.showInputDialog(main, "File Name: ", "Create File", JOptionPane.PLAIN_MESSAGE);
		
		if(popup != null) {
			File file = new File(popup + ".txt");
	    	
	    	file.createNewFile();
		}
		
	}
	
	public static JButton createJButton(String text) {
		
		JButton newButton = new JButton(text);
		
		newButton.addActionListener(new EventHandler(main));
		
		return new JButton(text);
	}

}
