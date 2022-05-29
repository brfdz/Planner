import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;

import java.text.AttributedString;
import java.awt.font.TextAttribute;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class PlannerApp extends JFrame implements MouseListener{
	JLabel lblDate;
	JLabel lblTask = new JLabel("New Task:");
	JLabel lblTime = new JLabel("Time: ");
	JLabel lblDay = new JLabel();
	JLabel lblS = new JLabel("Select a date: ");
	
	JTextField txtTask = new JTextField(15);
	JTextField txtDay = new JTextField(2);
	JTextField txtMonth = new JTextField(2);
	JTextField txtYear = new JTextField(4);
	
	JTextArea txtHabit = new JTextArea();
    
    JComboBox<String> cbHour = new JComboBox<String>(Timing.hours());
    JComboBox<String> cbMinute = new JComboBox<String>(Timing.minutes());
//    JComboBox<Integer> cbMonths = new JComboBox<Integer>(Timing.months());
//    JComboBox<Integer> cb
    
	
	JButton btnPrev;
	JButton btnNext;
	JButton btnAdd = new JButton("Add");
	JButton btnDelete = new JButton("Delete");
	JButton btnOpen = new JButton("Open Page");
	JButton btnHabits = new JButton("Habits");
	JButton btnDone = new JButton("Done");
	JButton btnToday = new JButton("Today");
	
	DayNode today = new DayNode();
	DayNode prev;
	DayNode next;
	PlannerDoublyLinked pdl = new PlannerDoublyLinked();
	
	DefaultListModel<Task> dlm = new DefaultListModel<>();
	JList<Task> listTasks = new JList<Task>(dlm);
	JScrollPane sp = new JScrollPane(listTasks);
	
	HabitWindow hw;
	
//	JScrollPane spHabit;
//	JList<Object> list;
	
	public PlannerApp()
	{
		super("Planner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,500);
		setLocation(800,200);
		setLayout(new BorderLayout());
		
		
		hw = new HabitWindow();
		hw.lblDate.setText(today.printDate());
		hw.setVisible(false);
		
//		list = new JList<Object>(hw.listHabit.toArray());
//		spHabit = new JScrollPane(list);
		
		
		lblDate = new JLabel(today.printDate());
		lblDay.setText(today.getDate().getDayOfWeek().toString());
		btnPrev = new JButton("<");
		btnNext = new JButton(">");
		
		
		JPanel pnlControl = new JPanel();
		pnlControl.setLayout(new FlowLayout());
		pnlControl.add(txtDay); pnlControl.add(txtMonth); pnlControl.add(txtYear);
		
		JPanel pnlSide = new JPanel();
		pnlSide.setLayout(new BoxLayout(pnlSide, BoxLayout.Y_AXIS));
		pnlSide.add(btnToday);
		pnlSide.add(lblS);
		pnlSide.add(pnlControl); 
		pnlSide.add(btnOpen);
		pnlSide.add(btnHabits);
		pnlSide.add(Box.createVerticalStrut(300));
		
		
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
		pnlTask.add(btnDone);
		
//		JPanel pnlMain = new JPanel(new GridLayout(1,2));
//		pnlMain.add(sp); 
//		pnlMain.add(spHabit);
		
		add(pnlPage, BorderLayout.NORTH);
		add(pnlSide, BorderLayout.WEST);
		add(sp, BorderLayout.CENTER);
		add(pnlTask, BorderLayout.SOUTH);
		
		pdl.insert(today);
		
		btnAdd.addMouseListener(this);
		btnPrev.addMouseListener(this);
		btnNext.addMouseListener(this);
		btnDelete.addMouseListener(this);
		btnOpen.addMouseListener(this);
		btnHabits.addMouseListener(this);
		btnToday.addMouseListener(this);
		//btnDone.addActionListener(this);
		
		btnDone.addMouseListener(this);

		Habit hb = new Habit("read");
	}
	
	public static void main(String[] args) {
		new PlannerApp().setVisible(true);
		
		
	
	}
	
	public void changeDay(DayNode today) {
		//change the header
		lblDate.setText(today.printDate());
		lblDay.setText(today.getDate().getDayOfWeek().toString());
		
		//change date on the habit window
		hw.lblDate.setText(today.printDate());
		hw.today = today.getDate();
		for(int i = 0; i < hw.tableModel.getRowCount(); i++) {
			if(hw.listHabit.get(i).getStreaks().isExists(today.getDate()))
				hw.table.setValueAt((hw.listHabit.get(i).getName() + "  [DONE]"), i, 0);
			else
				hw.table.setValueAt(hw.listHabit.get(i).getName(), i, 0);
		}
		
		//change the table
		dlm.clear();
		for(Task val : today.tasks)
			dlm.addElement(val);
		
		if(today.getPrev() != null)
			prev = today.getPrev();
		if(today.getNext() != null)
			next = today.getNext();
	}


	
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == btnDone)
		{
			if(listTasks.isFocusOwner()) {
				Task t = dlm.elementAt(listTasks.getSelectedIndex());		    
			    	t.setItem(t.getItem() + "  [DONE]");
			}		
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btnAdd) {
			if(!txtTask.getText().isBlank()) {
				Task row = new Task(txtTask.getText(), cbHour.getSelectedItem().toString(), 
						cbMinute.getSelectedItem().toString());
				today.addTask(row);
				dlm.addElement(row);
				
				txtTask.setText("");
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
		if(e.getSource() == btnPrev) {
			if(today.getPrev() == null || !today.getPrev().getDate().isEqual(today.getDate().minusDays(1))) {
				prev = pdl.addDayPrev(today);
			}
			today = prev;
			changeDay(today);
		}
		
		//open record of the next day
		if(e.getSource() == btnNext) {
			if(today.getNext() == null || !today.getNext().getDate().isEqual(today.getDate().plusDays(1))) {
				next = pdl.addDayNext(today);
			}
			today = next;
			changeDay(today);
		}
		
		if(e.getSource() == btnOpen)
		{
			//TODO validate date
			if(!txtDay.getText().isBlank() && !txtMonth.getText().isBlank()
					&& !txtYear.getText().isBlank())
			{
				int year = Integer.parseInt(txtYear.getText());
				int month = Integer.parseInt(txtMonth.getText());
				int day = Integer.parseInt(txtDay.getText());
				
				LocalDate date = LocalDate.of(year, month, day);
				
				if(pdl.isExists(date)) {
					today = pdl.getDay(date);
					changeDay(today);
				}
				else
				{
					DayNode newDay = new DayNode(date);
					pdl.insert(newDay);
					today = newDay;
					changeDay(today);
				}
			}
		}
		
		if(e.getSource() == btnHabits)
		{
			hw.setVisible(true);
			hw.today = today.getDate();
		}
		
		if (e.getSource() == btnToday) {
			today = pdl.getDay(LocalDate.now());
			changeDay(today);
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
