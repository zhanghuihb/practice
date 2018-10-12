package 写一个ArrayList的动态代理类;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tainy
 * @date 2018/7/17 18:41
 */
public class Test1 {

    public static void newInstance (){
        final List<String> list = new ArrayList<>();
        List<String> proxyInstance = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(list, args);
            }
        });
        proxyInstance.add("你好");
        System.out.println(list);
    }

    public static void main(String[] args) {
        Test1.newInstance();
    }

}
