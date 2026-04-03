package org.example.study_3.dto;

public class IntroduceDto {
    private String name;
    private String major;

    public IntroduceDto(){

    }
    public IntroduceDto(String name, String major){
        this.name = name;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }
    public void setName(String name){
        this.name=name;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
