package model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class PositionDTO {
    private String position;
    private String name1;
    private String name2;
    private String name3;

    @Override
    public String toString() {
        return
                "" + position +
                " : " + name1 +
                ", " + name2 +
                ", " + name3 +
                "";
    }
}
