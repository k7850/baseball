package service;

import DAO.PlayerDAO;
import model.DTO.PositionDTO;
import model.Player;
import util.Util;

import java.sql.Connection;
import java.util.List;

public class PlayerService {
    private Connection connection;
    private PlayerDAO dao;

    public PlayerService(Connection connection) {
        this.connection = connection;
        dao = new PlayerDAO(connection);
    }




    public void create(String answer){
        try {
            if (answer.indexOf("?") == -1 || answer.indexOf("=") < 3) {
                throw new IllegalArgumentException();
            }

            if (!(answer.split("=")[0].equals("선수등록?teamId"))) {
                throw new IllegalArgumentException();
            }
            if (answer.split("=")[1].split("&")[0].length()==0) {
                throw new IllegalArgumentException();
            }
            if (!(answer.split("=")[1].split("&")[1].equals("name"))) {
                throw new IllegalArgumentException();
            }
            if (answer.split("=")[2].split("&")[0].length()==0) {
                throw new IllegalArgumentException();
            }
            if (!(answer.split("=")[2].split("&")[1].equals("position"))) {
                throw new IllegalArgumentException();
            }
            if (answer.split("=")[3].length()==0) {
                throw new IllegalArgumentException();
            }

            if (    !(answer.split("=")[3].equals("투수")) &&
                    !(answer.split("=")[3].equals("포수")) &&
                    !(answer.split("=")[3].equals("1루수")) &&
                    !(answer.split("=")[3].equals("2루수")) &&
                    !(answer.split("=")[3].equals("3루수")) &&
                    !(answer.split("=")[3].equals("유격수")) &&
                    !(answer.split("=")[3].equals("좌익수")) &&
                    !(answer.split("=")[3].equals("중견수")) &&
                    !(answer.split("=")[3].equals("우익수"))   ) {
                throw new IllegalArgumentException();
            }


            int a1 = Integer.valueOf(answer.split("=")[1].split("&")[0]);
            String a2 = answer.split("=")[2].split("&")[0];
            String a3 = answer.split("=")[3];


            if (Util.checkString(a2)) {
                throw new IllegalArgumentException();
            }
            if (Util.checkString(a3)) {
                throw new IllegalArgumentException();
            }

            dao.create(a1, a2, a3);

        } catch (Exception e) {
            System.out.println("오류\n선수를 등록하려면 : 선수등록?teamId=[입력]&name=[입력]&position=[입력]");
        }
    }


    public void find(){
        List<Player> list = dao.playerAll();
        for (Player player : list) {
            System.out.println(player);
        }
    }


    public void findWhereTeam(String answer){
        try {
            if (answer.indexOf("?") == -1 || answer.indexOf("=") == -1) {
                throw new IllegalArgumentException();
            }

            if (!(answer.split("=")[0].equals("선수목록?teamId"))) {
                throw new IllegalArgumentException();
            }
            if (answer.split("=")[1].length()==0) {
                throw new IllegalArgumentException();
            }



            int a1 = Integer.valueOf(answer.split("=")[1]);
            List<Player> list = dao.findTeamPlayer(a1);
            for (Player player : list) {
                System.out.println(player);
            }

        } catch (Exception e) {
            System.out.println("오류\n특정 팀 선수 목록을 보려면 : 선수목록?teamId=[입력]");
        }
    }



    public void position(){
        List<PositionDTO> list = dao.positionTeam();

        for (PositionDTO p1 : list) {
            System.out.println(p1);
        }
    }






}