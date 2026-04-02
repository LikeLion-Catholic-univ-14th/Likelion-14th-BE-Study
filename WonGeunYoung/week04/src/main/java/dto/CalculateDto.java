package dto;

public class CalculateDto {

    private int num1;
    private int num2;
    private int result;
    private String operation;


    public CalculateDto(int num1, int num2, int result, String operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.operation = operation;
    }

    public int getNum1() { return num1; }
    public int getNum2() { return num2; }
    public int getResult() { return result; }
    public String getOperation() { return operation; }
}
