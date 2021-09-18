package pers.ocean.agent.javassist;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/18 3:31 下午
 */
public @interface RpcGatewayClazz {

    String clazzDesc() default "";

    String alias() default "";

    long timeOut() default 350;
}
