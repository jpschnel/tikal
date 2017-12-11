package code;
import javax.swing.*;    


public class Gif extends JFrame {
	private JPanel _jp;  
	public Gif(){  
	    setSize(350, 300);  
	    setLocation(400,300);  
	    setDefaultCloseOperation(EXIT_ON_CLOSE); 
	    JPanel p = new JPanel();  
	    p.add(new JLabel(new ImageIcon("ah-ah-ah-o.gif")));  
	    getContentPane().add(p);  
	    _jp = p;
	  }  
	public JPanel getJPanel(){
		return _jp;
	}
	  public static void main(String[] args) {	GUI gui = new GUI();
		javax.swing.SwingUtilities.invokeLater(gui);}  
}  
