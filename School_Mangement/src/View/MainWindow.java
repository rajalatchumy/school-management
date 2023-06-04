package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Student;
import Model.Students;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

@SuppressWarnings("serial")
public class MainWindow extends JFrame implements ActionListener
 {
	private Container contentPane;
	private String[] headers = {"Id","Name","First name","Program","Episode"};
	private DefaultTableModel tableModel;
	private JTable table;
	private Students students;
	private StudentForm form;
	
    public MainWindow(Students students)
    {
    	
    	super("School_Mangement"); // call the constructor of the parent class (JFrame)
    	this.students = students;
        this.contentPane = this.getContentPane();
        this.contentPane.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLocation(100, 200);
        
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.CYAN);
        leftPanel.setLayout(new GridLayout(0,1,0,10));
        
        JButton addButton =new JButton("ADD");
        addButton.addActionListener(this);
        addButton.setActionCommand("ADD");
        leftPanel.add(addButton);
        
        JButton removeButton =new JButton("REMOVE");
        removeButton.addActionListener(this);
        removeButton.setActionCommand("REMOVE");
        leftPanel.add(removeButton);
        
        JButton exitButton =new JButton("EXIT");
        exitButton.addActionListener(this);
        exitButton.setActionCommand("EXIT");
        leftPanel.add(exitButton);
        
        
        JPanel bottomPanel = new JPanel();
        
        
        //String[] headers = {"Id","Name","First name","Program","Episode"};
        this.tableModel = new DefaultTableModel(headers,0);
        this.refreshTable();
        this.table = new JTable(tableModel);
      
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        contentPane.add(leftPanel,BorderLayout.WEST);
        contentPane.add(scrollPane,BorderLayout.CENTER);
        contentPane.add(bottomPanel,BorderLayout.SOUTH);
        
        //this.fileChooser = new JFileChooser();
		this.form = new StudentForm(this, this.students);
		this.setVisible(true);
        
    }
    
    public void refreshTable()
    {
    	tableModel.setRowCount(0);
    	Iterator<Student> i = this.students.iterator();  
    	while(i.hasNext())
        {
            Student student = i.next();
            Object[] row = new Object[headers.length];
            row[0]=student.getId();
            row[1]=student.getName();
            row[2]=student.getFirstname();
            row[3]=student.getProgram();
            row[4]=student.getEpisode();
            tableModel.addRow(row);
            
            JMenuItem exitItem = new JMenuItem("EXIT");
            exitItem.addActionListener(this);
            exitItem.setActionCommand("QUIT");
            
            JMenu fileMenu = new JMenu("FILE");
            fileMenu.add(exitItem);
            
            JMenuBar menuBar = new JMenuBar();
            menuBar.add(fileMenu);
            this.setJMenuBar(menuBar);
            
            
            student.display();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
    	String action = e.getActionCommand();
		System.out.println("application action = " + action);
    	switch(action)
    	{
    	case "ADD":
    		this.form.setVisible(true);
    		refreshTable();
    		break;
    		
    	case "EXIT":
    		System.exit(0);
    		break;
    		
    
    	
    	}
    }
}