package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OutDAO {
    private Connection connection;
    public OutDAO(Connection connection) { // 생성자
        this.connection = connection;
    }



    public void create(int playerId, String outReason) {
        System.out.println("선수 퇴출 시도 : "+playerId+" / "+outReason);
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


}
