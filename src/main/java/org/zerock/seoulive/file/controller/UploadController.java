package org.zerock.seoulive.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Controller
public class UploadController {

    private static final String UPLOAD_DIR = "/path/to/upload/directory"; // 파일 업로드 디렉토리 경로

    @RequestMapping("/")
    public String uploadForm() {
        return "uploadForm"; // 업로드 폼 페이지로 이동
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request) {

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> fileNames = multipartRequest.getFileNames();

            while (fileNames.hasNext()) {
                MultipartFile file = multipartRequest.getFile(fileNames.next());

                if (file != null && !file.isEmpty()) {
                    try {
                        // 업로드할 디렉토리 생성
                        File uploadDir = new File(UPLOAD_DIR);
                        if (!uploadDir.exists()) {
                            uploadDir.mkdirs();
                        }

                        // 파일 저장
                        String originalFilename = file.getOriginalFilename();
                        String storedFilename = originalFilename; // 저장할 파일명 설정 (기존 파일명 사용)

                        File destFile = new File(uploadDir.getAbsolutePath() + File.separator + storedFilename);
                        file.transferTo(destFile);

                        // 파일 업로드 성공 시 처리
                        // ...

                    } catch (IOException e) {
                        // 파일 업로드 실패 시 처리
                        // ...
                    }
                }
            }
        }

        return "redirect:/success";
    }
}