package common;

import com.sun.org.apache.bcel.internal.generic.NEW;
import 序列化和反序列化实现克隆.Test;

import java.io.*;

/**
 * @author Tainy
 * @date 2018/10/22 13:22
 */
public class MyUtil {

    private MyUtil(){
        throw new AssertionError();
    }

    public static <T extends Serializable> T clone(T obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oot = new ObjectOutputStream(bout);
        oot.writeObject(obj);
        ByteArrayInputStream bint = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bint);
        return (T) ois.readObject();
    }
}
