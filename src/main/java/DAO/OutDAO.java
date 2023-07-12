package DAO;

import model.DTO.OutPlayerDTO;
import model.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OutDAO {
    private Connection connection;
    public OutDAO(Connection connection) { // 생성자
        this.connection = connection;
    }



    public void create(int playerId, String outReason) {
        System.out.println("퇴출 목록 등록 : "+playerId+" / "+outReason);
        String sql = "insert into out_table(player_id, out_reason, out_created_at) values(?, ?, now())";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, playerId);
            pstmt.setString(2, outReason);
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

    public void create2(int playerId) {
        System.out.println("팀에서 선수 방출 : "+playerId);
        String sql = "update player_table set team_id = null where player_id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, playerId);
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




    public List<OutPlayerDTO> findOutPlayer() {
        System.out.println("퇴출 목록 보기");
        List<OutPlayerDTO> list = new ArrayList<>();

        String sql = "SELECT player_table.*, out_table.out_reason, out_table.out_created_at  FROM player_table LEFT JOIN out_table ON player_table.player_id = out_table.player_id ORDER BY out_table.out_id DESC";

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
                String outReason = rs.getString("out_reason");
                Timestamp outCreatedAt = rs.getTimestamp("out_created_at");
                list.add(new OutPlayerDTO(player, outReason, outCreatedAt));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }




}
