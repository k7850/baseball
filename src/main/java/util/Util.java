package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Util {

    public static String dateFormat(Timestamp transferDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String formattedDate = dateFormat.format(transferDate);
        return formattedDate;
    }
}
