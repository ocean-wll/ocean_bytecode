package pers.ocean.agent.track;

import java.util.Stack;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/17 3:45 下午
 */
public class TrackManager {

    private static final ThreadLocal<Stack<Span>> track = new ThreadLocal<>();

    private static Span createSpan() {
        Stack<Span> stack = track.get();
        if (stack == null) {
            stack = new Stack<>();
            track.set(stack);
        }

        String linkId;
        if (stack.isEmpty()) {
            linkId = TrackContext.getLinkId();
            if (linkId == null) {
                linkId = "nvl";
                TrackContext.setLinkId(linkId);
            }
        } else {
            Span span = stack.peek();
            linkId = span.getLinkId();
            TrackContext.setLinkId(linkId);
        }
        return new Span(linkId);
    }

    public static Span createEntrySpan() {
        Span span = createSpan();
        Stack<Span> stack = track.get();
        stack.push(span);
        return span;
    }

    public static Span getExitSpan() {
        Stack<Span> stack = track.get();
        if (stack == null || stack.isEmpty()) {
            TrackContext.clear();
            return null;
        }
        return stack.pop();
    }

    public static Span getCurrentSpan() {
        Stack<Span> stack = track.get();
        if (stack == null || stack.isEmpty()) {
            return null;
        }
        return stack.peek();
    }
}
