package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy  = new FixDiscountPolicy(); //고정 할인 정책
    private final DiscountPolicy discountPolicy  = new RateDiscountPolicy(); //퍼센트 할인 정책으로 바꾸면 OCP위반


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //discountPolicy 에서 책임과 역할을 잘 분리해놓았기 떄문에 할인 정책이 바뀌어도 order 부분을 고칠 필요가 없다.
        //discountPolicy에 member 등급만 넘겨줘도 되는데 미래 확장성을 위해 member 객체 그대로 넘겨준다.(선택)
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
