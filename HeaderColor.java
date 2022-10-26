import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HeaderColor extends JPanel {

    public HeaderColor(Color color) {
        setBackground(color);
        setBorder(BorderFactory.createMatteBorder(0, 0, 10, 0, Color.white));
        setVisible(true);
    }


}
