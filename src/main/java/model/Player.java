package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter @ToString @AllArgsConstructor
public class Player {
    private Integer playerId;
    private Integer teamId;
    private String playerName;
    private String playerPosition;
    private Timestamp playerCreatedAt;
}
