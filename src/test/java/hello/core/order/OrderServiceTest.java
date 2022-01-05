package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSerivce;
import hello.core.member.MemberSerivceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberSerivce memberSerivce;
    OrderService orderService;
    //테스트가 돌기전에 실행하는 메소드
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberSerivce = appConfig.memberSerivce();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        //given
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        memberSerivce.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
