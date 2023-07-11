import db.DBConnection;

import java.sql.Connection;

public class BaseBallApp {

    public static void main(String[] args) {
        Connection connection = DBConnection.getInstance();


    }
}
