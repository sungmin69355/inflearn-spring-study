package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberSerivce;
import hello.core.member.MemberSerivceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    //설정을 여기서! DI(생성자 주입)
    public MemberSerivce memberSerivce(){
        return new MemberSerivceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
