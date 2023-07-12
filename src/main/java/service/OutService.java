package service;

import DAO.OutDAO;
import model.DTO.OutPlayerDTO;
import model.Out;

import java.sql.Connection;
import java.util.List;

public class OutService {
    private Connection connection;
    private OutDAO dao;

    public OutService(Connection connection) {
        this.connection = connection;
        dao = new OutDAO(connection);
    }


    public void create(String answer){
        int a1=Integer.valueOf(answer.split("=")[1].split("&")[0]);
        String a2=answer.split("=")[2];
        dao.create(a1, a2);
        dao.outTeam(a1);
    }



    public void find(){
        List<OutPlayerDTO> list = dao.findOutPlayer();
        for (OutPlayerDTO dto : list) {
            System.out.println(dto);
        }
    }



    public void findOnlyOut(){
        List<Out> list = dao.findOnlyOut();
        for (Out out : list) {
            System.out.println(out);
        }
    }






}
