package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy{
    private  int discountPercent = 10;

    @Override
    public int discount(Member member, int price) { //command+shift+F 테스트코드 자동생성
        if(member.getGrade() == Grade.VIP){
            return price* discountPercent /100;
        }else{
            return 0;
        }
    }
}
