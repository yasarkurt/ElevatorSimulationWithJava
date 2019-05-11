package panelller;

import ekstra.Hareket;
import javax.swing.*;
import java.awt.*;

public class KatEkranı extends JPanel {

    static JLabel label = new JLabel();
    static JLabel arrow = new JLabel();

    public static JLabel getLabel() {
        return label;
    }

    public static void setLabel(JLabel label) {
        KatEkranı.label = label;
    }

    public static JLabel getArrow() {
        return arrow;
    }

    public static void setArrow(JLabel arrow) {
        KatEkranı.arrow = arrow;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }
    Color foregroundColor = new Color(216, 0, 39);//Ok resimlerinin renginin sayısal değerlerini buldum. Bununla bir renk oluşturdum.

    public KatEkranı() {
        setBounds(500, 0, 200, 150);
        label.setSize(75, 75);//Boyut atadık.
        arrow.setSize(50, 50);
        arrow.setIcon(new ImageIcon("./img/tire.png"));
        label.setText("" + Hareket.getDurak());
        label.setForeground(foregroundColor);//Ok ve sayı değerlerini aynı renk yaptım.
        label.setFont(new Font("Verdana", Font.BOLD, 75));
        add(label);
        add(arrow);
    }
}
