package Controller;
import Model.Material;
import Model.materialTarczyModel;
import View.materialTarczyView;

import java.util.ArrayList;


public class materialTarczyController {

    private materialTarczyView viewMaterialu;
    private materialTarczyModel modelMaterialu;

    public materialTarczyController(materialTarczyView viewMaterialu){
        this.viewMaterialu = viewMaterialu;
        modelMaterialu = new materialTarczyModel();
    }
    public void addMaterial(String symbol, Double gestosc){
        modelMaterialu.setSymbol(symbol);
        modelMaterialu.setGestosc(gestosc);
        modelMaterialu.add();
    }
    public Object[][] showMaterialy(){
        ArrayList<Material> lista = modelMaterialu.listaMaterialow();
        Object [][] model = new Object[lista.size()][3];

        for (int i = 0; i < lista.size(); i++)  {
                model[i][0] = lista.get(i).getId();
                model[i][1] = lista.get(i).getSymbol();
                model[i][2] = lista.get(i).getGestosc();
            }

        return  model;
        }


}

