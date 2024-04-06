# Blog Check

## Why did you start

블로그를 작성하는 이유는 학습한 내용 정리, 복습, 나와 같은 문제를 겪는 사람에게 해결방법을 제공하기 위해 블로그를 작성한다.  
만약 1주일 사이에 작성된 블로그가 없다면 내 자신이 나태해져서 학습을 안 하고 논 걸로 판단을 하여 나태함을 고치기 위해 시작하게 되었다.

## WorkFlow

-   월요일 기준으로 월요일 ~ 1주일 전까지 블로그가 작성되어 있는지 확인한다.
-   블로그를 작성 안 했다면 지인에게는 좋은 일 나에게는 안 좋은 일이 담긴 문자 메시지를 지인에게 발송한다.

## Scope of use

-   Tistory
-   Velog
-   (개발자가 주기적으로 작성하는 블로그 발견 시 추가 예정)

## Config(application.yml)

-   BLOG\_ADDRESS : 파싱 할 블로그 주소 (ex : [https://hoestory.tistory.com/](https://hoestory.tistory.com/))
-   BLOG\_TYPE: tistory, velog, TISTORY, VELOG.. 등 다양한 형태로 입력
-   API\_KEY : 문자 메시지 서비스 제공하는 플랫폼에서 발급해 주는 API 키 값
-   SECRET\_KEY : 문자 메시지 서비스를 제공하는 플랫폼에서 발급해 주는 시크릿 값
-   RECEIVER\_NUMBERS : 문자 메시지를 수신할 번호들 입력 (ex : 010xxxxxxxx,010oooooooo,010aaaaaaaa)
-   SEND\_NUMBER : 문자 메시지를 발신할 번호 (ex : 010xxxxxxxx)
-   PLATFORM\_URL : 문자 메시지 제공하는 플랫폼에서 제공하는 인증 주소

## Skill

-   Java 17
-   Spring Boot
-   Spring Schedule
-   Jsoup

## Schedule

현재 티스토리, velog만 적용되어 있는 상태입니다. 추가적으로 많이 이용되는 블로그를 알게 되었을 때 추가적으로 개발 진행 할 예정입니다.