package pers.ocean.agent.plugin.impl.jvm;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import pers.ocean.agent.plugin.IPlugin;
import pers.ocean.agent.plugin.InterceptPoint;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/17 4:32 下午
 */
public class JvmPlugin implements IPlugin {

    @Override
    public String name() {
        return "jvm";
    }

    @Override
    public InterceptPoint[] buildInterceptPoint() {
        return new InterceptPoint[] {
            new InterceptPoint() {
                @Override
                public ElementMatcher<TypeDescription> buildTypesMatcher() {
                    return ElementMatchers.nameStartsWith("pers.ocean.agent.test");
                }

                @Override
                public ElementMatcher<MethodDescription> buildMethodsMatcher() {
                    return ElementMatchers.isMethod()
                        .and(ElementMatchers.any())
                        .and(ElementMatchers.not(ElementMatchers.nameStartsWith("main")));
                }
            }
        };
    }

    @Override
    public Class adviceClass() {
        return JvmAdvice.class;
    }
}
