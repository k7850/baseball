package service;

import DAO.TeamDAO;
import model.DTO.TeamAndStadiumDTO;
import model.Team;
import util.Util;

import java.sql.Connection;
import java.util.List;

public class TeamService {
    private Connection connection;
    private TeamDAO dao;

    private TeamService(Connection connection) {
        this.connection = connection;
        dao = new TeamDAO(connection);
    }


    private static TeamService instance;
    public static TeamService getInstance(Connection con){
        if (instance == null) {
            instance = new TeamService(con);
        }
        return instance;
    }


    public void create(String answer) {
        try {
            if (answer.indexOf("?") == -1 || answer.indexOf("=") < 2) {
                throw new IllegalArgumentException();
            }

            if (!(answer.split("=")[0].equals("팀등록?stadiumId"))) {
                throw new IllegalArgumentException();
            }
            if (answer.split("=")[1].split("&")[0].length() == 0) {
                throw new IllegalArgumentException();
            }
            if (!(answer.split("=")[1].split("&")[1].equals("name"))) {
                throw new IllegalArgumentException();
            }
            if (answer.split("=")[2].length() == 0) {
                throw new IllegalArgumentException();
            }

            int a1 = Integer.valueOf(answer.split("=")[1].split("&")[0]);
            String a2 = answer.split("=")[2];

            if (Util.checkString(a2)) {
                throw new IllegalArgumentException();
            }

            dao.create(a1, a2);

        } catch (Exception e) {
            System.out.println("오류\n팀을 등록하려면 : 팀등록?stadiumId=[입력]&name=[입력]");
        }
    }

    public void find() {
        List<Team> findAllList = dao.findAll();
        for (Team team : findAllList) {
            System.out.println(team);
        }
    }

    public void findAndStadium() {
        List<TeamAndStadiumDTO> findAllJoinStadiumList = dao.findAllJoinStadium();
        for (TeamAndStadiumDTO t1 : findAllJoinStadiumList) {
            System.out.println(t1);
        }
    }


    public void teamAndPosition() {
        List<Team> findAllList = dao.findAll();
        for (Team team : findAllList) {
            System.out.print("  " + team.getTeamName());
        }
        System.out.println();
    }


}
