package com.ohgiraffers.restapi.section01.response;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/response")
public class ResponseTestController {

    // 문자열 응답 test
    @GetMapping("/hello")
    public String helloWorld() {
        System.out.println("hello world");

        return "hello world!";
    }

    // 기본 자료형 test
    @GetMapping("/random")
    public int getRandomNumber() {

        return (int)(Math.random() * 10) + 1;
    }

    // Object 타입 응답
    @GetMapping("/message")
    public Message getMessage() {

        return new Message(200, "정상 응답 완료!");
    }

    // List 타입 응답
    @GetMapping("/list")
    public List<String> getList() {

        return List.of(new String[] {"햄버거", "피자", "닭가슴살"});
    }

    // Map 타입 응답
    @GetMapping("/map")
    public Map<Integer, String> getMap() {

        Map<Integer, String> messageMap = new HashMap<>();
        messageMap.put(200, "정상 응답 완료!");
        messageMap.put(404, "페이지 찾을 수 없음...");
        messageMap.put(500, "서버 내부 오류 => 개발자 잘못!");

        return messageMap;
    }

    /*
    * image response
    *   produces 설정을 해주지 않으면 이미지가 텍스트로 변환된 형태그대로 출력된다.
    *   produces를 통해 response header의 content-type(MIME) 에 대한 설정을 해줄 수 있다.
    * */
    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage() throws IOException {

        return getClass().getResourceAsStream("/images/restapi.png").readAllBytes();
    }

    // ResponseEntity 를 이용한 응답
    @GetMapping("/entity")
    public ResponseEntity<Message> getEntity() {

        return ResponseEntity.ok(new Message(200, "정상응답맞니?"));
    }



}
