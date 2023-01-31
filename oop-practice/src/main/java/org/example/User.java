package org.example;

import java.security.Principal;

public class User {
    private String password;

    public String getPassword() {
        return password;
    }

    // if 구문의 조건에 해당할 경우에만, password 로 세팅한다.
    public void initPassword(PasswordGenerator passwordGenerator) {
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String password = passwordGenerator.generatePassword();

        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }


    }
}
