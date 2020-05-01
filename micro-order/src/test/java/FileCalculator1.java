import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.*;

/**
 * @author Jame
 * @date 2018/08/31 10:29
 */
public class FileCalculator1 {

    public static void print(File file) {

        File[] files = file.listFiles();
        Map<Integer, File[]> map = new HashMap<>();
        map.put(0, files);

        int curr = 0;
        int max = 0;
        while (!map.isEmpty()) {

            files = map.get(curr);

            for (File f : files) {
                try {
                    Long size = 0L;
                    if (f.isDirectory()) {
                        size = FileUtils.sizeOfDirectory(f) / 1024;
                        map.put(max + 1, f.listFiles());
                    } else {
                        size = FileUtils.sizeOf(f) / 1024;
                    }
                    System.out.println("文件：" + f.getPath() + ",大小为：" + size + "K");
                } catch (Exception e) {
                    //System.out.println("文件夹："+f.getName()+"无法计算.");
                }
            }
            map.remove(curr);
            curr++;

        }

    }

    public static void main(String[] args) throws Exception {
        String path = "C:\\Windows";
        File file = new File(path);
        print(file);
    }
}