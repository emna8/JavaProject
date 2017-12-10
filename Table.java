package projet;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTable;

public class Table  extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable tab;
	
	public Table(Object[][] plateau){
				
		Object [] c={"","","",""};
		setLayout(new FlowLayout());
			
		tab=new JTable(plateau,c);
		tab.setEnabled(false);
		tab.setPreferredScrollableViewportSize(new Dimension(400,20));
	
		tab.setFillsViewportHeight(true);
		
		//JScrollPane s=new JScrollPane(tab);
		add(tab);		
	}
}
