package com.tsc.iorder.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class SaveFile {
    public String  saveFile(MultipartFile file, String ul) throws IOException {
        File dir = new File(ul);
        String filename = file.getOriginalFilename();
        if (!dir.exists()){
            dir.mkdirs();
        }
        File deskFile = new File(dir, file.getOriginalFilename());
        file.transferTo(deskFile);
        return filename;
    }
}
