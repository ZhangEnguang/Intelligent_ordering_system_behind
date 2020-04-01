package com.tsc.iorder.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class FileUtil {
    public static String  saveFile(MultipartFile file, String ul) throws IOException {
        File dir = new File(ul);
        String filename = file.getOriginalFilename();
        if (!dir.exists()){
            dir.mkdirs();
        }
        File deskFile = new File(dir, file.getOriginalFilename());
        file.transferTo(deskFile);
        return filename;
    }
    public static void deleteFile(File file,String filename){
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()){
                deleteFile(f,filename);
            }else if(f.isFile()){
                String name = f.getName();
                if (name.equals(filename)){
                   f.delete();
                }

            }
        }

    }
}
