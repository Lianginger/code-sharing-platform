package platform;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.*;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import platform.accessingdatajpa.CodeShare;
import platform.accessingdatajpa.CodeShareRepository;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {



    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }


}
