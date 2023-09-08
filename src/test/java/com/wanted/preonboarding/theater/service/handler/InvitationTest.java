package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.exception.TheaterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class InvitationTest {

    @Test
    @DisplayName("초대권을 사용하면 사용한 초대권이된다.")
    void givenInvitationWhenCallModifyUsedThenModifyUsedChangedToTrue() {
        Invitation target = new Invitation(LocalDateTime.now().plusDays(1), false);
        assertThat(target.isUsed()).isEqualTo(false);
        target.modifyUsed();
        assertThat(target.isUsed()).isEqualTo(true);
    }


    @Test
    @DisplayName("이미 사용한 초대권을 검증하면 에러를 반환한다.")
    public void givenAlreadyUsedInvitationWhenCallVerifyThenReturnTheaterException() throws Exception {
        Invitation target = new Invitation(LocalDateTime.now().plusDays(1), true);
        assertThatThrownBy(target::verifyInvitation).isExactlyInstanceOf(TheaterException.class);
    }

    @Test
    @DisplayName("사용기한이 지난 초대권을 검증하면 에러를 반환한다.")
    public void givenExpiredInvitationWhenCallVerifyThenReturnTheaterException() throws Exception {
        Invitation target = new Invitation(LocalDateTime.now().minusDays(1), false);
        assertThatThrownBy(target::verifyInvitation).isExactlyInstanceOf(TheaterException.class);
    }

    @Test
    @DisplayName("사용하지 않고, 사용기한도 지나지 않은 초대권을 검증하면 성공한다.")
    void givenInvitationWhenCallVerifyThenReturnSuccess() {
        Invitation target = new Invitation(LocalDateTime.now().plusDays(1), false);
        assertThatCode(target::verifyInvitation).doesNotThrowAnyException();
    }
}