import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

public class PlannerApp extends JFrame implements MouseListener{
	JLabel lblDate;
	JLabel lblTask = new JLabel("New Task:");
	JLabel lblTime = new JLabel("Time: ");
	JLabel lblmock = new JLabel("MOCK");
	JLabel lblDay = new JLabel();
	
	JTextField txtTask = new JTextField(15);
	JTextField txtYear = new JTextField(4);
    
    JComboBox<String> cbHour = new JComboBox<String>(Timing.hours());
    JComboBox<String> cbMinute = new JComboBox<String>(Timing.minutes());
    JComboBox<Integer> cbMonths = new JComboBox<Integer>(Timing.months());
    JComboBox<Integer> cbDays = new JComboBox<Integer>();
    
	
	JButton btnPrev;
	JButton btnNext;
	JButton btnAdd = new JButton("Add");
	JButton btnDelete = new JButton("Delete");
	//JButton btnHabit = new JButton("Habit Tracker");
	
	DayNode today = new DayNode();
	DayNode prev;
	DayNode next;
	PlannerDoublyLinked pdl = new PlannerDoublyLinked(today);
	
	DefaultListModel<Task> dlm = new DefaultListModel<>();
	JList<Task> listTasks = new JList<Task>(dlm);
	JScrollPane sp = new JScrollPane(listTasks);
	
	
	public PlannerApp()
	{
		super("Planner");
		lblDate = new JLabel(today.printDate());
		lblDay.setText(today.getDate().getDayOfWeek().toString());
		btnPrev = new JButton("<");
		btnNext = new JButton(">");
		
		//btnHabit.setPreferredSize(new Dimension(40, 40));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,500);
		setLocation(800,200);
		setLayout(new BorderLayout());
		
		JPanel pnlControl = new JPanel();
		pnlControl.setLayout(new FlowLayout());
		pnlControl.add(txtYear); pnlControl.add(cbMonths); pnlControl.add(cbDays);
		
		
		JPanel pnlDate = new JPanel();
		pnlDate.setLayout(new GridLayout(2,1));
		pnlDate.add(lblDay);
		pnlDate.add(lblDate);
		
		JPanel pnlPage = new JPanel(new FlowLayout());
		pnlPage.add(btnPrev); pnlPage.add(pnlDate); pnlPage.add(btnNext);
		
		
		JPanel pnlTask = new JPanel();
		pnlTask.setLayout(new FlowLayout());
		pnlTask.add(lblTask); 
		pnlTask.add(txtTask);
		pnlTask.add(lblTime);
		pnlTask.add(cbHour);
		pnlTask.add(cbMinute);
		pnlTask.add(btnAdd);
		pnlTask.add(btnDelete);
		
		add(pnlPage, BorderLayout.NORTH);
		add(pnlControl, BorderLayout.WEST);
		add(sp, BorderLayout.CENTER);
		add(pnlTask, BorderLayout.SOUTH);
		
		//today.addItem("work", "15", "15");
		//dlm.addElement(today);
		
		btnAdd.addMouseListener(this);
		btnPrev.addMouseListener(this);
		btnNext.addMouseListener(this);
		btnDelete.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		new PlannerApp().setVisible(true);
	
	}
	
	public void changeDay() {
		dlm.clear();
		for(Task val : today.tasks)
			dlm.addElement(val);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//add new task to the current day
		if(e.getSource() == btnAdd) {
			if(!txtTask.getText().isBlank()) {
				Task row = new Task(txtTask.getText(), cbHour.getSelectedItem().toString(), 
						cbMinute.getSelectedItem().toString());
				today.addTask(row);
				dlm.addElement(row);
			}
		}
		
		//remove selected task from the list
		if(e.getSource() == btnDelete) {
			if(listTasks.getSelectedIndex() != -1) {
				today.tasks.remove(listTasks.getSelectedIndex());
				dlm.remove(listTasks.getSelectedIndex());
			}
		}
		
		//open the record of previous day
		else if(e.getSource() == btnPrev) {
			if(today.getPrev() == null) {
				prev = pdl.addDayPrev(today);
			}
			else {
				prev = today.getPrev();
			}
			next = today;
			today = prev;
			if(!(prev.getPrev() == null)) {
				prev = prev.getPrev();
			}
			
			lblDate.setText(today.printDate());
			lblDay.setText(today.getDate().getDayOfWeek().toString());
			changeDay();
		}
		
		//open record of the next day
		else if(e.getSource() == btnNext) {
			if(today.getNext() == null) {
				next = pdl.addDayNext(today);
			}
			else {
				next = today.getNext();
			}
			prev = today;
			today = next;
			if(!(next.getNext() == null)) {
				next = next.getNext();
			}
			
			lblDate.setText(today.printDate());
			lblDay.setText(today.getDate().getDayOfWeek().toString());
			changeDay();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == cbDays) {
			if(!txtYear.getText().isBlank()) {
				cbDays.addItem(null);
			}
		}
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
