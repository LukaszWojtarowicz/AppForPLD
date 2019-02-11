package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.materialTarczyController;

public class materialTarczyView extends JFrame {

    private   Object[][] data;
    private   String[] nazwyKolumn = {"material_id", "Symbol", "Gęstość[g/cm^3]"};
    private   JTable  tabelaMaterialow;
    private   JPanel  tabelaPanel;
    private final JPanel materialContainer;
    private final materialTarczyController controller;

    public materialTarczyView(){
        super("Klient bazy danych PLD - materialy");
        setSize(400,400);
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller = new materialTarczyController(this);
        materialContainer = new JPanel();
        materialContainer.setLayout(null);

      //  JLabel materialIdLabel = new JLabel();
        final JLabel symbolLabel = new JLabel();
        JLabel gestoscLabel = new JLabel();
       // final JTextField materialIdTF = new  JTextField();
        final JTextField symbolTF = new JTextField();
        final JTextField gestoscTF = new JTextField();
        JButton dodajButton = new JButton();
       // JButton odswiezButton = new JButton();


       /* materialIdLabel.setBounds(0,0,120,25);
        materialIdLabel.setLocation(10,10);
        materialIdLabel.setText("Materiał_ID:");
        materialContainer.add(materialIdLabel);*/

        symbolLabel.setBounds(0,0,120,25);
        symbolLabel.setLocation(10,25);
        symbolLabel.setText("Symbol materialu:");
        materialContainer.add(symbolLabel);

        gestoscLabel.setBounds(0,0,120,25);
        gestoscLabel.setLocation(10,75);
        gestoscLabel.setText("Gęstość materialu:");
        materialContainer.add(gestoscLabel);

      /*  materialIdTF.setBounds(0,0,70,30);
        materialIdTF.setLocation(130,10);
        materialContainer.add(materialIdTF);*/

        symbolTF.setBounds(0,0,70,30);
        symbolTF.setLocation(130,25);
        materialContainer.add(symbolTF);

        gestoscTF.setBounds(0,0,70,30);
        gestoscTF.setLocation(130,75 );
        materialContainer.add(gestoscTF);

        dodajButton.setBounds(0,0,120,80);
        dodajButton.setLocation(250,25);
        dodajButton.setText("Dodaj materiał");


        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addMaterial(symbolTF.getText(), Double.valueOf(gestoscTF.getText()));
                dispose();
                new materialTarczyView();
            }
        });
        materialContainer.add(dodajButton);



        /*usunButton.setBounds(0,0,120,30);
        usunButton.setLocation(250,65);
        usunButton.setText("Usuń materiał");
        materialContainer.add(usunButton);*/


        data = controller.showMaterialy();
        tabelaPanel = new JPanel();
        tabelaPanel.setLayout(new GridLayout(1,1));
        tabelaPanel.setLocation(25,130);
        tabelaPanel.setSize(350,220);
        tabelaMaterialow = new JTable(data,nazwyKolumn);
        tabelaPanel.add(new JScrollPane((tabelaMaterialow)));
        materialContainer.add(tabelaPanel);
        this.add(materialContainer);


        setVisible(true);
    }

}
