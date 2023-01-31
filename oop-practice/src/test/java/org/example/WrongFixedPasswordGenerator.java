package org.example;

// 테스트를 위해 생성한 PasswordGenerator 의 구현체
public class WrongFixedPasswordGenerator implements PasswordGenerator{
    @Override
    public String generatePassword() {
        return "ab";    // 8 글자의 비밀번호를 생성
    }
}
