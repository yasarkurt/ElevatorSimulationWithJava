package panelller;

import javax.swing.*;

public class Telefon extends JPanel {

    static JLabel telefonLabeli = new JLabel();

    public static JLabel getTelefonLabeli() {
        return telefonLabeli;
    }

    public static void setTelefonLabeli(JLabel telefonLabeli) {
        Telefon.telefonLabeli = telefonLabeli;
    }

    public Telefon() {

        setBounds(900, 600, 300, 300);
        telefonLabeli.setIcon(new ImageIcon("./img/telephone.png"));
        add(telefonLabeli);
    }
}
