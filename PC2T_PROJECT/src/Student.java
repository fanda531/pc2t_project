import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Student {

    public Student(String jmeno, String prijmeni, String datum_narozeni, int id){
        this.datum_narozeni = datum_narozeni;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.id = id;
    }

    private int id;
    private String jmeno;
    private String prijmeni;
    private String datum_narozeni;

    private List<Integer> znamky = new ArrayList<Integer>();

    public void addZnamka(int znamka){
        if(znamka < 1 || znamka > 5){
            System.err.println("Znamka neni validni..");
        }
        else{
            this.znamky.add(znamka);
        }
    }

    public void vypisZnamky() {
        System.out.println("Znamky:");
        for (int znamka: znamky) {
            System.out.print(" " +znamka);
        }
        System.out.println("\n------------");
    }

    public List<Integer> getZnamky() {
        return znamky;
    }

    public Double getPrumer(){
        Double soucetZnamek = 0.0;
        Double pocetZnamek = Double.parseDouble(znamky.size() + ".0");
        for(int znamka : znamky){
            soucetZnamek += znamka;
        }

        return soucetZnamek / pocetZnamek;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getDatum_narozeni() {
        return datum_narozeni;
    }

    public void setDatum_narozeni(String datum_narozeni) {
        this.datum_narozeni = datum_narozeni;
    }

    public abstract void saySomething();

}
