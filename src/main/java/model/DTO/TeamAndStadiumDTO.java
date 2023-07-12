package model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import model.Stadium;
import model.Team;

@Getter @ToString @AllArgsConstructor
public class TeamAndStadiumDTO {
    private Team team;
    private Stadium stadium;
}
