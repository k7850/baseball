package model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.Stadium;
import model.Team;

@Getter @AllArgsConstructor
public class TeamAndStadiumDTO {
    private Team team;
    private Stadium stadium;


    @Override
    public String toString() {
        return "" +
                "" + team +
                ", " + stadium +
                "";
    }
}
