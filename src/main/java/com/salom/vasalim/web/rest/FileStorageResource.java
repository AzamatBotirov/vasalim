package com.salom.vasalim.web.rest;

import com.salom.vasalim.demain.FileStorage;
import com.salom.vasalim.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;

@RestController
 @RequestMapping("/api")
public class FileStorageResource {


    @Value("${upload.folder}")
    private String uploadFolder;

    private final FileStorageService fileStorageService;

    public FileStorageResource(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }
     @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam("file")MultipartFile multipartFile){
        fileStorageService.save(multipartFile);
        return ResponseEntity.ok(multipartFile.getOriginalFilename() + "fail saqlanqi");
     }
    @GetMapping("/preview/{hashId}")
    public ResponseEntity previewFile(@PathVariable String hashId) throws IOException {
        FileStorage fileStorage = fileStorageService.findByHashId(hashId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; fileName=\"" + URLEncoder.encode(fileStorage.getName()))
                .contentType(MediaType.parseMediaType(fileStorage.getContentType()))
                .contentLength(fileStorage.getFileSize())
                .body(new FileUrlResource(String.format("%s/%s", uploadFolder, fileStorage.getUploatPath())));
    }
    @GetMapping("/downland/{hashId}")
    public ResponseEntity downlandFile(@PathVariable String hashId) throws IOException {
        FileStorage fileStorage = fileStorageService.findByHashId(hashId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + URLEncoder.encode(fileStorage.getName()))
                .contentType(MediaType.parseMediaType(fileStorage.getContentType()))
                .contentLength(fileStorage.getFileSize())
                .body(new FileUrlResource(String.format("%s/%s", uploadFolder, fileStorage.getUploatPath())));
    }

    @DeleteMapping("/delete/{hashId}")
    public ResponseEntity delete(@PathVariable String hashId){
        fileStorageService.delete(hashId);
        return ResponseEntity.ok("Fail ocirildi");
    }
}
