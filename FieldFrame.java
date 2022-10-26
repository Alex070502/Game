import javax.swing.*;
import java.awt.*;

public class FieldFrame extends JFrame {
    public FieldFrame() {
        super("Game5x5");
        getContentPane().add(new Board());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 900);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new FieldFrame();
    }
}
