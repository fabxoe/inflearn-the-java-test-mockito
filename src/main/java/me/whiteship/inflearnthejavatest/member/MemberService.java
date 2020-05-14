package me.whiteship.inflearnthejavatest.member;

import me.whiteship.inflearnthejavatest.domain.Member;

import java.util.Optional;

public interface MemberService {
//    void validate(Long memberId) throws InvalidMemberException;

    Optional<Member> findById(Long memberId);
}
