package Controller;


import Model.Probka;
import Model.probkaModel;
import View.probkaView;

import java.awt.*;
import java.util.ArrayList;

public class probkaController {
    private probkaModel controllerModel;
    private probkaView  viewProbka;
    public Object listaIdMaterialowDlaProbki;

    public probkaController(probkaView viewProbka){
        this.viewProbka = viewProbka;
        controllerModel = new probkaModel();

    }

   public void dodajProbke (Integer material_id, Double promien, Double grubosc, Double masaPoczatkowa, Double masaKoncowa){
        double m1,m2,delta=0;
        m1=masaPoczatkowa;
        m2=masaKoncowa;
        delta = m1-m2;
    controllerModel.setMaterial_id(material_id);
    controllerModel.setPromien(promien);
    controllerModel.setGrubosc(grubosc);
    controllerModel.setMasaPoczatkowa(masaPoczatkowa);
    controllerModel.setMasaKoncowa(masaKoncowa);
    controllerModel.setDeltaMasy(delta);
    controllerModel.addProbka();
    }

    public Object getListIdMaterial(){
       controllerModel.getMaterialIdList();
        for (int i = 0; i < controllerModel.materialyListaID.size(); i++) {
           listaIdMaterialowDlaProbki=controllerModel.materialyListaID.get(i);
           viewProbka.materialIdCB.addItem(listaIdMaterialowDlaProbki);
        }

        return  listaIdMaterialowDlaProbki;
    }

    public Object[][] showProbki(){
        ArrayList<Probka> lista = controllerModel.listaProbek();
        Object [][] modelProbki = new Object[lista.size()][7];

        for (int i = 0; i < lista.size(); i++)  {
            modelProbki[i][0] = lista.get(i).getProbka_id();
            modelProbki[i][1] = lista.get(i).getMaterial_id();
            modelProbki[i][2] = lista.get(i).getPromien();
            modelProbki[i][3] = lista.get(i).getGrubosc();
            modelProbki[i][4] = lista.get(i).getMasaPoczatkowa();
            modelProbki[i][5] = lista.get(i).getMasaKoncowa();
            modelProbki[i][6] = lista.get(i).getDeltaMasy();

        }

        return  modelProbki;
    }
}
