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
        StudyService studyService = new StudyService(memberService, studyRepository);//setter에 사용하거나 필드에 직접 써도 되지만 여기선 생성자에 사용하였다.
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("keesun@email.com");

//        when(memberService.findById(1L)).thenReturn(Optional.of(member));//목 객체를 가지고 Stubbing했다. -> 실제 소스에서 Stubbing을 따라서 동작한다.
        when(memberService.findById(anyLong())).thenReturn(Optional.of(member));//목 객체를 가지고 Stubbing했다. -> 실제 소스에서 Stubbing을 따라서 동작한다.

        Study study = new Study(10, "java");

        Optional<Member> findById = memberService.findById(1L);
        assertEquals("keesun@email.com", findById.get().getEmail());
//        studyService.createNewStudy(1L, study);


    }
}