package Controller;

import Model.Eksperyment;
import Model.eksperymentModel;
import View.eksperymentView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class eksperymentController {
    private eksperymentModel modelEksperyment;
    private eksperymentView viewEksperyment;
    public Object listaIdProbekDlaEksperymentu;
    public double ubytekZcontrolerra;

    public eksperymentController(eksperymentView viewEksperyment){
        this.viewEksperyment = viewEksperyment;
        modelEksperyment = new eksperymentModel();
    }


    public void addEksperyment(Integer probka_id, String atmosfera, Double mocLasera, Integer dlugoscFali,
                               Integer czestotliwosc, Double polePowierzchniPlamki, Integer iloscStrzalow,Double ubytek,
                               String materialBazy, String dataWykonania, String uzytkownik_id, String uwagi){

        modelEksperyment.setProbka_id(probka_id);
        modelEksperyment.setAtmosfera(atmosfera);
        modelEksperyment.setMocLasera(mocLasera);
        modelEksperyment.setDlugoscFali(dlugoscFali);
        modelEksperyment.setCzestotliwosc(czestotliwosc);
        modelEksperyment.setPolePowierzchniPlamki(polePowierzchniPlamki);
        modelEksperyment.setIloscStrzalow(iloscStrzalow);
        modelEksperyment.setUbytekMasyNaStrzal(ubytek);
        modelEksperyment.setMaterialBazy(materialBazy);
        modelEksperyment.setDataWykonania(dataWykonania);
        modelEksperyment.setUzytkownik_id(uzytkownik_id);
        modelEksperyment.setUwagi(uwagi);
        modelEksperyment.addEksperyment();

    }

    public Object getListIdMaterial(){
        modelEksperyment.getProbkaIdList();
        for (int i = 0; i < modelEksperyment.probkiListaID.size(); i++) {
            listaIdProbekDlaEksperymentu=modelEksperyment.probkiListaID.get(i);
            viewEksperyment.wyborProbkiButon.addItem(listaIdProbekDlaEksperymentu);
        }

        return  listaIdProbekDlaEksperymentu;
    }

    public void ustawDateWykonania(){
        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(now);
        viewEksperyment.date=mysqlDateString;
    }



    public double ustawDelte(Integer id, Integer iloscStrzalow){
          double deltaDoObliczen = modelEksperyment.getDeltaMasProbki(id);
          double liczbaStrzalow=iloscStrzalow;
        ubytekZcontrolerra=deltaDoObliczen/liczbaStrzalow;
            return ubytekZcontrolerra;
    }

    public Object[][] showEksperyment(){
        ArrayList<Eksperyment> lista = modelEksperyment.listaEksperymentow();
        Object [][] modelEksperymentu = new Object[lista.size()][13];

        for (int i = 0; i < lista.size(); i++)  {
            modelEksperymentu[i][0] = lista.get(i).getEksperyment_id();
            modelEksperymentu[i][1] = lista.get(i).getProbka_id();
            modelEksperymentu[i][2] = lista.get(i).getAtmosfera();
            modelEksperymentu[i][3] = lista.get(i).getMocLasera();
            modelEksperymentu[i][4] = lista.get(i).getDlugoscFali();
            modelEksperymentu[i][5] = lista.get(i).getCzestotliwosc();
            modelEksperymentu[i][6] = lista.get(i).getPolePowierzchniPlamki();
            modelEksperymentu[i][7] = lista.get(i).getIloscStrzalow();
            modelEksperymentu[i][8] = lista.get(i).getUbytekMasyNaStrzal();
            modelEksperymentu[i][9] = lista.get(i).getMaterialBazy();
            modelEksperymentu[i][10] = lista.get(i).getDataWykonania();
            modelEksperymentu[i][11] = lista.get(i).getUzytkownik_id();
            modelEksperymentu[i][12] = lista.get(i).getUwagi();
         }

        return  modelEksperymentu;
    }
}
