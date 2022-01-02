package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberSerivce memberSerivce = new MemberSerivceImpl();

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
