package com.hshb.core.code.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Strings;
 

public class FileUtils {

    public static String separator = System.getProperty("line.separator");

    public static void createAllFolder(String path) {
        if (Strings.isNullOrEmpty(path)) {
            return;
        }
        if (path.indexOf("\\") < 0) {
            return;
        }
        String[] arr = path.split("\\\\");
        String newPath = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                newPath = arr[0];
            } else {
                newPath = newPath + "\\" + arr[i];
            }
            File f = new File(newPath);
            if (f.exists()) {
                continue;
            }
            f.mkdir();
        }
    }

    public static void writeToEnd(String file, String content) {
        BufferedWriter out = null;
        try {
            File myFilePath = new File(file);
            if (!myFilePath.exists()) {
                myFilePath.createNewFile();
            }
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            out.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean ifExist(String filePathAndName) {
        boolean bea = false;
        try {
            String filePath = filePathAndName;
            File myDelFile = new File(filePath);
            bea = myDelFile.exists();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bea;
    }

    public static boolean delFile(String filePathAndName) {
        if (!ifExist(filePathAndName)) {
            return true;
        }
        boolean bea = false;
        try {
            String filePath = filePathAndName;
            File myDelFile = new File(filePath);
            if (myDelFile.exists()) {
                myDelFile.delete();
                bea = true;
            } else {
                bea = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bea;
    }

    // 删除目录及子目录
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            // 递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    // 获得目录下所有目录
    public static List<String> listDir(String dir, List<String> dirList) {
        if (dirList == null) {
            return new ArrayList<>();
        }
        File root = new File(dir);
        File[] filesOrDirs = root.listFiles();
        for (int i = 0; i < filesOrDirs.length; i++) {
            if (filesOrDirs[i].isDirectory()) {
                listDir(filesOrDirs[i].getAbsolutePath(), dirList);
            } else {
                dirList.add(filesOrDirs[i].getName());
            }
        }
        return dirList;
    }

    // 获得目录下所有文件
    public static List<String> listFile(String dir, List<String> fileList) {
        if (fileList == null) {
            return new ArrayList<>();
        }
        File root = new File(dir);
        File[] filesOrDirs = root.listFiles();
        if (filesOrDirs == null) {
            return fileList;
        }
        for (int i = 0; i < filesOrDirs.length; i++) {
            if (filesOrDirs[i].isFile()) {
                fileList.add(dir + "\\" + filesOrDirs[i].getName());
            } else {
                listFile(filesOrDirs[i].getAbsolutePath(), fileList);
            }
        }
        return fileList;
    }

    // 拷贝文件
    public static void copyFile(String oldPathFile, String newPathFile) throws Exception {
        int byteread = 0;
        File oldfile = new File(oldPathFile);
        if (oldfile.exists()) { // 文件存在时
            InputStream inStream = new FileInputStream(oldPathFile); // 读入原文件
            FileOutputStream fs = new FileOutputStream(newPathFile);
            byte[] buffer = new byte[1444];
            while ((byteread = inStream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteread);
            }
            inStream.close();
            fs.close();
        }
    }
    /**
     * getFileInputStreamByUrl:(根据网络URL获取文件流)
     * @param sourceUrl
     * @return    设定文件
     * @author    tangliang
     * @date      2017年9月19日 下午6:01:12
     * @return FileInputStream    DOM对象
     * @throws Exception 
     */
    public static void getFileInputStreamByUrl(String sourceUrl,String savePath) throws Exception{
        
        URL url = new URL(sourceUrl);
        URLConnection con = url.openConnection(); 
        con.setConnectTimeout(5*1000);  
        InputStream is = con.getInputStream();  
        byte[] bs = new byte[1024];  
        int len;  
        OutputStream os = new FileOutputStream(savePath); 
        while ((len = is.read(bs)) != -1) {  
            os.write(bs, 0, len);  
         }  
        os.close();  
        is.close(); 
    }
    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static StringBuffer readFileByLines(String fileName) {
        StringBuffer resultSB = new StringBuffer();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                resultSB.append(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return resultSB;
    }

}
