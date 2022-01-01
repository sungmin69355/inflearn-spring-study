package hello.core.member;

public class MemberSerivceImpl implements MemberSerivce{

    //NullPointerException을 방지하기 위해 MemoryMemberRepository를 할당해준다.
    // 아직 어떤 DB를 사용할지 모르기때문에 메모리레파지토리를 연결해놓는다. 나중에 이것만 교체하면된다.!
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findeMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
