package ekstra;

import panelller.Telefon;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class Olaylar {

    public void Cal(String muzikYeri) {
        try {
            InputStream muzikal = new FileInputStream(muzikYeri);
            AudioStream m = new AudioStream(muzikal);
            AudioPlayer.player.start(m);

        } catch (Exception e) {
            System.out.println("Oluşan Hata: " + e.getMessage());
        }
    }

    public void telCalistir() {
        Timer zamanlayıcı = new Timer();
        TimerTask gorev = new TimerTask() {
            @Override
            public void run() {
                Telefon.getTelefonLabeli().setIcon(new ImageIcon("./img/telephone.png"));//gorev
            }
        };

        TimerTask gorev2 = new TimerTask() {
            @Override
            public void run() {
                Telefon.getTelefonLabeli().setIcon(new ImageIcon("./img/telephone.gif"));//gorev2
            }
        };

        zamanlayıcı.schedule(gorev2, 0);//Png yerine gif ataduk.
        zamanlayıcı.schedule(gorev, 4000);//Gif yerine png atadık.     
        /*Kısaca hareket eden telefon görüntüsünü durdurduk*/
    }
}
