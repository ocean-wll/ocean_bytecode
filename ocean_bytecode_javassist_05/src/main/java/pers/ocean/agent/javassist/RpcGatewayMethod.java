package pers.ocean.agent.javassist;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/18 3:34 下午
 */
public @interface RpcGatewayMethod {

    String methodName() default "";

    String methodDesc() default "";
}
