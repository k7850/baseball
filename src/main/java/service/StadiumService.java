package service;

import DAO.StadiumDAO;
import model.Stadium;
import util.Util;

import java.sql.Connection;
import java.util.List;

public class StadiumService implements Service {
    private StadiumDAO dao;

    private StadiumService(Connection connection) {
        dao = new StadiumDAO(connection);
    }

    private static StadiumService instance;

    public static StadiumService getInstance(Connection con){
        if (instance == null) {
            instance = new StadiumService(con);
        }
        return instance;
    }



    @RequestMapping(uri = "야구장등록")
    public void create(String answer) {

        try {
            if (answer.indexOf("?") == -1 || answer.indexOf("=") == -1) {
                throw new IllegalArgumentException();
            }

            if (!(answer.split("=")[0].equals("야구장등록?name"))) {
                throw new IllegalArgumentException();
            }
            if (answer.split("=")[1].length() == 0) {
                throw new IllegalArgumentException();
            }

            String a = answer.split("=")[1];


            if (Util.checkString(a)) {
                throw new IllegalArgumentException();
            }

            dao.create(a);

        } catch (Exception e) {
            System.out.println("오류\n야구장을 등록하려면 : 야구장등록?name=[입력]");
        }

    }

    @RequestMapping(uri = "야구장목록")
    public void find() {
        List<Stadium> findAllList = dao.findAll();
        for (Stadium stadium : findAllList) {
            System.out.println(stadium);
        }
    }


}
