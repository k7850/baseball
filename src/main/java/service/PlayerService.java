package service;

import DAO.PlayerDAO;
import model.DTO.PositionDTO;
import model.Player;
import util.Util;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PlayerService implements Service {
    private PlayerDAO dao;

    private PlayerService(Connection connection) {
        dao = new PlayerDAO(connection);
    }

    private static PlayerService instance;

    public static PlayerService getInstance(Connection con){
        if (instance == null) {
            instance = new PlayerService(con);
        }
        return instance;
    }

    @RequestMapping(uri = "선수등록")
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

    @RequestMapping(uri = "모든선수목록")
    public void find(){
        List<Player> list = dao.playerAll();
        for (Player player : list) {
            System.out.println(player);
        }
    }

    @RequestMapping(uri = "선수목록")
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

//            if(list.size()<9 && list.size()>=1){
//                System.out.println("해당 팀 선수가 9명이 아닙니다. 선수를 추가하세요.");
//            }
//            System.out.println(player.getPlayerPosition());
//            String[] check9 = new String[]{"투수","포수","1루수","2루수","3루수","유격수","좌익수","중견수","우익수"};

            ArrayList<String> check9 = new ArrayList<>();
            check9.add("투수");
            check9.add("포수");
            check9.add("1루수");
            check9.add("2루수");
            check9.add("3루수");
            check9.add("유격수");
            check9.add("좌익수");
            check9.add("중견수");
            check9.add("우익수");

            for (Player player : list) {
                String str = player.getPlayerPosition();
                if(check9.contains(str)){
                    check9.remove(str);
                    System.out.println(player);
                }
            }
            if(list.size()<9 && list.size()>=1){
                System.out.println(check9+"가 팀에 없습니다. 선수를 추가하세요.");
            } else if(list.size()==9){
                System.out.println("팀에 선수 9명이 모두 있습니다.");
            }

        } catch (Exception e) {
            System.out.println("오류\n특정 팀 선수 목록을 보려면 : 선수목록?teamId=[입력]");
        }
    }



    @RequestMapping(uri = "포지션별목록")
    public void position(){
        List<PositionDTO> list = dao.positionTeam();

        for (PositionDTO p1 : list) {
            System.out.println(p1);
        }
    }






}
