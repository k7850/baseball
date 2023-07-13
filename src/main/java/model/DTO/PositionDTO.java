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

        String str= position + " : ";

        if(name1==null){str=str+"없음"+"    ";}
        else{str=str+name1+"  ";}
        if(name2==null){str=str+"없음"+"    ";}
        else{str=str+name2+"  ";}
        if(name3==null){str=str+"없음"+"    ";}
        else{str=str+name3+"  ";}


        return str;
    }
}
