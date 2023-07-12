package model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.Player;
import util.Util;

import java.sql.Timestamp;

@Getter @AllArgsConstructor
public class OutPlayerDTO {
    private Player player;

    private String outReason;
    private Timestamp outCreatedAt;

    @Override
    public String toString() {
        String string;

        string = player.toString();
        if(!(outReason==null)){string = string + ", 퇴출이유:" + outReason;}
        if(!(outCreatedAt==null)){string = string + ", 퇴출일:" + Util.dateFormat(outCreatedAt);}

        return string;
    }
}



//    @Override
//    public String toString() {
//        return "" +
//                player +
//                ", 퇴출이유:" + outReason +
//                ", 퇴출일:" + Util.dateFormat(outCreatedAt) +
//                "";
//    }