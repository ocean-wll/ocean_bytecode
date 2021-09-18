package pers.ocean.agent.javassist;

import java.util.List;

import lombok.Data;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/18 2:15 下午
 */
@Data
public class MethodDescription {

    /**
     * 类名称
     */
    private String clazzName;

    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 参数名称[集合]
     */
    private List<String> parameterNameList;

    /**
     * 参数类型[集合]
     */
    private List<String> parameterTypeList;

    /**
     * 返回类型
     */
    private String returnType;

}
