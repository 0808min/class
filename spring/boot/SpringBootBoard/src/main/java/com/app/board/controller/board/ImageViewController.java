package com.app.board.controller.board;

<<<<<<< HEAD
import lombok.Cleanup;
=======
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

<<<<<<< HEAD
=======

>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
@Controller
@Log4j2
public class ImageViewController {

    @GetMapping(value = "/upload/photo/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> viewImage(
<<<<<<< HEAD
            @PathVariable("fileName") String fileName
    ) throws IOException {

        log.info(" ImageView Controller ...");
=======
            @PathVariable("filename") String fileName
    ) throws IOException {

        log.info("ImageView Controller ..." );
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135

        byte[] imageByteArray = null;
        HttpStatus status = HttpStatus.NOT_FOUND;

<<<<<<< HEAD

        File savedFile = new File(new File("").getAbsolutePath(), "photo\\"+fileName);

        if(savedFile.exists()){
            // 응답 처리
            InputStream imageStream = new FileInputStream(savedFile);
            imageByteArray = imageStream.readAllBytes();
            imageStream.close();
            status = HttpStatus.OK;
        }

        return new ResponseEntity<byte[]>(imageByteArray, status);
    }
=======
        File savedFile = new File(new File("").getAbsolutePath(), "photo\\"+fileName);

        if(savedFile.exists()) {
            // 응답처리
            InputStream imageStream = new FileInputStream(savedFile);
            imageByteArray = imageStream.readAllBytes();
            status = HttpStatus.OK;
        }


        return new ResponseEntity<byte[]>(imageByteArray, status);

    }


>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
}
