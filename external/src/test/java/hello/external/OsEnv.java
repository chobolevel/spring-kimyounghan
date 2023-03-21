package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class OsEnv {

    public static void main(String[] args) {
        Map<String, String> envMap = System.getenv();
        for (String key : envMap.keySet()) {
            log.info("env {}={}", key, System.getenv(key));
        }
        // 개발서버 DB_URL= dev.db.com
        // 운영서버 DB_URL = prod.db.com
        // System.getenv("DB_URL"); 로 호출해서 사용
    }

}


