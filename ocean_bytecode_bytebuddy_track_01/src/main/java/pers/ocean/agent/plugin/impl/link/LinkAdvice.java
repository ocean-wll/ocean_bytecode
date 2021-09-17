package pers.ocean.agent.plugin.impl.link;

import java.util.UUID;

import net.bytebuddy.asm.Advice.OnMethodEnter;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.Origin;
import pers.ocean.agent.track.Span;
import pers.ocean.agent.track.TrackContext;
import pers.ocean.agent.track.TrackManager;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/17 4:11 下午
 */
public class LinkAdvice {

    @OnMethodEnter()
    public static void enter(@Origin("#t") String className, @Origin("#m") String methodName) {
        Span currentSpan = TrackManager.getCurrentSpan();
        if (currentSpan == null) {
            String linkId = UUID.randomUUID().toString();
            TrackContext.setLinkId(linkId);
        }
        TrackManager.createEntrySpan();
    }

    @OnMethodExit
    public static void exit(@Origin("#t") String className, @Origin("#m") String methodName) {
        Span exitSpan = TrackManager.getExitSpan();
        if (exitSpan == null) {
            return;
        }
        System.out.printf("链路追踪(MQ)：%s %s.%s 耗时：%dms%n", exitSpan.getLinkId(), className, methodName,
            System.currentTimeMillis() - exitSpan.getEnterTime().getTime());
    }
}
