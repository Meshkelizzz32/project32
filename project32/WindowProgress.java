package project23;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Progress extends JFrame{
	JProgressBar pb=new JProgressBar(0,100);
	JLabel jl=new JLabel("Check progress");
	Timer t=new Timer(50,new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		if(pb.getValue()==pb.getMaximum()) {
			t.stop();
			jl.setText("It is Good");
			}
			double percent=
					(double)pb.getValue() / (double)pb.getMaximum();
					 t.setDelay((int)(t.getDelay() *
					 (1.0 + percent * 0.07)));
					 pb.setValue(pb.getValue() + 1);
					 if(percent > 0.90)
					 if(Math.random() < 0.25)
					 pb.setValue(pb.getValue() - 10); 
			}
		
	});
	public Progress() {
		setLayout(new FlowLayout());
		add(pb);
		add(jl);
		pb.setValue((int)(pb.getMaximum()*0.25));
		t.start();
	}
}

public class WindowProgress {
public static void main(String[] args) {
	run(new Progress(),300,200);
}
public static void run(final Progress progress1, final int width, final int height) {
	   SwingUtilities.invokeLater(new Runnable() {
	     public void run() {
	    	 progress1.setTitle(progress1.getClass().getSimpleName());
	    	 progress1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	 progress1.setSize(width, height);
	    	 progress1.setVisible(true);
	     }
	   });
	 }
	} 
