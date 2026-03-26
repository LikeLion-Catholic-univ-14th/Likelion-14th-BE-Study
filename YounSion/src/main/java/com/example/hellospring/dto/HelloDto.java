package com.example.hellospring.dto;

public class HelloDto {

    //실제 전달할 데이터 (외부에서 접근할 수 없게 막아둠)
    private String message;
    private String name;

    public HelloDto() { //기본 생성자
    }

    //객체를 만들 때 값을 바로 넣기 위한 생성자
    public HelloDto(String message,String name) {
        this.message = message;
        this.name = name;
    }

    //데이터 읽기 위한 메소드. 외부에서 message에 직접 접근 못하고 이 메소드 통해서만 값을 가져올 수 있음
    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }
    //데이터 수정하기 위한 메소드. 외부에서 직접 값을 바꾸지 못하고 이 메소드 통해서만 변경할 수 있다.
    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }
}