package java文件读取;

import java.io.*;

/**
 * @author Tainy
 * @date 2020-03-24 9:59
 */
public class FileReader {
    public static void main(String[] args) throws IOException {
        // 1.首先获取一个文件句柄。file即为文件句柄，相当于两人之间的电话网络拨通了
        File file = new File("C:\\Users\\Administrator\\Desktop\\test.txt");
        // 2.通过这条线路获取甲方信息。次操作会把甲方信息读取到内存当中去
        FileInputStream inputStream = new FileInputStream(file);
        // 3. 读取解析内存中的信息
        final InputStreamReader reader = new InputStreamReader(inputStream);
        // 4. 解读完成后，输出
        final BufferedReader br = new BufferedReader(reader);
        String line = null;
        int totalLine = 0;
        while ((line = br.readLine()) != null){
            totalLine++;
            System.out.println("第" + totalLine + "行:" + line);
        }

        System.out.println("一共" + totalLine + "行");
        br.close();
        inputStream.close();
    }
}
