import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame{
    private JButton ScreenSnip;
    private JButton Screenshot;
    private JPanel Main;

    public Main() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("ScreenCapture");
        frame.setContentPane(Main);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);
        Screenshot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.setOpacity(0);
                frame.dispose();
                Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                try {
                    ScreenCapture sc = new ScreenCapture(rect,System.getProperty("user.home"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (AWTException ex) {
                    ex.printStackTrace();
                }
            }
        });
        ScreenSnip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                new Screensnipper();
            }
        });
    }
    public static void main(String[] args){
        Main main = new Main();
    }
}

