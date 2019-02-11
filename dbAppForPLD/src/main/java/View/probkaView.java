package View;

import Controller.materialTarczyController;
import Controller.probkaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class probkaView extends JFrame {

    public  JComboBox materialIdCB;
    private final probkaController controller;
    private   Object[][] data;
    private  String [] nazwyKolumn = {"probka_id","material_id","promień","grubość","masa początkowa","masa końcowa","delta masy"};

    public probkaView(){
        super("Klient bazy danych PLD - próbki");
        setSize(1000,370);
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        controller = new probkaController(this);


        JPanel probkaContainer = new JPanel();
        probkaContainer.setLayout(null);

        //JLabel probkaIdLabel = new JLabel();
        JLabel materialIdLabel = new JLabel();
        JLabel promienLabel = new JLabel();
        JLabel gruboscLabel = new JLabel();
        JLabel masaPoczatkowaLabel = new JLabel();
        JLabel masaKoncowaLabel = new JLabel();
       // JLabel deltaMasyLabel = new JLabel();
        //JComboBox probkalIdCB = new JComboBox();
        materialIdCB = new JComboBox();
        final JTextField promienTF = new JTextField();
        final JTextField gruboscTF = new JTextField();
        final JTextField masaPoczatkowaTF = new JTextField();
        final JTextField masaKoncowaTF = new JTextField();
        JTextField deltaMasyTF = new JTextField();
        JButton dodajButton = new JButton();
        JButton usunButton = new JButton();

       /*probkaIdLabel.setBounds(0,0,70,25);
        probkaIdLabel.setLocation(10,10);
        probkaIdLabel.setText("Próbka_ID:");
        probkaContainer.add(probkaIdLabel);

        probkalIdCB.setBounds(0,0,120,30);
        probkalIdCB.setLocation(140,10);
        probkaContainer.add(probkalIdCB);*/

        materialIdLabel.setBounds(0,0,130,25);
        materialIdLabel.setLocation(10,25);
        materialIdLabel.setText("Materiał próbki:");
        probkaContainer.add(materialIdLabel);

        materialIdCB.setBounds(0,0,120,30);
        materialIdCB.setLocation(140,25);
        controller.getListIdMaterial();
        probkaContainer.add(materialIdCB);


        promienLabel.setBounds(0,0,130,25);
        promienLabel.setLocation(10,65);
        promienLabel.setText("Promień próbki [mm]:");
        probkaContainer.add(promienLabel);

        promienTF.setBounds(0,0,120,30);
        promienTF.setLocation(140,65);
        probkaContainer.add(promienTF);

        gruboscLabel.setBounds(0,0,130,25);
        gruboscLabel.setLocation(10,105);
        gruboscLabel.setText("Grubość próbki [mm]:");
        probkaContainer.add(gruboscLabel);

        gruboscTF.setBounds(0,0,120,30);
        gruboscTF.setLocation(140,105);
        probkaContainer.add(gruboscTF);

        masaPoczatkowaLabel.setBounds(0,0,130,25);
        masaPoczatkowaLabel.setLocation(10,145);
        masaPoczatkowaLabel.setText("Masa początkowa [g]:");
        probkaContainer.add(masaPoczatkowaLabel);

        masaPoczatkowaTF.setBounds(0,0,120,30);
        masaPoczatkowaTF.setLocation(140,145);
        probkaContainer.add(masaPoczatkowaTF);

        masaKoncowaLabel.setBounds(0,0,130,25);
        masaKoncowaLabel.setLocation(10,185);
        masaKoncowaLabel.setText("Masa końcowa [g]:");
        probkaContainer.add(masaKoncowaLabel);

        masaKoncowaTF.setBounds(0,0,120,30);
        masaKoncowaTF.setLocation(140,185);
        probkaContainer.add(masaKoncowaTF);


      /*  deltaMasyLabel.setBounds(0,0,130,25);
        deltaMasyLabel.setLocation(10,225);
        deltaMasyLabel.setText("Delta masy [g]:");
        probkaContainer.add(deltaMasyLabel);

        deltaMasyTF.setBounds(0,0,120,30);
        deltaMasyTF.setLocation(140,225);
        deltaMasyTF.setEditable(false);
        probkaContainer.add(deltaMasyTF);*/

        dodajButton.setBounds(0,0,250,30);
        dodajButton.setLocation(10,245);
        dodajButton.setText("Dodaj próbke");
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.dodajProbke((Integer) materialIdCB.getSelectedItem(), Double.valueOf(promienTF.getText()),Double.valueOf(gruboscTF.getText()),Double.valueOf(masaPoczatkowaTF.getText()),Double.valueOf(masaKoncowaTF.getText()));
                dispose();
                new probkaView();
            }
        });
        probkaContainer.add(dodajButton);

      /*  usunButton.setBounds(0,0,120,30);
        usunButton.setLocation(140,265);
        usunButton.setText("Usuń próbke");
        probkaContainer.add(usunButton);*/



        data = controller.showProbki();
        JPanel probkiPanel = new JPanel();
        probkiPanel.setLayout(new GridLayout(1,1));
        probkiPanel.setLocation(265,10);
        probkiPanel.setSize(715,311);
        //dodanie tabeli do panelu
        JTable tabelaProbek = new JTable(data, nazwyKolumn);
        probkiPanel.add(new JScrollPane((tabelaProbek)));
        probkaContainer.add(probkiPanel);

        this.add(probkaContainer);
        setVisible(true);
    }

}
