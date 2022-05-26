import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class Window  extends JFrame implements ActionListener{
	JLabel lblName; 
	JLabel lblTime;
	
    JTextField txtTask;
    JTextField txtHour;
    JTextField txtMinute;
    
    JButton btnAdd;
    DayNode page;
    ArrayList<Task> list;

    public Window()
    {
        super();
        //initialize the defined components
        lblName = new JLabel("Task:");
        lblTime = new JLabel("Time: ");
        
        txtTask = new JTextField(10);
        txtHour = new JTextField(2);
        txtMinute = new JTextField(2);
        
        btnAdd = new JButton("Add");
        list = new ArrayList<Task>();
        page = new DayNode(list);
        
        //frame properties
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200,100);
        setLocation(500,300);
        setLayout(new FlowLayout());
        setResizable(false);
//        setLayout(new BorderLayout());
//
//        JPanel pnlName = new JPanel();
//        pnlName.setLayout(new FlowLayout());
//        pnlName.add(lblName); pnlName.add(txt);

        add(lblName); add(txtTask);
        add(lblTime); add(txtHour); add(txtMinute);
        add(btnAdd);
        
        btnAdd.addActionListener(this);
    }
    
    public void clear()
    {
    	txtTask.setText("");
    	txtHour.setText("");
    	txtMinute.setText("");
    }
    
    public static void main(String[] args) {
        new Window().setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!txtTask.getText().equals(""))
		{
			Task t = new Task();
			t.setItem(txtTask.getText());
			t.setHour(txtHour.getText());
			t.setMinute(txtMinute.getText());
			list.add(t);
			clear();
			
			//page.displayDay();
			System.out.println("--------------\n");
		}
	}
		
}

