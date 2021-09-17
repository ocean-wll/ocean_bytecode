package pers.ocean.agent.javassist;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/17 5:10 下午
 */
public class GenerateClazzMethod {

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();

        // 创建类信息
        CtClass ctClass = pool.makeClass("pers.ocean.agent.javassist.GenerateHelloWord");

        // 添加方法
        CtMethod mainMethod = new CtMethod(CtClass.voidType, "main", new CtClass[] {pool.get(String[].class.getName())},
            ctClass);
        mainMethod.setModifiers(Modifier.PUBLIC + Modifier.STATIC);
        mainMethod.setBody("{System.out.println(\"hi javassist ! I'm ocean\");}");

        ctClass.addMethod(mainMethod);

        // 输出类的内容
        ctClass.writeFile();

        // 测试调用
        Class clazz = ctClass.toClass();
        Object obj = clazz.newInstance();

        Method main = clazz.getDeclaredMethod("main", String[].class);
        main.invoke(obj, (Object)new String[1]);
    }
}
