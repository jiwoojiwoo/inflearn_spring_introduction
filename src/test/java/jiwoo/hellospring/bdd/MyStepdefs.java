package jiwoo.hellospring.bdd;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jiwoo.hellospring.domain.Member;
import jiwoo.hellospring.repository.MemoryMemberRepository;
import jiwoo.hellospring.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyStepdefs {
    MemberService memberService;
    MemoryMemberRepository memberRepository;
    IllegalStateException e;

    @Before
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @After
    public void afterEach() {
        memberRepository.clearStore();
    }


    @Given("회원 한 명이 등록된 상태이다 {string}")
    public void 회원한명이등록된상태이다(String name) {
        Member member = new Member();
        member.setName(name);
        memberService.join(member);
    }

    @When("jiwoo를 등록한다 {string}")
    public void jiwoo를등록한다(String name) {
        Member member = new Member();
        member.setName(name);
        e = assertThrows(IllegalStateException.class, () -> memberService.join(member));
    }

    @Then("예외처리 된다 {string}")
    public void 예외처리된다(String message) {
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

}
