package com.tuhin.springboot.compress;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindAllFIle {
    public static void main(String[] args) {
        File file = new File("C:\\btclautomation\\resources\\bills\\lli\\2020\\Feb");
        File[] files = file.listFiles();
        List<String> names = new ArrayList<>();
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
            names.add(f.getAbsolutePath());
        }
        ZipFiles.zipFiles(names.stream()
                .toArray(String[]::new));
    }
}
