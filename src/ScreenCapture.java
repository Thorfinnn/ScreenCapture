import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class ScreenCapture{
    Rectangle rect=new Rectangle();
    Robot robot = new Robot();
        public ScreenCapture(Rectangle rect,String outputFolder) throws IOException, AWTException {
            this.rect=rect;
        BufferedImage sc;
        sc = robot.createScreenCapture(rect);
            String fileName = String.format("%s\\%s.jpg", outputFolder, System.currentTimeMillis());
            File f = null;
            try {
                f = new File(fileName);
                ImageIO.write(sc, "jpg", f);
                Clipboard c =Toolkit.getDefaultToolkit().getSystemClipboard();
                TransferableImage image = new TransferableImage(sc);
                c.setContents(image,null);
                Desktop.getDesktop().open(f);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    }

class TransferableImage implements Transferable {

    Image i;

    public TransferableImage(Image i) {
        this.i = i;
    }

    public Object getTransferData(DataFlavor fl) throws IOException {
        if (fl.equals(DataFlavor.imageFlavor) && i != null) {
            return i;
        } else{
            return null;
        }

    }

    public DataFlavor[] getTransferDataFlavors() {
        DataFlavor[] fl = new DataFlavor[ 1 ];
        fl[ 0 ] = DataFlavor.imageFlavor;
        return fl;
    }

    public boolean isDataFlavorSupported( DataFlavor flavor ) {
        DataFlavor[] fl = getTransferDataFlavors();
        for ( int i = 0; i < fl.length; i++ ) {
            if ( flavor.equals( fl[ i ] ) ) {
                return true;
            }
        }
        return false;
    }
}



class GUIapplication {

    public static void main(String[] args) {
        Frame f=new Frame("Graphical User Interface");
        final TextField tf=new TextField();
        f.getTitle();
        f.setBackground(Color.blue);
        tf.setBounds(50,150, 300,50);
        Button b=new Button("Click Here");
        b.setBounds(150,210,90,30);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText("Java is a good Language");
            }
        });
        f.add(b);f.add(tf);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
}