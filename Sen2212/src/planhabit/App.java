package Sen2212.src.planhabit;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class App extends JFrame implements MouseListener{ 
	public static void main(String[] args) {
		new App().setVisible(true);
	}
	
	
	JLabel lblHabit = new JLabel("Habits");
	JLabel lblCurrent = new JLabel("Current");
	JLabel lblLongest = new JLabel("Longest");
	JLabel lblAddHabit = new JLabel("Add Habit: ");
	
	JTextField txtHabit = new JTextField(15);
    JTextField txtTime = new JTextField(2);
    JTextField txttop_Time = new JTextField(2);
	
	JButton btnAdd = new JButton("Add");
		
	
	DefaultListModel<String> liste = new DefaultListModel<>();
	JList<String> listHabits = new JList<>(liste);
	JScrollPane sp = new JScrollPane(listHabits);
	
	
	Habit today = new Habit();
	//PlannerMaxHeap pdl = new PlannerMaxHeap(today);
	
    public App()
	{
		super("Planner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,500);
		setLocation(800,200);
		setLayout(new BorderLayout());
		
		
		liste.addElement("sleep");
		listHabits.setBounds(105,200,80,50);
		//add(listHabits); 
		
		//PlannerMaxHeap list = new PlannerMaxHeap();
		//lblHabit = new JLabel("Habit");
		//lblTime= new JLabel("Current Streak");
		//lbltop_Time = new JLabel("Longest Streak");
		
		//headers
		JPanel pnlUp = new JPanel();
		pnlUp.setLayout(new FlowLayout());
		pnlUp.add(lblHabit);
		
		
		JPanel pnlRight = new JPanel();
		pnlRight.setLayout(new FlowLayout());
		pnlRight.add(lblCurrent); pnlRight.add(lblLongest); 
		
		
		JPanel pnlHabit = new JPanel(new FlowLayout());
		pnlHabit.add(lblAddHabit);
		pnlHabit.add(txtHabit);
		pnlHabit.add(btnAdd);
		
		add(pnlUp, BorderLayout.NORTH);
		add(pnlRight, BorderLayout.EAST);
		add(pnlHabit,BorderLayout.SOUTH);
		
		
		//today = pdl.getLastIndex();
		//today.addItem("work", "15", "15");
		//dlm.addElement(today);
	
//		dn.addItem("work");
//		dlm.addElement(dn);
//		System.out.println(dn.toString());
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btnAdd) {
			
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
