package love.distributedrebirth.unicode4d;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class TestSwingPlane extends JPanel {
	
	private static final long serialVersionUID = 4146160826151405548L;
	
	public TestSwingPlane() {
		super(new GridLayout(1, 0));

		String[] columnNames = { "Plane", "Example"};

		Object[][] data = new Object[UnicodePlaneᶻᴰ.values().length][2];
		
		int x=0;
		for (UnicodePlaneᶻᴰ plane:UnicodePlaneᶻᴰ.values()) {
			if (plane.name().contains("SUPPLE")) {
				continue;
			}
			if (plane.name().contains("EXTEN")) {
				continue;
			}
			data[x][0] = plane.name();
			StringBuilder buf = new StringBuilder();
			int offset = 33;
			for (int i=plane.getStart()+offset;i<plane.getStart()+33+offset;i++) {
				buf.append((char)i);
				buf.append(" ");
			}
			data[x][1] = buf.toString();
			x++;
		}
		final JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}
	
	static public void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("SimpleTableDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TestSwingPlane newContentPane = new TestSwingPlane();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}
}
