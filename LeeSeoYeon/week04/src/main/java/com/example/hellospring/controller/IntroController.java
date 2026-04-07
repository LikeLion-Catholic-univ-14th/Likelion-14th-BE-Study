package com.example.hellospring.controller; //IntroController 클래스가 어떤 폴더, 구조 안에 있는지 선언하는 것이다.

import com.example.hellospring.dto.IntroDto; //다른 패키지에 있는 IntroDto 클래스를 여기 IntroController 클래스로 불러오는 것이다. 두 클래스의 패키지가 다르기 때문에 import로 선언해야 한다.
import org.springframework.web.bind.annotation.GetMapping; //Spring MVC에서 HTTP GET 요청을 처리하는 @GetMapping 어노테이션이다. 따라서 GET 요청을 처리하는 메서드를 만들 때 필요하다.
import org.springframework.web.bind.annotation.RestController; //현재 IntroController 클래스를 REST API Controller로 설정하는 것이다. 이 문장이 없으면 Spring이 이 IntroController 클래스를 API Controller로 인식하지 못한다. 따라서 IntroController 클래스 전체를 HTTP 요청을 처리하는 컨트롤러로 등록하라는 의미의 문장이다.

@RestController  //Spring Framework에서 제공하는 컨트롤러용 어노테이션으로, 반환값을 HTML이 아니라 JSON 형태로 내보내고, IntroController 클래스 안의 메서드들이 HTTP API 요청을 처리하는 엔드 포인트가 되게 하는 것이다. 따라서 브라우저에서 http://localhost:8080/intro 를 검색하면 JSON이 출력된다.
public class IntroController {

    @GetMapping("/intro") //클라이언트가 /intro URL로 GET 방식의 요청을 보내면 스프링이 자동으로 아래의 메서드를 실행시키라는 의미로, 라우팅 이라고도 한다. 요청 방식이 GET으로 고정된다.
    public IntroDto getIntro() {     //public : 어디에서든 호출 가능하다는 의미로, 다른 클래스나 브라우저에서 이 메서드를 호출할 수 있게 된다. 즉, 웹 요청으로 이 메서드를 사용할 수 있게 만드는 중요한 키워드이다.
                                    //IntroDto : 이 메서드가 반환하는 값의 타입(=Return Type)을 의미한다. 즉, 메서드는 실행 후 반드시 IntroDto 타입의 객체를 반환해야 하고, 이후 문장이 return new IntroDto( );이므로 올바른 반환을 할 것이다.
                                    //getIntro() : 메서드 이름으로, 스프링에서 이 메서드는 /intro GET 요청이 올 때 호출이 되도록 mapping 되어 있다.
        return new IntroDto("이서연", "바이오메디컬소프트웨어학과"); //IntroDto 라는 데이터객체(=Data Transfer Object)를 새로 만들어 반환하라는 의미이다. 이 객체에는 name="이서연", major="바이오메디컬소프트웨어학과" 값이 들어있다.
    }
}