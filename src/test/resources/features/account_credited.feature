Feature: 신규 회원 가입

  Scenario: 이미 등록된 이름의 회원이 추가될 경우, 예외 처리 되어야함
    Given 회원 가입한다. "jiwoo"
    Then 회원이 존재한다. "jiwoo"
    When 회원 가입한다. "jiwoo"
    Then 예외가 발생한다. "이미 존재하는 회원입니다."
    When 회원 가입한다. "coomon"
    Then 회원이 존재한다. "coomon"

#  Background:
#    Given 회원이 가입되어 있다. "jiwoo"
#    Then 회원이 존재한다. "jiwoo"

#  Scenario: 이미 등록된 이름의 회원이 추가될 경우, 예외 처리 되어야함
#    When 회원 가입한다. "jiwoo"
#    Then 예외가 발생한다. "이미 존재하는 회원입니다."

#    Scenario: 새로운 회원이 등록된다
#    When 회원 가입한다. "coomon"
#    Then 회원이 존재한다. "coomon"