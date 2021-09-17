package pers.ocean.agent.track;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/17 3:43 下午
 */
public class TrackContext {

    private static final ThreadLocal<String> trackLocal = new ThreadLocal<>();

    public static void clear() {
        trackLocal.remove();
    }

    public static String getLinkId() {
        return trackLocal.get();
    }

    public static void setLinkId(String linkId) {
        trackLocal.set(linkId);
    }
}
