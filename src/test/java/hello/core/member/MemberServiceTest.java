package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberSerivce memberSerivce;

    //테스트가 돌기전에 실행하는 메소드
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberSerivce = appConfig.memberSerivce();
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberSerivce.join(member);
        Member findMember = memberSerivce.findeMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
