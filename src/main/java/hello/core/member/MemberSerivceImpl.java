package hello.core.member;

public class MemberSerivceImpl implements MemberSerivce{

    //NullPointerException을 방지하기 위해 MemoryMemberRepository를 할당해준다.
    // 생성자를 통해 할당해준다.(AppConfig에서 생성자 주입)
    private final MemberRepository memberRepository;

    public MemberSerivceImpl(MemberRepository memberRepository) {
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
