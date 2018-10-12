package filechannel大文件上传;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author Tainy
 * @date 2018/8/22 14:23
 */
public class FileChannelTest {

    public static void transfer(File source, File target){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        if(!source.exists() || !source.isFile()){
            return;
        }
        if(target.exists()){
            target.delete();
        }
        try {
            target.createNewFile();
            fileInputStream = new FileInputStream(source);
            fileOutputStream = new FileOutputStream(target);
            FileChannel fileChannel = fileInputStream.getChannel();
            WritableByteChannel writableByteChannel = fileOutputStream.getChannel();
            fileChannel.transferTo(0, fileChannel.size(), writableByteChannel);
            fileChannel.close();
            writableByteChannel.close();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        transfer(new File("C:" + File.separator + "迅雷下载" + File.separator + "西游记女儿国_bd.mp4"), new File("D:" + File.separator + "xcx-file" + File.separator + "西游记女儿国_bd.mp4"));
        long endTime = System.currentTimeMillis();
        System.out.println("time = " + (endTime - startTime));
    }
}
