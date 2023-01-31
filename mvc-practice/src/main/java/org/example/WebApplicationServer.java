package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class WebApplicationServer {

    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);

    // main 메서드 실행시 -> 톰캣 실행
    public static void main(String[] args) throws Exception {
        // main 메서드를 실행했을 때, Embed tomcat 이 실행되기 위한 코드 작성
        String webappDirLocation = "webapps/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);   // 포트 설정

        // 루트 uri로 접근했을 때, webappDirLocation(webapps/)를 바라보겠다는 설정
        // 즉, webapps 디렉토리를 루트 디렉토리로 보고, 해당 디렉토리의 하위 디렉토리에서 필요한 파일을 찾아 톰켓이 실행하겠다는(동작을 한다는) 의미
        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        log.info("configuring app with basedir: {}", new File("./" + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}

// 톰캣이 실행되면, webapps 하위에 빌드된 WebApplicationServer 파일이 생성된다.
// "루트 디렉토리 > WEB_INF > classes 하위에서 필요한 파일을 찾는것"은 톰캣의 규약이다. 즉, 해당 경로에 빌드된 파일이 없다면 톰캣을 실행할 수 없다.