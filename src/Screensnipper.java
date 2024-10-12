import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Screensnipper extends JFrame{
    private JButton Capture;
    private JPanel screen;
    Screensnipper() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Screensnipper");
        frame.setContentPane(screen);
        Dimension size = new Dimension(50,50);
        frame.setMinimumSize(size);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setOpacity(0.5f);
        frame.setBounds(50,50,150,150);
        frame.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.pack();
        frame.setVisible(true);
        Capture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle screensize=screen.getBounds();
                int x = (int)screen.getLocation().getX();
                int y = (int)screen.getLocation().getY();
                Rectangle rect = new Rectangle(x,y,0,0);
                rect.add(screensize);
                frame.setOpacity(0);
                try {
                    ScreenCapture sc = new ScreenCapture(rect,System.getProperty("user.home"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (AWTException ex) {ex.printStackTrace();
                }
            }
        });
    }
  /*public static void main(String[] args){
        JFrame frame = new JFrame("Screensnipper");
        frame.setContentPane(new Screensnipper().screen);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
  }*/
}
