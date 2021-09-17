package pers.ocean.agent.plugin;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/17 3:56 下午
 */
public interface InterceptPoint {

    /**
     * 类匹配规则
     *
     * @return ElementMatcher
     */
    ElementMatcher<TypeDescription> buildTypesMatcher();

    /**
     * 方法匹配规则
     *
     * @return ElementMatcher
     */
    ElementMatcher<MethodDescription> buildMethodsMatcher();

}
