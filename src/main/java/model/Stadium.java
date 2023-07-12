package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Util;

import java.sql.Timestamp;

@Getter @AllArgsConstructor
public class Stadium {
    private Integer stadiumId;
    private String stadiumName;
    private Timestamp stadiumCreatedAt;


    @Override
    public String toString() {
        return "" +
                "구장ID:" + stadiumId +
                ", 구장명:" + stadiumName +
                ", 구장완공일:" + Util.dateFormat(stadiumCreatedAt) +
                "";
    }

}
