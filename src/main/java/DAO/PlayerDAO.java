package DAO;

import model.Player;
import model.Stadium;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
    private Connection connection;
    public PlayerDAO(Connection connection) { // 생성자
        this.connection = connection;
    }


    public void create(int teamId, String playerName, String playerPosition) {
        System.out.println("선수 추가 시도 : "+teamId+" / "+playerName+" / "+playerPosition);
        String sql = "insert into player_table(team_id, player_name, player_position, player_created_at) values(?, ?, ?, now());";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, teamId);
            pstmt.setString(2, playerName);
            pstmt.setString(3, playerPosition);
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



    public List<Player> findTeamPlayer(int teamId) {
        System.out.println("해당 구단 소속선수 목록 보기 시도");
        List<Player> list = new ArrayList<>();
        String sql = "select * from player_table JOIN team_table ON player_table.team_id = team_table.team_id where player_table.team_id=?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, teamId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Player player = new Player(
                        rs.getInt("player_id"),
                        rs.getInt("team_id"),
                        rs.getString("player_name"),
                        rs.getString("player_position"),
                        rs.getTimestamp("player_created_at")
                );
                list.add(player);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }





}
