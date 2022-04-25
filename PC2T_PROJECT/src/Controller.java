
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Controller {
    static public boolean isRealDatum(String datum){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(datum.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}
