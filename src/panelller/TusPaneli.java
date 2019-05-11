package panelller;

import ekstra.Olaylar;
import ekstra.Hareket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TusPaneli extends JPanel {

    Hareket hareket;
    JButton buton;
    JButton fan = new JButton(new ImageIcon("./img/fan.png"));
    JButton alarm = new JButton(new ImageIcon("./img/alarm.png"));
    JButton phone = new JButton(new ImageIcon("./img/phone-call.png"));

    public TusPaneli() {
        setBounds(20, 20, 140, 140);
        setLayout(null);//boyutları kendimiz ayarlıyoruz
        setVisible(true);//görünürlik

        hareket = new Hareket();
        hareket.setDurakSayisi(7);//kat sayısını belirledik
        katlar(hareket.getDurakSayisi());//Bu method tuş panelini oluşturuyor. İçerisine aldığı değer ile kaç tane kat tuşu olacağı belirleniyor.

        fanCalistir();
        telefonCalistir();
        alarmCal();
    }

    public void katlar(int y) {
        int j = 0;
        int r = 0;
        for (int i = 0; i <= y; i++) {
            buton = new JButton(new ImageIcon("./img/" + i + ".png"));
            buton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            final int finalI = i;
            final Hareket h = new Hareket();
            buton.setBorder(null);//kenar kalınlığı yok demek.
            buton.setContentAreaFilled(false);//buton altındaki görüntüyü kaldırıyor.
            switch (i) {
                case 0:
                    buton.setBounds(35, 105, 32, 32);
                    break;
                case 7:
                    r = 35;
                    j = 70;
                    break;
            }
            if (i != 0) {
                buton.setBounds(r, j, 32, 32);
                if (i % 3 == 0) {
                    j += 35;
                    r = 0;
                } else {
                    r += 35;
                }
            }
            buton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (Hareket.getDurak() < finalI) {
                            h.YukarıYon(finalI);
                        } else if (Hareket.getDurak() == finalI) {
                            //Birşey Yapma.
                        } else {
                            h.AsagıYon(finalI);
                        }
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            add(buton);

        }
        phone.setContentAreaFilled(false);
        fan.setContentAreaFilled(false);
        alarm.setContentAreaFilled(false);
        fan.setBorder(null);
        alarm.setBorder(null);
        phone.setBorder(null);
        fan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        alarm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        phone.setCursor(new Cursor(Cursor.HAND_CURSOR));
        alarm.setBounds(0, 70, 32, 32);
        fan.setBounds(0, 105, 32, 32);
        phone.setBounds(70, 70, 32, 32);
        add(alarm);
        add(fan);
        add(phone);
    }

    public void fanCalistir() {
        fan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!FanEkrani.calisiyor) {
                    FanEkrani.fanLabeli.setIcon(new ImageIcon("./img/fan.gif"));
                    FanEkrani.calisiyor = true;
                } else {
                    FanEkrani.fanLabeli.setIcon(new ImageIcon("./img/fan-calismiyor.png"));
                    FanEkrani.calisiyor = false;
                }
            }
        });
    }

    public void telefonCalistir() {
        phone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Olaylar().Cal("./sound/telephone-ring.wav");//Cal metodu .wav cinsinden bir ses dosyasını çalar.
                new Olaylar().telCalistir();//Burada da gif aktif olur.
            }
        });
    }

    public void alarmCal() {
        alarm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Olaylar().Cal("./sound/alarm.wav");
            }
        });
    }
}
