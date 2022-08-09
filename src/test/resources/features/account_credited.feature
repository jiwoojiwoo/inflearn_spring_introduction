Feature: 신규 회원 가입

  Scenario: 이미 등록된 이름의 회원이 추가될 경우, 예외 처리 되어야함
    Given 회원 한 명이 등록된 상태이다 "jiwoo"
    When jiwoo를 등록한다 "jiwoo"
    Then 예외처리 된다 "이미 존재하는 회원입니다."