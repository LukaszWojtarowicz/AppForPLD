package Model;

public class Probka {
    private int probka_id;
    private int material_id;
    private double promien,grubosc,masaPoczatkowa,masaKoncowa,deltaMasy;

    public int getProbka_id() {
        return probka_id;
    }

    public void setProbka_id(int probka_id) {
        this.probka_id = probka_id;
    }

    public double getPromien() {
        return promien;
    }

    public void setPromien(double promien) {
        this.promien = promien;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public double getGrubosc() {
        return grubosc;
    }

    public void setGrubosc(double grubosc) {
        this.grubosc = grubosc;
    }

    public double getMasaPoczatkowa() {
        return masaPoczatkowa;
    }

    public void setMasaPoczatkowa(double masaPoczatkowa) {
        this.masaPoczatkowa = masaPoczatkowa;
    }

    public double getMasaKoncowa() {
        return masaKoncowa;
    }

    public void setMasaKoncowa(double masaKoncowa) {
        this.masaKoncowa = masaKoncowa;
    }

    public double getDeltaMasy() {
        return deltaMasy;
    }

    public void setDeltaMasy(double deltaMasy) {
        this.deltaMasy = deltaMasy;
    }


    public Probka(int probka_id,int material_id,double promien,double grubosc,double masaPoczatkowa,double masaKoncowa,double deltaMasy){
        this.probka_id= probka_id;
        this.material_id=material_id;
        this.promien=promien;
        this.grubosc=grubosc;
        this.masaPoczatkowa=masaPoczatkowa;
        this.masaKoncowa=masaKoncowa;
        this.deltaMasy=deltaMasy;
    }
}
