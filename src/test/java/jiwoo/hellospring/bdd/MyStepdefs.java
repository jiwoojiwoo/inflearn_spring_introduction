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
    String exceptionMessage;

    @Before
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @After
    public void afterEach() {
        memberRepository.clearStore();
    }


    @When("회원 가입한다. {string}")
    public void 회원가입한다(String name) {
        exceptionMessage = null;
        Member member = new Member();
        member.setName(name);
        try {
            memberService.join(member);
        }catch (IllegalStateException ie){
            exceptionMessage = ie.getMessage();
        }
    }

    @Then("회원이 존재한다. {string}")
    public void 회원이존재한다(String name) {
        Member result = memberService.findOneByName(name).get();
        assertThat(result.getName()).isEqualTo(name);
    }

    @Then("예외가 발생한다. {string}")
    public void 예외가발생한다(String message) {
        assertThat(exceptionMessage).isEqualTo("이미 존재하는 회원입니다.");
    }

//    @Given("회원이 가입되어 있다. {string}")
//    public void 회원이가입되어있다(String name) {
//        Member member = new Member();
//        member.setName(name);
//        memberService.join(member);
//    }
}
