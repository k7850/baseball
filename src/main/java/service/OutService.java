package service;

import DAO.OutDAO;
import model.DTO.OutPlayerDTO;
import model.Out;
import util.Util;

import java.sql.Connection;
import java.util.List;

public class OutService implements Service {
    private OutDAO dao;

    private OutService(Connection connection) {
        dao = new OutDAO(connection);
    }

    private static OutService instance;
    public static OutService getInstance(Connection con){
        if (instance == null) {
            instance = new OutService(con);
        }
        return instance;
    }



    @RequestMapping(uri = "퇴출등록")
    public void create(String answer){
        try {
            if (answer.indexOf("?") == -1 || answer.indexOf("=") < 3) {
                throw new IllegalArgumentException();
            }

            if (!(answer.split("=")[0].equals("퇴출등록?playerId"))) {
                throw new IllegalArgumentException();
            }
            if (answer.split("=")[1].split("&")[0].length()==0) {
                throw new IllegalArgumentException();
            }
            if (!(answer.split("=")[1].split("&")[1].equals("reason"))) {
                throw new IllegalArgumentException();
            }
            if (answer.split("=")[2].length()==0) {
                throw new IllegalArgumentException();
            }

            int a1=Integer.valueOf(answer.split("=")[1].split("&")[0]);
            String a2=answer.split("=")[2];

            if (Util.checkString(a2)) {
                throw new IllegalArgumentException();
            }
            dao.create(a1, a2);
            dao.outTeam(a1);

        } catch (Exception e) {
            System.out.println("오류\n퇴출 선수를 등록하려면 : 퇴출등록?playerId=[입력]&reason=[입력]");
        }
    }



    @RequestMapping(uri = "퇴출목록")
    public void find(){
        List<OutPlayerDTO> list = dao.findOutPlayer();
        for (OutPlayerDTO dto : list) {
            System.out.println(dto);
        }
    }



    @RequestMapping(uri = "퇴출목록만")
    public void findOnlyOut(){
        List<Out> list = dao.findOnlyOut();
        for (Out out : list) {
            System.out.println(out);
        }
    }






}
