import service.*;
import db.DBConnection;
import util.FindUri;
import util.Util;

import java.sql.Connection;
import java.util.Scanner;

public class BaseBallApp {

    public static void main(String[] args) {
        Connection connection = DBConnection.getInstance();
        Scanner sc = new Scanner(System.in);

        StadiumService stadiumService = StadiumService.getInstance(connection);
        TeamService teamService = TeamService.getInstance(connection);
        PlayerService playerService = PlayerService.getInstance(connection);
        OutService outService = OutService.getInstance(connection);

        String answer = "반복";

        while (answer.equals("반복")) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep오류");
            }


            System.out.print("어떤 기능을 요청하시겠습니까? 설명을 보려면 '설명'을 입력 ");
            answer = sc.next();

            if (answer.equals("설명")) {
                Util.help();
            }

            String want;
            if (answer.indexOf("?") == (-1)) {
                want = answer;
            } // 물음표가 없으면 입력 전체를 want
            else {
                want = answer.split("\\?")[0];
            } // 물음표가 있으면 물음표보다 앞부분을 want

            
            try {
                FindUri.findUri(stadiumService, want, answer);
                FindUri.findUri(teamService, want, answer);
                FindUri.findUri(playerService, want, answer);
                FindUri.findUri(outService, want, answer);
            } catch (Exception e) {
                System.out.println("finduri오류");
            }


            if (!answer.equals("종료")) {
                answer = "반복";
            }
        }
        System.out.println("프로그램 종료");
    }
}