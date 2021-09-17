package pers.ocean.agent.plugin;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/17 4:02 下午
 */
public interface IPlugin {

    /**
     * 名称
     *
     * @return
     */
    String name();

    /**
     * 监控点
     *
     * @return
     */
    InterceptPoint[] buildInterceptPoint();

    /**
     * 拦截器类
     *
     * @return
     */
    Class adviceClass();
}
