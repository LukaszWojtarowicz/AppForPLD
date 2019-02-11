package Model;

import java.util.Date;

public class Eksperyment {
    private  int eksperyment_id, probka_id, iloscStrzalow,czestotliwosc,dlugoscFali;
    private String atmosfera,uwagi,materialBazy,uzytkownik_id;
    private double mocLasera,  polePowierzchniPlamki,ubytekMasyNaStrzal;
    private Date dataWykonania;


    public int getEksperyment_id() {
        return eksperyment_id;
    }

    public void setEksperyment_id(int eksperyment_id) {
        this.eksperyment_id = eksperyment_id;
    }

    public int getProbka_id() {
        return probka_id;
    }

    public void setProbka_id(int probka_id) {
        this.probka_id = probka_id;
    }



    public String getAtmosfera() {
        return atmosfera;
    }

    public void setAtmosfera(String atmosfera) {
        this.atmosfera = atmosfera;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public double getMocLasera() {
        return mocLasera;
    }

    public void setMocLasera(double mocLasera) {
        this.mocLasera = mocLasera;
    }

    public int getDlugoscFali() {
        return dlugoscFali;
    }

    public void setDlugoscFali(int dlugoscFali) {
        this.dlugoscFali = dlugoscFali;
    }



    public double getPolePowierzchniPlamki() {
        return polePowierzchniPlamki;
    }

    public void setPolePowierzchniPlamki(double polePowierzchniPlamki) {
        this.polePowierzchniPlamki = polePowierzchniPlamki;
    }


    public double getUbytekMasyNaStrzal() {
        return ubytekMasyNaStrzal;
    }

    public void setUbytekMasyNaStrzal(double ubytekMasyNaStrzal) {
        this.ubytekMasyNaStrzal = ubytekMasyNaStrzal;
    }


    public Date getDataWykonania() {
        return dataWykonania;
    }

    public void setDataWykonania(Date dataWykonania) {
        this.dataWykonania = dataWykonania;
    }


    public int getIloscStrzalow() {
        return iloscStrzalow;
    }

    public void setIloscStrzalow(int iloscStrzalow) {
        this.iloscStrzalow = iloscStrzalow;
    }

    public int getCzestotliwosc() {
        return czestotliwosc;
    }

    public void setCzestotliwosc(int czestotliwosc) {
        this.czestotliwosc = czestotliwosc;
    }

    public String getMaterialBazy() {
        return materialBazy;
    }

    public void setMaterialBazy(String materialBazy) {
        this.materialBazy = materialBazy;
    }

    public Eksperyment(int eksperyment_id, int probka_id, String atmosfera, double mocLasera, int dlugoscFali,
                       int czestotliwosc, double polePowierzchniPlamki,int iloscStrzalow,double ubytekMasyNaStrzal,
                       String materialBazy, Date dataWykonania,String uzytkownik_id, String uwagi){
        this.eksperyment_id=eksperyment_id;
        this.probka_id=probka_id;
        this.atmosfera=atmosfera;
        this.mocLasera=mocLasera;
        this.dlugoscFali=dlugoscFali;
        this.czestotliwosc=czestotliwosc;
        this.polePowierzchniPlamki=polePowierzchniPlamki;
        this.iloscStrzalow=iloscStrzalow;
        this.ubytekMasyNaStrzal=ubytekMasyNaStrzal;
        this.materialBazy=materialBazy;
        this.dataWykonania=dataWykonania;
        this.uzytkownik_id=uzytkownik_id;
        this.uwagi=uwagi;
    }


    public String getUzytkownik_id() {
        return uzytkownik_id;
    }

    public void setUzytkownik_id(String uzytkownik_id) {
        this.uzytkownik_id = uzytkownik_id;
    }
}
