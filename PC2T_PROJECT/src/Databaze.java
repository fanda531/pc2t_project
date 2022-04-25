import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Databaze {
    private Map<Integer, Student> prvkyDatabaze = new HashMap();
    Scanner sc = new Scanner(System.in);

    public void setStudent(int id, String datum_narozeni, String jmeno, String prijmeni, int volba_studia) {
        if(volba_studia == 1){
            prvkyDatabaze.put(id, new Technic(jmeno, prijmeni, datum_narozeni, id));
        }
        else if(volba_studia == 2){
            prvkyDatabaze.put(id, new Human(jmeno, prijmeni, datum_narozeni, id));
        }
        else{
            prvkyDatabaze.put(id, new Komb(jmeno, prijmeni, datum_narozeni, id));
        }
    }

    public void addZnamka(int id){
        System.out.print("Zadejte znamku pro studenta s id " + id + " (celociselne 1-5): ");
        int znamka = sc.nextInt();

        if(prvkyDatabaze.containsKey(id)){
            prvkyDatabaze.get(id).addZnamka(znamka);
        }
        else{
            System.out.println("Chyba pri zadavani znamky, studenta neslo najit");
        }
    }

    public void delStudent(int id){
        if(prvkyDatabaze.containsKey(id)){
            prvkyDatabaze.remove(id);
            System.out.println("Student byl odstranen");
        }
        else{
            System.out.println("Student s timto ID nebyl nalezen");
        }
    }

    public void getStudent(int id){
        if(prvkyDatabaze.containsKey(id)){
            Student current_stud = prvkyDatabaze.get(id);
            System.out.println("---------");
            System.out.println("ID studenta: "+ current_stud.getId());
            System.out.println("Jmeno studenta: " + current_stud.getJmeno());
            System.out.println("Prijemni studenta: " + current_stud.getPrijmeni());
            System.out.println("Datum narozeni: " + current_stud.getDatum_narozeni());
            System.out.println("Studijni prumer: " + current_stud.getPrumer());
            System.out.println("---------");
        }
        else{
            System.out.println("Student s timto ID nebyl nalezen");
        }
    }

    public void callStudent(int id){
        if(prvkyDatabaze.containsKey(id)){
            System.out.print(prvkyDatabaze.get(id).getJmeno() + ": '");
            prvkyDatabaze.get(id).saySomething();
            System.out.print("'");
            System.out.println();
        }
        else{
            System.out.println("Student s timto ID nebyl nalezen");
        }
    }


    public void abecedniVypis(int volba_studia){
        Set<Integer> ids = this.prvkyDatabaze.keySet();
        List<Student> list_studentu = new ArrayList<Student>();

        if(volba_studia == 1){
            System.out.println("Vypis studentu technickoho oboru: ");
            for(int id : ids){
                if(prvkyDatabaze.get(id) instanceof Technic){
                    list_studentu.add(prvkyDatabaze.get(id));
                }
            }

            // SORTING BY PRIJMENI HERE:
            Collections.sort(list_studentu, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    int compareResult = o1.getPrijmeni().compareTo(o2.getPrijmeni());
                    if (compareResult > 0){
                        // o1 smaller
                        return 1;
                    }
                    else if (compareResult < 0){
                        //o1 bigger
                        return -1;
                    }
                    else{
                        // o1 is equal to o2
                        return 0;
                    }
                }
            });

            for(Student stud : list_studentu){
                System.out.println("ID: " + stud.getId() + " | Jmeno: " + stud.getJmeno() + " | Prijmeni: " + stud.getPrijmeni() + " | Datum narozeni: " + stud.getDatum_narozeni() + " | Studijni prumer: " + stud.getPrumer());
            }
            System.out.println();
        }
        else if(volba_studia == 2){
            System.out.println("Vypis studentu humanitarniho oboru: ");
            for(int id : ids){
                if(prvkyDatabaze.get(id) instanceof Human){
                    list_studentu.add(prvkyDatabaze.get(id));
                }
            }

            Collections.sort(list_studentu, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    int compareResult = o1.getPrijmeni().compareTo(o2.getPrijmeni());
                    if (compareResult > 0){
                        // o1 smaller
                        return 1;
                    }
                    else if (compareResult < 0){
                        //o1 bigger
                        return -1;
                    }
                    else{
                        // o1 is equal to o2
                        return 0;
                    }
                }
            });

            for(Student stud : list_studentu){
                System.out.println("ID: " + stud.getId() + " | Jmeno: " + stud.getJmeno() + " | Prijmeni: " + stud.getPrijmeni() + " | Datum narozeni: " + stud.getDatum_narozeni() + " | Studijni prumer: " + stud.getPrumer());
            }
            System.out.println();
        }
        else{
            System.out.println("Vypis studentu kombinovaneho oboru: ");
            for(int id : ids){
                if(prvkyDatabaze.get(id) instanceof Komb){
                    list_studentu.add(prvkyDatabaze.get(id));
                }
            }

            Collections.sort(list_studentu, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    int compareResult = o1.getPrijmeni().compareTo(o2.getPrijmeni());
                    if (compareResult > 0){
                        // o1 smaller
                        return 1;
                    }
                    else if (compareResult < 0){
                        //o1 bigger
                        return -1;
                    }
                    else{
                        // o1 is equal to o2
                        return 0;
                    }
                }
            });

            for(Student stud : list_studentu){
                System.out.println("ID: " + stud.getId() + " | Jmeno: " + stud.getJmeno() + " | Prijmeni: " + stud.getPrijmeni() + " | Datum narozeni: " + stud.getDatum_narozeni() + " | Studijni prumer: " + stud.getPrumer());
            }
            System.out.println();
        }
    }

    public void vypisZnamek(int id_studenta){
        if(prvkyDatabaze.containsKey(id_studenta)){
            prvkyDatabaze.get(id_studenta).vypisZnamky();
        }
        else{
            System.err.println("NELZE VYPSAT ZNAMKY STUDENTA S ID: " + id_studenta);
        }

    }

    public void spolecnyPrumer(int volba_studia){
        Set<Integer> ids = this.prvkyDatabaze.keySet();

        if(volba_studia == 1){
            Double soucet_prumeru = 0.0;
            Double pocet_studentu = Double.parseDouble(ids.size() + ".0");



            for(int id : ids){
                if(prvkyDatabaze.get(id) instanceof Technic){
                    soucet_prumeru += prvkyDatabaze.get(id).getPrumer();
                }
            }

            Double result = soucet_prumeru / pocet_studentu;
            System.out.println("Obecny studijni prumer technickeho oboru je: " +  result);
        }
        else{
            Double soucet_prumeru = 0.0;
            Double pocet_studentu = Double.parseDouble(ids.size() + ".0");

            for(int id : ids){
                if(prvkyDatabaze.get(id) instanceof Human){
                    soucet_prumeru += prvkyDatabaze.get(id).getPrumer();
                }
            }

            Double result = soucet_prumeru / pocet_studentu;
            System.out.println("Obecny studijni prumer humanitarnim oboru je: " +  result);
        }

    }

    public void pocetStudentu(int volba_studia){
        Set<Integer> ids = this.prvkyDatabaze.keySet();

        if(volba_studia == 1){
            int pocet = 0;
            for(int id : ids){
                if(prvkyDatabaze.get(id) instanceof Technic){
                    pocet += 1;
                }
            }
            System.out.println("Pocet studentu na technickem oboru je: " + pocet);
        }
        else if(volba_studia == 2){
            int pocet = 0;
            for(int id : ids){
                if(prvkyDatabaze.get(id) instanceof Human){
                    pocet += 1;
                }
            }
            System.out.println("Pocet studentu na humanitarnim oboru je: " + pocet);
        }
        else{
            int pocet = 0;
            for(int id : ids){
                if(prvkyDatabaze.get(id) instanceof Komb){
                    pocet += 1;
                }
            }
            System.out.println("Pocet studentu na kombinovanem oboru je: " + pocet);
        }
    }

    public boolean ulozDatabazi(String jmenoSouboru) {
        try {
            FileWriter fw = new FileWriter(jmenoSouboru);
            BufferedWriter out = new BufferedWriter(fw);

            Set<Integer> ids = this.prvkyDatabaze.keySet();

            for(int id: ids){
                String vsechny_znamky = "X";
                for (int znamka: prvkyDatabaze.get(id).getZnamky()) {
                    vsechny_znamky += Integer.toString(znamka);
                }

                out.write(prvkyDatabaze.get(id).getJmeno() + " " + prvkyDatabaze.get(id).getPrijmeni() + " " + prvkyDatabaze.get(id).getDatum_narozeni() + " " + prvkyDatabaze.get(id).getPrumer() + " " + vsechny_znamky);
                if(prvkyDatabaze.get(id) instanceof Technic){
                    out.write(" Technicky");
                }
                else if(prvkyDatabaze.get(id) instanceof  Human){
                    out.write(" Humanitarni");
                }
                else{
                    out.write(" Kombinovany");
                }
                out.newLine();
            }

            out.close();
            fw.close();
            return true;
        } catch (IOException var5) {
            System.out.println("Soubor nelze vytvorit");
            return false;
        }
    }

    public boolean nactiDatabazi(String jmenoSouboru) {
        int id = 2500;
        FileReader fr = null;
        BufferedReader in = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(jmenoSouboru));
            int lines = 0;
            while(reader.readLine() != null){
                lines ++;
            }
            reader.close();

            fr = new FileReader(jmenoSouboru);
            in = new BufferedReader(fr);

            for(int i = 0; i < lines; ++i){
                String radek = in.readLine();
                String[] castiTextu = radek.split("[ ]+");

                //System.out.println(castiTextu[5]);

                if(castiTextu[5].trim().equals("Technicky".trim())){
                    this.prvkyDatabaze.put(id, new Technic(castiTextu[0], castiTextu[1], castiTextu[2], id));
                    String znamky = castiTextu[4].substring(1);
                    for (char znamka : znamky.toCharArray()) {
                        prvkyDatabaze.get(id).addZnamka(Character.getNumericValue(znamka));
                    }
                }
                else if(castiTextu[5].trim().equals("Humanitarni".trim())){
                    this.prvkyDatabaze.put(id, new Human(castiTextu[0], castiTextu[1], castiTextu[2], id));
                    String znamky = castiTextu[4].substring(1);
                    for (char znamka : znamky.toCharArray()) {
                        prvkyDatabaze.get(id).addZnamka(Character.getNumericValue(znamka));
                    }
                }
                else{
                    this.prvkyDatabaze.put(id, new Komb(castiTextu[0], castiTextu[1], castiTextu[2], id));
                    String znamky = castiTextu[4].substring(1);
                    for (char znamka : znamky.toCharArray()) {
                        prvkyDatabaze.get(id).addZnamka(Character.getNumericValue(znamka));
                    }
                }
                id++;
            }

            in.close();
            fr.close();
            return true;
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public void converttoSQL(){
        Set<Integer> ids = this.prvkyDatabaze.keySet();

        SQL_DB sql_db = new SQL_DB();
        sql_db.connect();
        sql_db.createTable();

        for(int id : ids){

            String vsechny_znamky = "X";
            for (int znamka: prvkyDatabaze.get(id).getZnamky()) {
                vsechny_znamky += Integer.toString(znamka);
            }

            int counter = id;
            while(sql_db.selectID(counter) == false){
                counter += 1;

            }

            if(prvkyDatabaze.get(id) instanceof Technic){
                sql_db.insertRecord(counter, prvkyDatabaze.get(id).getJmeno(), prvkyDatabaze.get(id).getPrijmeni(), prvkyDatabaze.get(id).getDatum_narozeni(), vsechny_znamky, 1);
            }
            else if(prvkyDatabaze.get(id) instanceof  Human){
                sql_db.insertRecord(counter, prvkyDatabaze.get(id).getJmeno(), prvkyDatabaze.get(id).getPrijmeni(), prvkyDatabaze.get(id).getDatum_narozeni(), vsechny_znamky, 2);
            }
            else{
                sql_db.insertRecord(counter, prvkyDatabaze.get(id).getJmeno(), prvkyDatabaze.get(id).getPrijmeni(), prvkyDatabaze.get(id).getDatum_narozeni(), vsechny_znamky, 3);
            }
        }

        sql_db.disconnect();

    }

    public void vypisSQL(){
        Set<Integer> ids = this.prvkyDatabaze.keySet();


        SQL_DB sql_db = new SQL_DB();
        sql_db.connect();
        sql_db.createTable();

        try {
            String[] jednotlivy_rows = sql_db.selectAll().split("[-]+");

            for (String student : jednotlivy_rows) {
                String[] jednotlivy_columns = student.split("[|]");
                setStudent(Integer.parseInt(jednotlivy_columns[0]), jednotlivy_columns[3], jednotlivy_columns[1], jednotlivy_columns[2], Integer.parseInt(jednotlivy_columns[5]));
                //System.out.println("id:" + jednotlivy_columns[0] + " datum: " + jednotlivy_columns[3] + " jmeno: " + jednotlivy_columns[1] + " prijmeni:" + jednotlivy_columns[2] + " id_oboru:" + jednotlivy_columns[5]);

                String znamky = jednotlivy_columns[4].substring(1);
                for (char znamka : znamky.toCharArray()) {
                    prvkyDatabaze.get(Integer.parseInt(jednotlivy_columns[0])).addZnamka(Character.getNumericValue(znamka));
                }

            }
        }catch(NumberFormatException ex){
            System.err.println("NELZE NACIST PRVKY Z DATABAZE");
        }
        sql_db.disconnect();
    }

}

