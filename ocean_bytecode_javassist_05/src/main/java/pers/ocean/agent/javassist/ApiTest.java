package pers.ocean.agent.javassist;

import java.math.BigDecimal;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/18 3:34 下午
 */
@RpcGatewayClazz(clazzDesc = "用户信息查询服务", alias = "api", timeOut = 500)
public class ApiTest {

    @RpcGatewayMethod(methodDesc = "查询息费", methodName = "interestFee")
    public double queryInterestFee(String uid) {
        return BigDecimal.TEN.doubleValue();
    }
}
