package View;

import Controller.eksperymentController;
import Controller.logowanieController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class eksperymentView extends JFrame {

public  JComboBox wyborProbkiButon;
public static JTextField wykonalTF;
    private final eksperymentController controller;
    private String kopiaAktywnegoUzytkownika;
    public String date;
    private  double ubytekEksperyemnt;
    public eksperymentView(String activeUser){
    super("Klient bazy danych PLD - okno eksperymentu");
    setSize(1200,550);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);//podzial okna na dwie czesci

        controller=new eksperymentController(this);
      //  kopiaAktywnegoUzytkownika= activeUser;


    JPanel lewaStrona = new JPanel();
    lewaStrona.setLayout(null);
    lewaStrona.setBounds(0,10,400,520);

    JPanel prawaStrona = new JPanel();
    prawaStrona.setLayout(null);
    prawaStrona.setBounds(410,10,780,500);

    JLabel edycjaTF = new JLabel();
    edycjaTF.setText("Edycja elementów: ");
    edycjaTF.setBounds(10,10,130,25);
    lewaStrona.add(edycjaTF);

    JButton edytujProbkiButton = new JButton();
    edytujProbkiButton.setText("Próbki");
    edytujProbkiButton.setBounds(135,10,125,25);
    edytujProbkiButton.addActionListener((new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new  probkaView();
        }

    }));
    lewaStrona.add(edytujProbkiButton);

    JButton edytujMaterialButton = new JButton();
    edytujMaterialButton.setText("Materiał tarczy");
    edytujMaterialButton.setBounds(265,10,125,25);
    edytujMaterialButton.addActionListener((new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                new  materialTarczyView();
            }

    }));
    lewaStrona.add(edytujMaterialButton);


    JPanel menu = new JPanel();
    menu.setLayout( new GridLayout(12,2));
    menu.setBounds(10,38,380,400);


   /* menu.add(new JLabel("Wybór eksperymentu:"));
    JComboBox wyborEksperymentuButton = new JComboBox();
    menu.add(wyborEksperymentuButton);*/


    menu.add(new JLabel("Wybór próbki:"));
    wyborProbkiButon = new JComboBox();
    controller.getListIdMaterial();
    menu.add(wyborProbkiButon);

    menu.add(new JLabel("Moc lasera [mJ:]"));
    final JTextField mocLaseraTF = new JTextField();
    menu.add(mocLaseraTF);

    menu.add(new JLabel("Długość fali [nm]:"));
    final JTextField dlugoscFaliLaseraTF = new JTextField();
    menu.add(dlugoscFaliLaseraTF);

    menu.add(new JLabel("Częstotliwość [Hz]:"));
    final JTextField czestotliwoscLaseraTF = new JTextField();
    menu.add(czestotliwoscLaseraTF);

    menu.add(new JLabel("Pole plamki [mm^2]:"));
    final JTextField polePlamkiTF = new JTextField();
    menu.add(polePlamkiTF);

    menu.add(new JLabel("Ilość strzałów:"));
    final JTextField iloscStrzalowTF = new JTextField();
    menu.add(iloscStrzalowTF);

    menu.add(new JLabel("Atmosfera:"));
    final JTextField atmosferaTF = new JTextField();
    menu.add(atmosferaTF);


    menu.add(new JLabel("Materiał bazy:"));
    final JTextField materialBazyTF = new JTextField();
    menu.add(materialBazyTF);

  /*  menu.add(new JLabel("Data wykonania [RRRR/MM/DD]:"));
    final JTextField dataTF = new JTextField();
    menu.add(dataTF);*/

    menu.add(new JLabel("Wykonał:"));
    wykonalTF = new JTextField();
    wykonalTF.setEditable(false);
    wykonalTF.setText(activeUser);
    kopiaAktywnegoUzytkownika=activeUser;
    menu.add(wykonalTF);

    menu.add(new JLabel("Uwagi:"));
    final JTextField uwagiTF = new JTextField();
    menu.add(uwagiTF);

    lewaStrona.add(menu);



    JButton dodajEksperymentButton = new JButton();
    dodajEksperymentButton.setText("Dodaj eksperyment");
    dodajEksperymentButton.setBounds(100,450,190,25);
    dodajEksperymentButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            controller.ustawDateWykonania();
            controller.ustawDelte((Integer)wyborProbkiButon.getSelectedItem(),Integer.valueOf(iloscStrzalowTF.getText()));
            ubytekEksperyemnt=controller.ubytekZcontrolerra;
            controller.addEksperyment((Integer)wyborProbkiButon.getSelectedItem(),
                    atmosferaTF.getText(),Double.valueOf(mocLaseraTF.getText()),
                    Integer.valueOf(dlugoscFaliLaseraTF.getText()),
                   Integer.valueOf(czestotliwoscLaseraTF.getText()),
                    Double.valueOf(polePlamkiTF.getText()),Integer.valueOf(iloscStrzalowTF.getText()),
                    ubytekEksperyemnt,materialBazyTF.getText(), date,wykonalTF.getText(),uwagiTF.getText());
                    dispose();
                    new  eksperymentView(kopiaAktywnegoUzytkownika);

        }
    });
    lewaStrona.add(dodajEksperymentButton);

   /* JButton aktualizujEksperymentButton = new JButton();
    aktualizujEksperymentButton.setText("Aktualizuj eksperyment");
    bottomMenu.add(aktualizujEksperymentButton);

    JButton usunEksperymentButton = new JButton();
    usunEksperymentButton.setText("Usuń eksperyment");
    usunEksperymentButton.setBounds(200,450,190,25);
    lewaStrona.add(usunEksperymentButton);*/


    String [] nazwyKolumn = {
           "eksperyment_id",
           "probka_id",
           "Atmosfera",
           "Moc lasera[mJ]",
           "Długość fali [nm]",
           "F[Hz]",
           "Pole Plamki [mm^2]",
           "Ilość Strzałów",
           " Ubytek masy/Strzał[g]",
           "Materiał bazy",
           "Data wykonania",
           "Wykonał",
           "Uwagi"};

    Object[][] data = controller.showEksperyment();

    JPanel tabelaPanel = new JPanel();
    tabelaPanel.setLayout(new GridLayout());
    tabelaPanel.setBounds(0,0,780,500);
    JTable tabelaEksperymentow = new JTable(data,nazwyKolumn);
    tabelaPanel.add(new JScrollPane(tabelaEksperymentow));
    prawaStrona.add(tabelaPanel);

    this.add(lewaStrona);
    this.add(prawaStrona);
    setVisible(true);
}



}
