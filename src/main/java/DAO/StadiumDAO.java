package DAO;

import model.Stadium;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StadiumDAO {
    private Connection connection;
    public StadiumDAO(Connection connection) { // 생성자
        this.connection = connection;
    }

    public void create(String stadiumName) {
        System.out.println("야구장 생성 시도 : "+stadiumName);
        String sql = "insert into stadium_table(`stadium_name`, `stadium_created_at`) values(?, now())";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, stadiumName);
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

    public List<Stadium> findAll() {
        System.out.println("전체 야구장 목록 보기 시도");
        List<Stadium> list = new ArrayList<>();
        String sql = "select * from stadium_table";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Stadium stadium = new Stadium(
                        rs.getInt("stadium_id"),
                        rs.getString("stadium_name"),
                        rs.getTimestamp("stadium_created_at")
                );
                list.add(stadium);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }




}
