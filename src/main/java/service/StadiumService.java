package service;

import DAO.StadiumDAO;
import model.Stadium;
import util.Util;

import java.sql.Connection;
import java.util.List;

public class StadiumService {
    private Connection connection;
    private StadiumDAO dao;


    public StadiumService(Connection connection) {
        this.connection = connection;
        dao = new StadiumDAO(connection);
    }


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


    public void find() {
        List<Stadium> findAllList = dao.findAll();
        for (Stadium stadium : findAllList) {
            System.out.println(stadium);
        }
    }


}
