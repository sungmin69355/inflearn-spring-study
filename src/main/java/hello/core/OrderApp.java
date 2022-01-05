package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSerivce;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberSerivce memberSerivce = appConfig.memberSerivce();
//        MemberSerivce memberSerivce = new MemberSerivceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberSerivce.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);


    }
}
