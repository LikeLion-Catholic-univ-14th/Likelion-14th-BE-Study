package dto;

public class HelloDto {

    private String message;
    private String name;
    private String major;

    public HelloDto(String message, String name , String major) {
        this.name=name;
        this.message=message;
        this.major=major;
    }

    public HelloDto(String message, String name) {
        this.message = message;
        this.name = name;
    }

    public String getMessage(){
        return message;
    }

    public String getName(){
        return name;
    }

    public String getMajor() {
        return major;
    }
}
