package Model;

public class Material {
    private int id;
    private String symbol;
    private Double gestosc;

    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public Double getGestosc() {
        return gestosc;
    }

    public Material(int id, String symbol, Double gestosc){
        this.id=id;
        this.symbol=symbol;
        this.gestosc=gestosc;
    }
}
