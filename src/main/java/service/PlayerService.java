package service;

import DAO.PlayerDAO;
import model.Player;

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
        int a1 = Integer.valueOf(answer.split("=")[1].split("&")[0]);
        String a2 = answer.split("=")[2].split("&")[0];
        String a3 = answer.split("=")[3];
        dao.create(a1, a2, a3);
    }


    public void find(){
        List<Player> list = dao.PlayerAll();
        for (Player player : list) {
            System.out.println(player);
        }
    }


    public void findWhereTeam(String answer){
        int a1 = Integer.valueOf(answer.split("=")[1]);
        List<Player> list = dao.findTeamPlayer(a1);
        for (Player player : list) {
            System.out.println(player);
        }
    }







}
