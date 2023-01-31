package org.example;

import java.security.Principal;

public class User {
    private String password;

    public String getPassword() {
        return password;
    }

    // if 구문의 조건에 해당할 경우에만, password 로 세팅한다.
    public void initPassword(PasswordGenerator passwordGenerator) {
        // as-is : 강한 결합
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // to-be : 약한 결합
        // RandomPasswordGenerator 를 메소드 내부에서 생성하면 (내부에서 Random~ 를 의존하다 보면) import 구문과 함께 결합을 강하게 만들지만, (테스트하기 어려운 코드)
        // 리팩토링을 통해 인터페이스를 사용함으로써 결합도를 낮춰주었다.  (테스트하기 쉬운 코드)
        String password = passwordGenerator.generatePassword();

        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }


    }
}
