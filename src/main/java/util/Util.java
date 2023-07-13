package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Util {

    public static String dateFormat(Timestamp transferDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String formattedDate = dateFormat.format(transferDate);
        return formattedDate;
    }

    public static Boolean checkString(String str) {
        String pattern = "^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*$";
        if (!Pattern.matches(pattern, str)) {
            return true;
        } else {
            return false;
        }
    }

    public static void help(){
        System.out.println("**********************************");
        System.out.println("종료하려면 : 종료");
        System.out.println("야구장을 등록하려면 : 야구장등록?name=[입력]");
        System.out.println("야구장 목록을 보려면 : 야구장목록");
        System.out.println("팀을 등록하려면 : 팀등록?stadiumId=[입력]&name=[입력]");
        System.out.println("팀 목록을 보려면 : 팀목록");
        System.out.println("선수를 등록하려면 : 선수등록?teamId=[입력]&name=[입력]&position=[입력]");
        System.out.println("전체 선수 목록을 보려면 : 모든선수목록");
        System.out.println("특정 팀 선수 목록을 보려면 : 선수목록?teamId=[입력]");
        System.out.println("퇴출 선수를 등록하려면 : 퇴출등록?playerId=[입력]&reason=[입력]");
        System.out.println("퇴출 선수 목록만 보려면 : 퇴출목록만");
        System.out.println("모든 선수 중 퇴출 선수 목록을 보려면 : 퇴출목록");
        System.out.println("포지션별 각 팀 선수를 보려면 : 포지션별목록");
        System.out.println("**********************************");
    }

}
