import java.security.KeyStore;
import java.sql.*;

public class SQL_DB {

    private Connection conn;

    public boolean connect() {
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:myDB.db");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void disconnect() {
        if (conn != null) {
            try {     conn.close();  }
            catch (SQLException ex) { System.out.println(ex.getMessage()); }
        }
    }

    public boolean createTable() {
        if (conn==null)
            return false;
        String sql = "CREATE TABLE IF NOT EXISTS studenti (" + "id integer PRIMARY KEY," + "jmeno varchar(255) NOT NULL," + "prijmeni varchar(255) NOT NULL," + "datum varchar(50)," + "znamky varchar(255)," + "id_oboru integer" + ");";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            return true;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void insertRecord(int id, String jmeno, String prijmeni,String datum_narozeni, String znamky, int id_oboru ) {
        String sql = "INSERT INTO studenti(id,jmeno,prijmeni,datum,znamky,id_oboru) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, jmeno);
            pstmt.setString(3, prijmeni);
            pstmt.setString(4, datum_narozeni);
            pstmt.setString(5, znamky);
            pstmt.setInt(6, id_oboru);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String selectAll(){
        String sql = "SELECT id, jmeno, prijmeni, datum, znamky, id_oboru FROM studenti";
        try {
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            String hodnoty_pro_ret = "";
            while (rs.next()) {
                hodnoty_pro_ret += Integer.toString(rs.getInt("id")) + "|" +  rs.getString("jmeno") + "|" + rs.getString("prijmeni") +
                "|" + rs.getString("datum") + "|" + rs.getString("znamky") + "|" + rs.getInt("id_oboru") + "-";
            }

            return hodnoty_pro_ret;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "SELECT FAILED";
        }
    }

    public Boolean selectID(int current_id){
        String sql = "SELECT id FROM studenti WHERE id = " + current_id;
        String test_str = "";
        try {
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next()) {
                test_str += rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if(test_str.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void update(int id, String popis, double plat) {
        String sql = "UPDATE zamestnanci SET plat = ? , "
                + "popis = ? "
                + "WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, plat);
            pstmt.setString(2, popis);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM zamestnanci WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
