package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 구현 객체를 MemoryMemberRepository 로 선택해주자
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
