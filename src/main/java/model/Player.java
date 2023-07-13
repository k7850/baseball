package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Util;

import java.sql.Timestamp;

@Getter @AllArgsConstructor
public class Player {
    private Integer playerId;
    private Integer teamId;
    private String playerName;
    private String playerPosition;
    private Timestamp playerCreatedAt;

    @Override
//    public String toString() {
//        return "" +
//                "선수ID:" + playerId +
//                ", 팀ID:" + teamId +
//                ", 이름:" + playerName +
//                ", 포지션:" + playerPosition +
//                ", 선수시작일:" + Util.dateFormat(playerCreatedAt) +
//                "";
//    }
    public String toString() {
        return String.format("선수ID:%-3s 팀ID:%-3s 이름:%-6s 포지션:%-6s 선수시작일:%s", playerId, teamId, playerName, playerPosition, Util.dateFormat(playerCreatedAt));
    }


}
