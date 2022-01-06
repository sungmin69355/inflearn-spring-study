package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberSerivce;
import hello.core.member.MemberSerivceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    //설정을 여기서! DI(생성자 주입)
    //역할을 분명하게! 보이도록 리팩토링 기존 코드에는 명확하게 보이지 않았다.
    public MemberSerivce memberSerivce(){
        return new MemberSerivceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    //discountPolicy는 FixDiscountPolicy를 쓸것이 분명하게 나타남.
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
