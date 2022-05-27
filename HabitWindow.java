

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HabitWindow extends JFrame implements MouseListener{ 
	public static void main(String[] args) {
		new HabitWindow().setVisible(true);
	}
	
	
	JLabel lblHabit = new JLabel("Habit");
	JLabel lblCurrent = new JLabel("Current  ");
	JLabel lblLongest = new JLabel("Longest  ");
	JLabel lblTotal = new JLabel("Total  ");
	JLabel lblAddHabit = new JLabel("Add Habit: ");
	
	JTextField txtHabit = new JTextField(15);
    JTextField txtTime = new JTextField(2);
    JTextField txttop_Time = new JTextField(2);
	
	JButton btnAdd = new JButton("Add");
		
	
	DefaultListModel<Habit> dlm = new DefaultListModel<>();
	//ArrayList<Habit> list = new ArrayList<Habit>();
	JList<Habit> listHabits = new JList<>(dlm);
	JScrollPane sp = new JScrollPane(listHabits);
	
	
	//Habit today = new Habit();
	//PlannerMaxHeap pdl = new PlannerMaxHeap(today);
	
    public HabitWindow()
	{
		super("Planner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,600);
		setLocation(800,200);
		setLayout(new BorderLayout());
		
		
		
		//add(listHabits); 
		
		//PlannerMaxHeap list = new PlannerMaxHeap();
		//lblHabit = new JLabel("Habit");
		//lblTime= new JLabel("Current Streak");
		//lbltop_Time = new JLabel("Longest Streak");
		
		//headers
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.X_AXIS));
		pnlHeader.add(Box.createHorizontalStrut(180));
		pnlHeader.add(lblHabit);
		pnlHeader.add(Box.createHorizontalGlue());
		pnlHeader.add(lblCurrent); 
		pnlHeader.add(lblLongest);
		pnlHeader.add(lblTotal);
		
		pnlHeader.setPreferredSize(new Dimension(this.getWidth(), 30));
		
		
		JPanel pnlHabit = new JPanel(new FlowLayout());
		pnlHabit.add(lblAddHabit);
		pnlHabit.add(txtHabit);
		pnlHabit.add(btnAdd);
		
		add(pnlHeader, BorderLayout.NORTH);
		add(pnlHabit,BorderLayout.SOUTH);
		add(sp, BorderLayout.CENTER);
		
		btnAdd.addMouseListener(this);

	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btnAdd) {
			Habit newHabit = new Habit(txtHabit.getText());
			dlm.addElement(newHabit);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
