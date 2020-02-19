package com.tuhin.springboot.compress;

import com.tuhin.springboot.course.Course;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller
public class DownloadController {
    @RequestMapping("/check")
    public String getAllCourses(@PathVariable long topic) {
        return "Checking";
    }


    @GetMapping(value = "/zip-download", produces = "application/zip")
    public void zipDownload(@RequestParam List<String> name, HttpServletResponse response) throws IOException {
        ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream());
        for (String fileName : name) {
            FileSystemResource resource = new FileSystemResource("G:\\download\\january\\mongodb-win32-x86_64-2012plus-4.2.2-signed.msi");
            ZipEntry zipEntry = new ZipEntry(resource.getFilename());
            zipEntry.setSize(resource.contentLength());
            zipOut.putNextEntry(zipEntry);
            StreamUtils.copy(resource.getInputStream(), zipOut);
            zipOut.closeEntry();
        }
        zipOut.finish();
        zipOut.close();
        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "download" + "\"");
    }
}
