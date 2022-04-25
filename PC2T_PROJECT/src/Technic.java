public class Technic extends Student{

    public Technic(String jmeno, String prijmeni, String datum_narozeni, int id) {
        super(jmeno, prijmeni, datum_narozeni, id);
    }

    @Override
    public void saySomething() {
        String datum = this.getDatum_narozeni(); // something like 24.02.2001
        String datum_only_rok = ""; // 2001

        if(datum.length() > 4){ datum_only_rok = datum.substring(datum.length() - 4);}
        else{System.err.println("Datum je zadano chybne, nejde zkontrolovat prestupny rok");}

        int datum_rok_num = Integer.parseInt(datum_only_rok);
        if(datum_rok_num % 4 == 0){
            // rok JE prestupny
            System.out.print("Muj rok narozeni (" + datum_only_rok + ") je prestupny rok");
        }
        else if(datum_rok_num % 100 == 0 && datum_rok_num % 400 == 0){
            // rok JE take prestupny
            System.out.print("Muj rok narozeni (" + datum_only_rok + ") je prestupny rok");
        }
        else{
            // rok NENI prestupny
            System.out.print("Muj rok narozeni neni prestupny");
        }

    }
}
