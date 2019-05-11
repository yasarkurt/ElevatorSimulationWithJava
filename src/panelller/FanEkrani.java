package panelller;

import javax.swing.*;

public class FanEkrani extends JPanel {

    static JLabel fanLabeli = new JLabel();
    static boolean calisiyor;

    public FanEkrani() {
        setBounds(0, 600, 150, 150);
        fanLabeli.setIcon(new ImageIcon("./img/fan-calismiyor.png"));
        add(fanLabeli);
    }
}
