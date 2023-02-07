package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        // given : 테스트 대상
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when : 시험 내용
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : 기댓값
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
