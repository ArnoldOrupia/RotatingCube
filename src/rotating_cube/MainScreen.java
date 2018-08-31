package rotating_cube;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jecihjoy
 */
public class MainScreen extends JFrame {
    
    private static JSplitPane jSplitPane;
    private static int count = 50;
    
    public MainScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Rotating Cube");
        setResizable(false);
        pack();
        setLayout(null);
        setSize(750, 600);
        
        jSplitPane = new JSplitPane();
        jSplitPane.setOrientation(jSplitPane.VERTICAL_SPLIT);
        jSplitPane.setBounds(0, 0, 750, 600);
        jSplitPane.setDividerLocation(500);
        jSplitPane.setDividerSize(1);
        
        jSplitPane.setRightComponent(new CustomButtonPanel());
        jSplitPane.setLeftComponent(new RotateCube(800));
        
        add(jSplitPane);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MainScreen();
    }
    
    public static void updatePanel(JPanel panel) {
        count += 62.84;
        if (count >= 25 && count < 800){
                    jSplitPane.removeAll();
        jSplitPane.setDividerLocation(500);
        jSplitPane.setDividerSize(1);
        jSplitPane.setRightComponent(new CustomButtonPanel());
        jSplitPane.setLeftComponent(new RotateCube(800-count));
        jSplitPane.setVisible(true);
        }
          System.out.println("CUBE tf ::: "+ 3.142/count );
    }
    
}
