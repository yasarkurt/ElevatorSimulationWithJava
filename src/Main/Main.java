package Main;

import panelller.Telefon;
import panelller.FanEkrani;
import panelller.KatEkranı;
import panelller.TusPaneli;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Main extends JFrame {

    JPanel panel = new TusPaneli();
    JPanel katEkrani = new KatEkranı();
    JPanel fanEkranı = new FanEkrani();
    JPanel telefon = new Telefon();

    public Main() {
        setBounds(100, 100, 1200, 800);//Koordinat bilgileri ve boyut tanımlanıyor.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Kapatma işlemini kapatma tuşuna atadık.
        setLocationRelativeTo(null);//Framedeki elemanların konumlarınımı kendimizi ayarlamak için null atadık.
        setContentPane(new JLabel(new ImageIcon("./img/arkaplan.jpeg")));//Arkaplana resim ekledik.
        setResizable(false);//Yeniden boyutlandırma kapalı.
        setLayout(null);//Layoutları null atadık.
        setVisible(true);//Görünürlüğe true atadık.
        add(panel);//bu ve alt satırlarda frame eleman ekledik.
        add(katEkrani);
        add(fanEkranı);
        add(telefon); 
        Guncelle();//framede ki elemanlarda değişiklikler olduğu için bu fonksiyonda frameyi yeniliyoruz.
    }

    public void Guncelle() {
        Timer zamanlayıcı = new Timer();
        TimerTask gorev = new TimerTask() {
            @Override
            public void run() {
                Main.this.update(Main.super.getGraphics());
            }
        };

        zamanlayıcı.schedule(gorev, 0, 1000);
        /*
            Timer ile TimerTask sınıfından türüyen görevi program çalıştığı andan her 1 saniyede bir frami günceller.
         */
    }

    @Override
    public void update(Graphics g) {//Burada Frame sınıfının metodu olan update metodunu override ettik. Yukarıdaki Güncelle fonksiyonunda bu metodu kullandık.
        super.update(g);
    }

    public static void main(String[] args) {
        JFrame j = new Main();//Main sınıfından bir JFrame nesnesi türettik.
    }
}
