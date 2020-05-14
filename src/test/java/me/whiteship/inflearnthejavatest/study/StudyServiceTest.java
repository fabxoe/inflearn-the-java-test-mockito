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

//        when(memberService.findById(1L)).thenReturn(Optional.of(member));//리턴 타입이 있는 메소드에 대해서 리턴값을 Stubbing 하는 것 말고도 예외 Stubbing할 수도 있다.
//        when(memberService.findById(1L)).thenThrow(new RuntimeException());//리턴 타입이 있는 메소드에 대해서 예외를 던지도록 Stubbing할 때는 thenThrow
        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);//리턴 타입이 없을 때 특정 메소드가 예외를 던지도록 Stubbing할 때는 doThrow


        assertThrows(IllegalArgumentException.class, ()-> {
            memberService.validate(1L);
        });
    }
}