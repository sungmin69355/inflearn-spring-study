package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    //생성자로 주입시 final 키워드를 사용가능
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //인터페이스만 의존하게 만든다.


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //discountPolicy 에서 책임과 역할을 잘 분리해놓았기 떄문에 할인 정책이 바뀌어도 order 부분을 고칠 필요가 없다.
        //discountPolicy에 member 등급만 넘겨줘도 되는데 미래 확장성을 위해 member 객체 그대로 넘겨준다.(선택)
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
