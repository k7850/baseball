package service;

import DAO.TeamDAO;
import model.DTO.TeamAndStadiumDTO;
import model.Team;

import java.sql.Connection;
import java.util.List;

public class TeamService {
    private Connection connection;
    private TeamDAO dao;

    public TeamService(Connection connection) {
        this.connection = connection;
        dao = new TeamDAO(connection);
    }


    public void create(String answer){
        int a1 = Integer.valueOf(answer.split("=")[1].split("&")[0]);
        String a2 = answer.split("=")[2];
        dao.create(a1, a2);
    }

    public void find(){
        List<Team> findAllList = dao.findAll();
        for (Team team : findAllList) {
            System.out.println(team);
        }
    }

    public void findAndStadium(){
        List<TeamAndStadiumDTO> findAllJoinStadiumList = dao.findAllJoinStadium();
        for (TeamAndStadiumDTO t1 : findAllJoinStadiumList) {
            System.out.println(t1);
        }
    }

}
