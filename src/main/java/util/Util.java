package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Util {

    public static String dateFormat(Timestamp transferDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String formattedDate = dateFormat.format(transferDate);
        return formattedDate;
    }

    public static Boolean checkString(String str) {
        String pattern = "^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*$";
        if (!Pattern.matches(pattern, str)) {
            return true;
        } else {
            return false;
        }
    }

}
