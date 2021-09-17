package pers.ocean.agent.plugin.impl.jvm;

import net.bytebuddy.asm.Advice.OnMethodExit;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/17 4:32 下午
 */
public class JvmAdvice {

    @OnMethodExit
    public static void exit() {
        JvmStack.printMemoryInfo();
        JvmStack.printGCInfo();
    }
}
