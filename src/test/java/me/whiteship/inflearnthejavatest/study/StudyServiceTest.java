package me.whiteship.inflearnthejavatest.study;

import me.whiteship.inflearnthejavatest.domain.Member;
import me.whiteship.inflearnthejavatest.domain.Study;
import me.whiteship.inflearnthejavatest.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Test
    void createStudyService(@Mock MemberService memberService, @Mock StudyRepository studyRepository) {
        Optional<Member> optional = memberService.findById(1L);
//        memberService.validate(2L);//Mock의 리턴 타입이 void인 메서드에 대한 테스트는 아무런 일도 발생하지 않는다.
//        assertNull(optional);

        StudyService studyService = new StudyService(memberService, studyRepository);//setter에 사용하거나 필드에 직접 써도 되지만 여기선 생성자에 사용하였다.
        assertNotNull(studyService);

    }
}