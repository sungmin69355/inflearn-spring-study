package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class MemberServiceImpl implements MemberService {

    //NullPointerException을 방지하기 위해 MemoryMemberRepository를 할당해준다.
    // 생성자를 통해 할당해준다.(AppConfig에서 생성자 주입)
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findeMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
