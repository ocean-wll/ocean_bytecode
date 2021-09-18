package pers.ocean.agent.javassist;

import java.util.concurrent.TimeUnit;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.util.HotSwapper;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/18 11:47 上午
 */
public class GenerateClazzMethod {

    public static void main(String[] args) throws Exception {

        OceanApiTest apiTest = new OceanApiTest();
        System.out.println("你到底几个前女友！！！");

        new Thread(() -> {
            while (true) {
                System.out.println(apiTest.queryGirlFriendCount("ocean"));
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 监听 8000 端口,在启动参数里设置
        // java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000
        HotSwapper hs = new HotSwapper(8000);

        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get(OceanApiTest.class.getName());

        // 获取方法
        CtMethod ctMethod = ctClass.getDeclaredMethod("queryGirlFriendCount");
        // 重写方法
        ctMethod.setBody("{ return $1 + \"的前女友数量：\" + (0L) + \" 个\"; }");

        // 加载新的类
        System.out.println(":: 执行HotSwapper热插拔，修改ocean前女友数量为0个！");

        hs.reload(OceanApiTest.class.getName(), ctClass.toBytecode());
    }
}
