package pers.ocean.agent.javassist;

import java.util.Random;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/18 11:07 上午
 */
public class OceanApiTest {

    public String queryGirlFriendCount(String boyFriendName) {
        return boyFriendName + "的前女友数量：" + (new Random().nextInt(10) + 1L) + " 个";
    }
}
