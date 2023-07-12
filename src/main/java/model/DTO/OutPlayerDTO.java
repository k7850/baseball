package model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import model.Player;

import java.sql.Timestamp;

@Getter @ToString @AllArgsConstructor
public class OutPlayerDTO {
    private Player player;

    private String outReason;
    private Timestamp outCreatedAt;

}
