package View;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Episode;
import Model.Program;
import Model.Student;
import Model.Students;

public class StudentForm extends JDialog implements ActionListener
{
	private Container contentPane;
	private JTextField idField;
	private JTextField nameField;
	private JTextField firstnameField;
	private JTextField programField;
	private JTextField episodeField;
	private Students students;
	
	public StudentForm(JFrame parent,Students students)
	{
		super(parent,"New Student",true);
		this.students = students;
		this.setSize(500,600);
		this.setLocation(600, 200);
		this.contentPane = this.getContentPane();
		this.contentPane.setLayout(new GridLayout(0,2));
		JLabel idLabel = new JLabel("ID");
		this.contentPane.add(idLabel);
		this.idField = new JTextField();
		this.contentPane.add(idField);
		JLabel nameLabel = new JLabel("NAME");
		this.contentPane.add(nameLabel);
		this.nameField = new JTextField();
		this.contentPane.add(nameField);
		JLabel firstnameLabel = new JLabel("FIRST NAME");
		this.contentPane.add(firstnameLabel);
		this.firstnameField = new JTextField();
		this.contentPane.add(firstnameField);
		JLabel programLabel = new JLabel("PROGRAM");
		this.contentPane.add(programLabel);
		this.programField = new JTextField();
		this.contentPane.add(programField);
		JLabel episodeLabel = new JLabel("EPISODE");
		this.contentPane.add(episodeLabel);
		this.episodeField = new JTextField();
		this.contentPane.add(episodeField);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(this);
		okButton.setActionCommand("OK");
		this.contentPane.add(okButton);
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(this);
		cancelButton.setActionCommand("CANCEL");
		this.contentPane.add(cancelButton);
		
	}
	@Override
	 public void actionPerformed(ActionEvent e)
    {
    	String action = e.getActionCommand();
		System.out.println("application action = " + action);
    	switch(action)
    	{
    	case "OK":
    		String idString = this.idField.getText();
    		int id = 0;
    		try {
				id = Integer.parseInt(idString);
				System.out.println("id = "+id);
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				System.err.println(idString + "cannot be converted to integer");
				//e1.printStackTrace();
			}
    		String name = this.nameField.getText();
    		String firstname = this.firstnameField.getText();
    		String programString = this.programField.getText();
    		Program program = Program.valueOf(programString);
    		String episodeString = this.episodeField.getText();
    		Episode episode = Episode.valueOf(episodeString);
    		Student student = new Student(id,name,firstname,program, episode);
    		this.students.add(student);
    		this.setVisible(false);
    		break;
    		
    	case "CANCEL":
    		this.setVisible(false);
    		break;
    		
    
    	
    	}
    }
	
}
