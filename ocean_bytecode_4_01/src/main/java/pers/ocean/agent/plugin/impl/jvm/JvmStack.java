package pers.ocean.agent.plugin.impl.jvm;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/17 4:26 下午
 */
public class JvmStack {

    private static final long MB = 1024 * 1024;

    public static void printMemoryInfo() {
        MemoryMXBean memory = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemory = memory.getHeapMemoryUsage();

        String info = String.format("\ninit: %s\t max: %s\t used: %s\t committed: %s\t use rate: %s\n",
            heapMemory.getInit() / MB + "MB",
            heapMemory.getMax() / MB + "MB", heapMemory.getUsed() / MB + "MB",
            heapMemory.getCommitted() / MB + "MB",
            heapMemory.getUsed() * 100 / heapMemory.getCommitted() + "%"
        );

        System.out.println(info);

        MemoryUsage nonHeapMemory = memory.getNonHeapMemoryUsage();
        info = String.format("init: %s\t max: %s\t used: %s\t committed: %s\t use rate: %s\n",
            nonHeapMemory.getInit() / MB + "MB",
            nonHeapMemory.getMax() / MB + "MB", nonHeapMemory.getUsed() / MB + "MB",
            nonHeapMemory.getCommitted() / MB + "MB",
            nonHeapMemory.getUsed() * 100 / nonHeapMemory.getCommitted() + "%"
        );

        System.out.println(info);
    }

    public static void printGCInfo() {
        List<GarbageCollectorMXBean> garbages = ManagementFactory.getGarbageCollectorMXBeans();
        garbages.forEach(garbage -> {
            String info = String.format("name: %s\t count:%s\t took:%s\t pool name:%s",
                garbage.getName(),
                garbage.getCollectionCount(),
                garbage.getCollectionTime(),
                Arrays.deepToString(garbage.getMemoryPoolNames()));
            System.out.println(info);
        });
        System.out.println("--------------------------------------------------------------------------");
    }
}
