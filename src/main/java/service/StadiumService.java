package service;

import DAO.StadiumDAO;
import model.Stadium;

import java.sql.Connection;
import java.util.List;

public class StadiumService {
    private Connection connection;
    private StadiumDAO dao;



    public StadiumService(Connection connection) {
        this.connection = connection;
        dao = new StadiumDAO(connection);
    }


    public void create(String answer){
            String a = answer.split("=")[1];
            dao.create(a);
    } // 야구장등록?name=잠실야구장


    public void find(){
        List<Stadium> findAllList = dao.findAll();
        for (Stadium stadium : findAllList) {
            System.out.println(stadium);
        }
    }




}
