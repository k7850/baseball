import DAO.OutDAO;
import DAO.PlayerDAO;
import DAO.StadiumDAO;
import DAO.TeamDAO;
import db.DBConnection;
import model.DTO.OutPlayerDTO;
import model.DTO.TeamAndStadiumDTO;
import model.Player;
import model.Stadium;
import model.Team;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class BaseBallApp {

    public static void main(String[] args) {
        Connection connection = DBConnection.getInstance();
        Scanner sc = new Scanner(System.in);
        String answer = null;

        while (answer == null) {

            System.out.print("어떤 기능을 요청하시겠습니까? 설명을 보려면 '설명'을 입력 ");
            answer = sc.next();


            if (answer.equals("설명")) {
                System.out.println("종료하려면 : 종료");
                System.out.println("야구장을 등록하려면 : 야구장등록?name=[입력]");
                System.out.println("야구장 목록을 보려면 : 야구장목록");
                System.out.println("팀을 등록하려면 : 팀등록?stadiumId=[입력]&name=[입력]");
                System.out.println("팀 목록을 보려면 : 팀목록");
                System.out.println("선수를 등록하려면 : 선수등록?teamId=[입력]&name=[입력]&position=[입력]");
                System.out.println("팀별 선수 목록을 보려면 : 선수목록?teamId=[입력]");
                System.out.println("퇴출 선수를 등록하려면 : 퇴출등록?playerId=[입력]&reason=[입력]");
                System.out.println("퇴출 선수 목록을 보려면 : 퇴출목록");
            }


            String want;

            if (answer.indexOf("?") == (-1)) {
                want = answer;
            } // 물음표가 없으면 입력 전체를 want
            else {
                want = answer.split("\\?")[0];
            } // 물음표가 있으면 물음표보다 앞부분을 want


            // 3.1 야구장 등록
            // 요청 : 야구장등록?name=잠실야구장
            // 응답 : 성공이라는 메시지를 출력한다.
            if (want.equals("야구장등록")) {
                StadiumDAO dao = new StadiumDAO(connection);
                dao.create(answer.split("=")[1]);
            }


            // 3.2 전체 야구장 목록보기
            // 요청 : 야구장목록
            // 응답 : 야구장 목록은 Model -> Stadium을 List에 담아서 출력한다.
            if (want.equals("야구장목록")) {
                StadiumDAO dao = new StadiumDAO(connection);
                List<Stadium> findAllList = dao.findAll();
                for (Stadium stadium : findAllList) {
                    System.out.println(stadium);
                }
            }


            // 3.3 팀 등록
            // 요청 : 팀등록?stadiumId=1&name=NC
            // 응답 : 성공이라는 메시지를 출력한다.
            if (want.equals("팀등록")) {
                TeamDAO dao = new TeamDAO(connection);
                dao.create(Integer.valueOf(answer.split("=")[1].split("&")[0]), answer.split("=")[2]);
            }


            // 팀목록만
            // 팀목록 기본 (스타디움 조인 없음)
            if (want.equals("팀목록만")) {
                TeamDAO dao = new TeamDAO(connection);
                List<Team> findAllList = dao.findAll();
                for (Team team : findAllList) {
                    System.out.println(team);
                }
            }


            // 3.4 전체 팀 목록
            // 요청 : 팀목록
            // 응답 : 팀 목록은 Stadium 정보를 조인해서 출력해야 된다. TeamRespDTO가 필요하다.
            if (want.equals("팀목록")) {
                TeamDAO dao = new TeamDAO(connection);
                List<TeamAndStadiumDTO> findAllJoinStadiumList = dao.findAllJoinStadium();
                for (TeamAndStadiumDTO t1 : findAllJoinStadiumList) {
                    System.out.println(t1);
                }
            }


            // 3.5 선수 등록
            // 요청 : 선수등록?teamId=1&name=이대호&position=1루수
            // 응답 : 성공이라는 메시지를 출력한다.
            if (want.equals("선수등록")) {
                PlayerDAO dao = new PlayerDAO(connection);
                dao.create(Integer.valueOf(answer.split("=")[1].split("&")[0]), answer.split("=")[2].split("&")[0], answer.split("=")[3]);
            }


            // 3.6 팀별 선수 목록
            // 요청 : 선수목록?teamId=1
            // 응답 : 선수 목록은 Model -> Player를 List에 담아서 출력한다. (team_id는 출력하지 않아도 된다)
            if (want.equals("선수목록")) {
                PlayerDAO dao = new PlayerDAO(connection);
                List<Player> list = dao.findTeamPlayer(Integer.valueOf(answer.split("=")[1]));
                for (Player player : list) {
                    System.out.println(player);
                }
            }


            // 3.7 선수 퇴출 등록
            // 요청 : 퇴출등록?playerId=1&reason=도박
            // 응답 : 성공이라는 메시지를 출력합니다
            if (want.equals("퇴출등록")) {
                OutDAO dao = new OutDAO(connection);
                dao.create(Integer.valueOf(answer.split("=")[1].split("&")[0]), answer.split("=")[2]);
                dao.create2(Integer.valueOf(answer.split("=")[1].split("&")[0]));
            }


            // 3.8 선수 퇴출 목록
            // 요청 : 퇴출목록
            // 응답 : OutPlayerRespDTO에 담아서 출력합니다
            if (want.equals("퇴출목록")) {
                OutDAO dao = new OutDAO(connection);
                List<OutPlayerDTO> list = dao.findOutPlayer();
                for (OutPlayerDTO t1 : list) {
                    System.out.println(t1);
                }
            }


            // 3.10 포지션별 팀 야구 선수 페이지
            // 요청 : 포지션별목록
            // 응답 : PositionRespDto 에 값을 담아서 콘솔에 출력합니다.




            if (!answer.equals("종료")) {
                answer = null;
            }

        }


        System.out.println("프로그램 종료");
    }
}