package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    // 회원, 금액 -> 할인 금액 반환
    int discount(Member member, int price);
}
