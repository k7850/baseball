package DAO;

import model.DTO.TeamAndStadiumDTO;
import model.Stadium;
import model.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {
    private Connection connection;
    public TeamDAO(Connection connection) { // 생성자
        this.connection = connection;
    }

    public void create(int stadiumId, String teamName) {
        System.out.println("구단 생성 시도 : "+stadiumId+" / "+teamName);
        String sql = "insert into team_table(stadium_id, team_name, team_created_at) values(?, ?, now())";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, stadiumId);
            pstmt.setString(2, teamName);
            int result = pstmt.executeUpdate();
            if(result==1) {
                System.out.println("성공");
            }
        } catch (Exception e) {
            System.out.println("실패");
        } finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
        }
    }

    public List<Team> findAll() {
        List<Team> list = new ArrayList<>();
        String sql = "select * from team_table";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Team team = new Team(
                        rs.getInt("team_id"),
                        rs.getInt("stadium_id"),
                        rs.getString("team_name"),
                        rs.getTimestamp("team_created_at")
                );
                list.add(team);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public List<TeamAndStadiumDTO> findAllJoinStadium() {
        System.out.println("전체 구단 목록 보기 시도");
        List<TeamAndStadiumDTO> list = new ArrayList<>();

        String sql = "select * from team_table join stadium_table on team_table.stadium_id = stadium_table.stadium_id";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Team team = new Team(
                        rs.getInt("team_id"),
                        rs.getInt("stadium_id"),
                        rs.getString("team_name"),
                        rs.getTimestamp("team_created_at")
                );
                Stadium stadium = new Stadium(
                        rs.getInt("stadium_id"),
                        rs.getString("stadium_name"),
                        rs.getTimestamp("stadium_created_at")
                );
                list.add(new TeamAndStadiumDTO(team,stadium));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }


}
