package jiwoo.hellospring.repository;

import jiwoo.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        // given
        Member member = new Member();
        member.setName("jiwoo");

        //  when
        repository.save(member);

        // then
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        // given
        Member member1 = new Member();
        member1.setName("jiwoo");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("coomon");
        repository.save(member2);

        // when
        Member result = repository.findByName("jiwoo").get();

        // then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        // given
        Member member1 = new Member();
        member1.setName("jiwoo");
        repository.save(member1);

        Member memeber2 = new Member();
        memeber2.setName("coomon");
        repository.save(memeber2);

        // when
        List<Member> result = repository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
    }
}