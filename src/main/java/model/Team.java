package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter @ToString @AllArgsConstructor
public class Team {
    private Integer teamId;
    private Integer stadiumId;
    private String teamName;
    private Timestamp teamCreatedAt;
}
