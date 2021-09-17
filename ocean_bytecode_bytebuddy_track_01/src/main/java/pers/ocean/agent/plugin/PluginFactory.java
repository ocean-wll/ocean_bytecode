package pers.ocean.agent.plugin;

import java.util.ArrayList;
import java.util.List;

import pers.ocean.agent.plugin.IPlugin;
import pers.ocean.agent.plugin.impl.jvm.JvmPlugin;
import pers.ocean.agent.plugin.impl.link.LinkPlugin;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/17 4:36 下午
 */
public class PluginFactory {

    public static List<IPlugin> pluginGroup = new ArrayList<>();

    static {
        // 链路追踪
        pluginGroup.add(new LinkPlugin());
        // jvm监控
        pluginGroup.add(new JvmPlugin());
    }
}
