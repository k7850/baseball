package util;

import service.RequestMapping;
import service.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class FindUri {

    public static void findUri(Service service, String want, String answer) throws Exception {
        Method[] methods = service.getClass().getDeclaredMethods();
        // 매서드배열 methods = uc객체의 클래스의 선언된메서드 배열

        for (Method mt : methods) {
            Annotation anno = mt.getDeclaredAnnotation(RequestMapping.class);
            // 어노테이션 anno = 메서드에 선언된 RequestMapping어노테이션
            RequestMapping rm = (RequestMapping) anno;
            // 가져온 어노테이션을 RequestMapping 타입으로 형변환
            if (anno!=null) {
                if (rm.uri().equals(want)) {
                    if(mt.getParameterTypes().length==0){
                        mt.invoke(service);
                    }else {
                        mt.invoke(service, answer);
                    }
                }
            }
        }
    }
}
