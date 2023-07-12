package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Util;

import java.sql.Timestamp;

@Getter @AllArgsConstructor
public class Out {
    private Integer outId;
    private Integer playerId;
    private String outReason;
    private Timestamp outCreatedAt;


    @Override
    public String toString() {
        return "" +
                "퇴출ID:" + outId +
                ", 선수ID:" + playerId +
                ", 퇴출이유:" + outReason +
                ", 퇴출일:" + Util.dateFormat(outCreatedAt) +
                "";
    }
}
