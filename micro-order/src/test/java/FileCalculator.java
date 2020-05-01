

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * @author anzy
 * @version 1.0
 * @date 2020/4/29 22:57
 **/
public class FileCalculator {
    private static final Integer THREAD_COUNT = 10;
    public static void print(File file){

        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);

        HashMap<Integer,File> hashMap = new HashMap<>();
        hashMap.put(0,file);
        int curr = 0;
        int map = 0;
        while (!hashMap.isEmpty() && hashMap.get(curr) != null){
            File[] files = hashMap.get(curr).listFiles();
            for (int i=0; i<files.length; i++){
                File f = files[i];
                try {
                    if (f.isDirectory()){
                        map++;
                        hashMap.put(map,f);
                    }else {
                        Long size = FileUtils.sizeOf(f)/1024;
                        System.out.println("文件夹："+f.getPath()+",大小为："+ size +"KB");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            curr++;
        }

    }

    public static void print2(File file){
        Long size = 0L;

        if (file.isDirectory()){
            for (File file1: file.listFiles()){

            }
        }else {
            size = FileUtils.sizeOf(file)/1024/1024;
        }


    }

    public static void print3(File file) {

        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);

        File[] files = file.listFiles();
        ArrayList<File> fileArr = new ArrayList<>();
        fileArr.addAll(Arrays.asList(files));

        for (int i = 0; i < fileArr.size(); i++) {
            File f = fileArr.get(i);
            if (null == f) {
                continue;
            }
            try {
                Long size = 0L;
                if (f.isDirectory()) {
                    size = FileUtils.sizeOfDirectory(f) / 1024;
                    fileArr.addAll(i + 1, Arrays.asList(f.listFiles()));
                    System.out.println("文件夹：" + f.getPath() + ",大小为：" + size + "K");
                } else {
                    size = FileUtils.sizeOf(f) / 1024;
                    System.out.println("文件：" + f.getPath() + ",大小为：" + size + "K");
                }
            } catch (Exception e) {
                System.out.println("文件或文件夹："+f.getName()+"无法计算.");
            }
        }


    }

    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\Acer\\Desktop\\linuxdownload";
        File file = new File(path);
        print(file);
        AbstractQueuedLongSynchronizer
    }

}
