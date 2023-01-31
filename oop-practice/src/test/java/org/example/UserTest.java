package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest() {
        // given
        User user = new User();

        // when
        user.initPassword(new CorrectFixedPasswordGenerator());

        // then
        // 테스트가 실패할 때도 있고, 성공할 때도 있다.
        // Why??  User 의 initPassword() 내부의 RandomPasswordGenerator 가 어떻게 동작하는지 해당 메서드 내부에서는 컨트롤 할 수 없기 때문
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() {
        // given
        User user = new User();

        // when
        user.initPassword(new WrongFixedPasswordGenerator());

        // then
        // 테스트가 실패할 때도 있고, 성공할 때도 있다.
        // Why??  User 의 initPassword() 내부의 RandomPasswordGenerator 가 어떻게 동작하는지 해당 메서드 내부에서는 컨트롤 할 수 없기 때문
        assertThat(user.getPassword()).isNull();
    }
}