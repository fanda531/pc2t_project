import java.util.Scanner;
import java.util.Set;

public class Operation {
    public static void main(String[] args) {
        Databaze databazeStudentu = new Databaze();
        int current_id = 0;
        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while(run) {
            System.out.println("Vyberte pozadovanou cinnost:");
            System.out.println("1 .. vlozeni noveho studenta");
            System.out.println("2 .. pridat znamku studentovi");
            System.out.println("3 .. propustit studenta");
            System.out.println("4 .. vypis informace o studentovi");
            System.out.println("5 .. zavolat studenta na koberecek");
            System.out.println("6 .. abecedni vypis studentu");
            System.out.println("7 .. obecny prumer oboru");
            System.out.println("8 .. pocet studentu v oboru");
            System.out.println("9 .. ulozit databazi do souboru");
            System.out.println("10 .. nacist databazi se souboru (ID pak 2500+)");
            System.out.println("11 .. ulozit do SQL databaze");
            System.out.println("12 .. vypsat vsechny znamky studenta");
            System.out.println("13 .. nacist studenty z DB");
            int volba = sc.nextInt();
            sc.nextLine();

            switch (volba) {
                case 1:
                    System.out.print("Zadejte Jmeno studenta: ");
                    String jmeno = sc.nextLine();
                    System.out.print("Zadejte Prijmeni studenta: ");
                    String prijmeni = sc.nextLine();
                    System.out.print("Zadejte Datum narozeni (format: dd/mm/yyyy): ");
                    String datumNarozeni = sc.nextLine();
                    Controller.isRealDatum(datumNarozeni);
                    if(Controller.isRealDatum(datumNarozeni)){
                        System.err.println("Zadane datum narozeni neodpovida pozadovanemu formatu / datum neni platne");
                    }
                    else{
                        System.out.print("Vyberte skupinu - (1 = Technicky obor | 2 = Humanitarni obor | 3 = Kombinovany obor): ");
                        int vyber_vlozeni = sc.nextInt();
                        switch (vyber_vlozeni) {
                            case 1:
                                databazeStudentu.setStudent(current_id, datumNarozeni, jmeno, prijmeni, 1);
                                current_id += 1;
                                break;
                            case 2:
                                databazeStudentu.setStudent(current_id, datumNarozeni, jmeno, prijmeni, 2);
                                current_id += 1;
                                break;
                            case 3:
                                databazeStudentu.setStudent(current_id, datumNarozeni, jmeno, prijmeni, 3);
                                current_id += 1;
                                break;
                            default:
                                System.err.println("Chyba pri vyberu skupiny.. student nebyl vytvořen");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Zadejte ID studenta: ");
                    databazeStudentu.addZnamka(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Zadejte ID studenta: ");
                    databazeStudentu.delStudent(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Zadejte ID studenta: ");
                    databazeStudentu.getStudent(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Zadejte ID studenta: ");
                    databazeStudentu.callStudent(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Vyberte skupinu - (1 = Technicky obor | 2 = Humanitarni obor | 3 = Kombinovany obor): ");
                    int vyber_vypis = sc.nextInt();
                    switch (vyber_vypis) {
                        case 1:
                            databazeStudentu.abecedniVypis(vyber_vypis);
                            break;
                        case 2:
                            databazeStudentu.abecedniVypis(vyber_vypis);
                            break;
                        case 3:
                            databazeStudentu.abecedniVypis(vyber_vypis);
                            break;
                    }
                    break;

                case 7:
                    System.out.print("Vyberte skupinu - (1 = Technicky obor | 2 = Humanitarni obor): ");
                    int vyber_prumer = sc.nextInt();
                    switch (vyber_prumer){
                        case 1:
                            databazeStudentu.spolecnyPrumer(vyber_prumer);
                            break;
                        case 2:
                            databazeStudentu.spolecnyPrumer(vyber_prumer);
                            break;
                    }
                    break;

                case 8:
                    System.out.print("Vyberte skupinu - (1 = Technicky obor | 2 = Humanitarni obor | 3 = Kombinovany obor): ");
                    int vyber_pocet = sc.nextInt();
                    switch (vyber_pocet) {
                        case 1:
                            databazeStudentu.pocetStudentu(vyber_pocet);
                            break;
                        case 2:
                            databazeStudentu.pocetStudentu(vyber_pocet);
                            break;
                        case 3:
                            databazeStudentu.pocetStudentu(vyber_pocet);
                            break;
                    }
                    break;

                case 9:
                    System.out.print("Zadej jmeno souboru pro ulozeni databaze: ");
                    databazeStudentu.ulozDatabazi(sc.nextLine());
                    break;

                case 10:
                    System.out.print("Zadej jmeno souboru pro nacteni databaze (ID od 2500): ");
                    databazeStudentu.nactiDatabazi(sc.nextLine());
                    break;


                case 11:
                    databazeStudentu.converttoSQL();
                    break;

                case 12:
                    System.out.print("Zadejte ID studenta: ");
                    databazeStudentu.vypisZnamek(sc.nextInt());
                    break;

                case 13:
                    databazeStudentu.vypisSQL();
                    break;
            }
        }
    }
}
