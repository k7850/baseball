package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Util;

import java.sql.Timestamp;

@Getter @AllArgsConstructor
public class Team {
    private Integer teamId;
    private Integer stadiumId;
    private String teamName;
    private Timestamp teamCreatedAt;


    @Override
//    public String toString() {
//        return "" +
//                "팀ID:" + teamId +
//                ", 구장ID:" + stadiumId +
//                ", 팀명:" + teamName +
//                ", 팀창단일=" + Util.dateFormat(teamCreatedAt) +
//                "";
//    }
    public String toString() {
        return String.format("팀ID:%-3s 구장ID:%-3s 팀명:%-8s 팀창단일:%s", teamId, stadiumId, teamName, Util.dateFormat(teamCreatedAt));
    }
}
