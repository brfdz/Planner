

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HabitWindow extends JFrame implements MouseListener{ 
	JLabel lblHabit = new JLabel("Habit");
	JLabel lblCurrent = new JLabel("Current     ");
	JLabel lblLongest = new JLabel("Longest    ");
	JLabel lblTotal = new JLabel("Total    ");
	JLabel lblAddHabit = new JLabel("Add Habit: ");
	JLabel lblDate = new JLabel();
	
	JTextField txtHabit = new JTextField(15);
    JTextField txtTime = new JTextField(2);
    JTextField txttop_Time = new JTextField(2);
	
	JButton btnAdd = new JButton("Add");
	JButton btnDone = new JButton("Done");
		
	String col[] = {"Habit","Current","Longest", "Total"};
	DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
		 @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
	};
	
	JTable table = new JTable(tableModel);
	DefaultTableCellRenderer cellRenderer;
	
	ArrayList<Habit> listHabit = new ArrayList<Habit>();
	
	JPanel pnlHabit;
	
	
    public HabitWindow()
	{
		super("Habit Tracker");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(500,600);
		//setLocation(800,200);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(500);
	    cellRenderer = new DefaultTableCellRenderer();
	    cellRenderer.setHorizontalAlignment(JLabel.CENTER);
	    table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
	    
		
		//headers
		JPanel pnlHeader = new JPanel();
		pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.X_AXIS));
		pnlHeader.add(Box.createHorizontalStrut(160));
		pnlHeader.add(lblHabit);
		pnlHeader.add(Box.createHorizontalGlue());
		pnlHeader.add(lblCurrent); 
		pnlHeader.add(lblLongest);
		pnlHeader.add(lblTotal);
		
		pnlHeader.setPreferredSize(new Dimension(this.getWidth(), 30));
		
		
		pnlHabit = new JPanel(new FlowLayout());
		pnlHabit.add(lblAddHabit);
		pnlHabit.add(txtHabit);
		pnlHabit.add(btnAdd);
		pnlHabit.add(btnDone);
		pnlHabit.add(lblDate);
		
		add(pnlHeader, BorderLayout.NORTH);
		add(pnlHabit,BorderLayout.SOUTH);
		add(table, BorderLayout.CENTER);
		
		btnAdd.addMouseListener(this);
		btnDone.addMouseListener(this);
		
		Habit hb = new Habit("cry");
		addHabit(hb);

	}
    
    
    public void addHabit(Habit h) {
    	listHabit.add(h);
    	String name, current,longest,total;
    	name = h.getName();
    	current = h.getCurrent().getSize() + "";
    	longest = h.getStreaks().getMax().getSize() + "";
    	total = h.getTotal() + "";
		Object[] objs = {name, current, longest,total};
		tableModel.addRow(objs);
		txtHabit.setText("");
    }
    
    public void update(int index) {
    	Habit h = listHabit.get(table.getSelectedRow());
    	String name = h.getName();
    	String current = h.getCurrent().getSize() + "";
    	String longest = h.getStreaks().getMax().getSize() + "";
    	String total = h.getTotal() + "";
    	tableModel.removeRow(index);
    	Object[] objs = {name, current, longest,total};
    	tableModel.insertRow(index, objs);
    }
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btnAdd) {
			Habit h = new Habit(txtHabit.getText());
			addHabit(h);
		}
		if(e.getSource() == btnDone) {
			if(table.getSelectedRow() > -1) {
		    	Habit h = listHabit.get(table.getSelectedRow());
		    	//TODO get date dynamically
		    	h.getCurrent().getDates().add(LocalDate.now().plusDays(1));
	    		h.updateIncreased(h.getCurrent());
				update(table.getSelectedRow());
			}
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