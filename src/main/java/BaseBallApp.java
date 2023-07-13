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

            try {
                FindUri.findUri(stadiumService, answer);
                FindUri.findUri(teamService, answer);
                FindUri.findUri(playerService, answer);
                FindUri.findUri(outService, answer);
            } catch (Exception e) {
                System.out.println("finduri오류");
            }

            if (!answer.equals("종료")) {
                answer = "반복";
            }
        }
        sc.close();
        System.out.println("프로그램 종료");
    }
}