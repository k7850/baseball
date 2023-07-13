package DAO;

import model.DTO.PositionDTO;
import model.Player;

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
        String sql = "select * from player_table JOIN team_table ON player_table.team_id = team_table.team_id where player_table.team_id=? ORDER BY Field(player_table.player_position, '투수', '포수', '1루수', '2루수', '3루수', '유격수', '좌익수', '중견수', '우익수')";

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



    public List<Player> playerAll() {
        System.out.println("모든 선수 목록 보기 시도");
        List<Player> list = new ArrayList<>();
        String sql = "select * from player_table LEFT JOIN team_table ON player_table.team_id = team_table.team_id ORDER BY player_table.player_id ASC";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
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




    public List<PositionDTO> positionTeam() {
//        System.out.println("포지션별 선수 보기 시도");
        List<PositionDTO> list = new ArrayList<>();
        String sql = "select player_position as position, max(if(team_id = 1, player_name, null)) as name1, max(if(team_id = 2, player_name, null)) as name2, max(if(team_id = 3, player_name, null)) as name3 from player_table group by player_position ORDER BY Field(position, '투수', '포수', '1루수', '2루수', '3루수', '유격수', '좌익수', '중견수', '우익수')";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                PositionDTO positionDTO = new PositionDTO(
                        rs.getString("position"),
                        rs.getString("name1"),
                        rs.getString("name2"),
                        rs.getString("name3")
                );
                list.add(positionDTO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }





}
