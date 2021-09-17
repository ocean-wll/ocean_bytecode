package pers.ocean.agent.javassist;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/17 5:41 下午
 */
public class ApiTest {

    private double π = 3.14D;

    public double calculateCircularArea(int r) {
        return π * r * r;
    }

    public Double sumOdTwoNumbers(double a, double b) {
        return a + b;
    }
}
