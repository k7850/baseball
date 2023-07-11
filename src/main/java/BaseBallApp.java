import DAO.StadiumDAO;
import db.DBConnection;
import model.Stadium;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class BaseBallApp {

    public static void main(String[] args) {
        Connection connection = DBConnection.getInstance();

        Scanner sc = new Scanner(System.in);
        System.out.print("어떤 기능을 요청하시겠습니까? ");
        String answer = sc.next();

        String want;

        if(answer.indexOf("?")==(-1)){want=answer;}
        else {want = answer.split("\\?")[0];}

        if (want.equals("야구장등록")) {
            StadiumDAO dao = new StadiumDAO(connection);
            dao.create(answer.split("=")[1]);
        } // 야구장등록?name=잠실야구장

        if (want.equals("야구장목록")) {
            StadiumDAO dao = new StadiumDAO(connection);
            List<Stadium> findAllList = dao.findAll();
             for (Stadium stadium : findAllList) {
                 System.out.println(stadium);
             } // 야구장목록
        }

    }
}
