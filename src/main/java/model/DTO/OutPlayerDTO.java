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
        String str;

        str = player.toString();
        if (!(outReason == null)) {
            str = str + "   퇴출이유:" + outReason + "  퇴출일:" + Util.dateFormat(outCreatedAt);
        } else {
            str = str + "   퇴출이유: -    퇴출일: -";
        }

        return str;
        }
    }