package ekstra;

import panelller.KatEkranı;
import javax.swing.*;

public class Hareket {

    private static int durak = 0;
    private int durakSayisi;

    public static int getDurak() {
        return durak;
    }

    public static void setDurak(int durak) {
        Hareket.durak = durak;
    }

    public int getDurakSayisi() {
        return durakSayisi;
    }

    public void setDurakSayisi(int durakSayisi) {
        this.durakSayisi = durakSayisi;
    }

    public void YukarıYon(int x1) throws InterruptedException {
        int ilkDurak = Hareket.getDurak();
        KatEkranı.getArrow().setIcon(new ImageIcon("./img/arrow-up.png"));
        for (int i = ilkDurak; i <= x1; i++) {
            Hareket.setDurak(i);
            KatEkranı.getLabel().setText("" + Hareket.getDurak());
            Thread.sleep(2000);
        }

        KatEkranı.getArrow().setIcon(new ImageIcon("./img/tire.png"));
        new Olaylar().Cal("./sound/elevatording.wav");
    }

    public void AsagıYon(int x) throws InterruptedException {
        int ilkDurak = Hareket.getDurak();
        KatEkranı.getArrow().setIcon(new ImageIcon("./img/arrow-down.png"));
        for (int i = ilkDurak; i >= x; i--) {
            Hareket.setDurak(i);
            KatEkranı.getLabel().setText("" + Hareket.getDurak());
            Thread.sleep(2000);
        }

        KatEkranı.getArrow().setIcon(new ImageIcon("./img/tire.png"));

        new Olaylar().Cal("./sound/elevatording.wav");
    }
}
