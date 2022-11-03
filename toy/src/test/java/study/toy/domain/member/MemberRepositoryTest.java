package study.toy.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemoryMemberRepository memberRepository;

    @AfterEach
    void clearStore(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        Member member = new Member("kim", "test1", "1234");
        memberRepository.save(member);

        Member byUserId = memberRepository.findByUserId(member.getId());
        System.out.println("byUserId = " + byUserId);

        Assertions.assertThat(member).isEqualTo(byUserId);

    }

}