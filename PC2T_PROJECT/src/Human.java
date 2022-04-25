public class Human extends Student{
    public Human(String jmeno, String prijmeni, String datum_narozeni, int id) {
        super(jmeno, prijmeni, datum_narozeni, id);
    }

    @Override
    public void saySomething() {
        String datum = this.getDatum_narozeni(); // ex: 24.02.2001 + CATCH ERROR PRI ZADAVANI ABY BYL PRESNY FORMAT + osetrit validni datum (zadny 33.87.2517)
        int rok = Integer.parseInt(datum.substring(datum.length() - 4)); // 2001
        int den = Integer.parseInt(datum.substring(0,2)); // 24
        int mesic = Integer.parseInt(datum.substring(3,5)); // 02

        // zkontrolovat jestli 02 bere jako 2 (unor) abych mohl testovat podminky
        if((mesic == 12 && den >= 22) || (mesic == 1 && den < 20)){
            // KOZOROH
            System.out.print("Jsem ve znameni kozoroha");
        }
        else if((mesic == 1 && den >= 21) || (mesic == 2 && den < 20)){
            // VODNAR
            System.out.print("Jsem ve znameni vodnare");
        }
        else if((mesic == 2 && den >= 21) || (mesic == 3 && den < 20)){
            // RYBY
            System.out.print("Jsem ve znameni ryb");
        }
        else if((mesic == 3 && den >= 21) || (mesic == 4 && den < 20)){
            // BERAN
            System.out.print("Jsem ve znameni berana");
        }
        else if((mesic == 4 && den >= 21) || (mesic == 5 && den < 20)){
            // BYK
            System.out.print("Jsem ve znameni byka");
        }
        else if((mesic == 5 && den >= 22) || (mesic == 6 && den < 21)){
            // BLIZENCI
            System.out.print("Jsem ve znameni blizencu");
        }
        else if((mesic == 6 && den >= 22) || (mesic == 7 && den < 22)){
            // RAK
            System.out.print("Jsem ve znameni raka");
        }
        else if((mesic == 7 && den >= 23) || (mesic == 8 && den < 22)){
            // LEV
            System.out.print("Jsem ve znameni lva");
        }
        else if((mesic == 8 && den >= 23) || (mesic == 9 && den < 22)){
            // PANNA
            System.out.print("Jsem ve znameni panny");
        }
        else if((mesic == 9 && den >= 23) || (mesic == 10 && den < 23)){
            // VAHY
            System.out.print("Jsem ve znameni vah");
        }
        else if((mesic == 10 && den >= 24) || (mesic == 11 && den < 22)){
            // STIR
            System.out.print("Jsem ve znameni stire");
        }
        else if((mesic == 11 && den >= 23) || (mesic == 12 && den < 21)){
            // STRELEC
            System.out.print("Jsem ve znameni strelce");
        }
        else{
            System.err.print("Doslo k chybe, neznam sve znameni");
        }
    }
}
