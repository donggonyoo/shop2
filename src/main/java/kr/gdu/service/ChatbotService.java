package kr.gdu.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ChatbotService {
   
  public String getChatGPTResponse(String question) throws URISyntaxException, IOException, InterruptedException {      
      HttpClient client =HttpClient.newHttpClient();
      Map<String, Object> requestBody = new HashMap<>();
    final String API_KEY = "git으로올리지마!!!!!충돌남 (api_key는뭐 메일에저장해두고 필요할때만쓰던지해";
      final String ENDPOINT = "https://api.openai.com/v1/chat/completions";
      requestBody.put("model","gpt-3.5-turbo"); 
      requestBody.put("messages",new Object[] {
//            new HashMap<String,String>() {{
//               put("role","system");
//               put("content","당신은 전문가 입니다.");
//            }},
            new HashMap<String, String>() {{
               put("role","user");
               put("content",question); //내가 입력한 질문
            }}
      });
      //JSON 변환
      ObjectMapper objectMapper = new ObjectMapper();
      String requestBodyJson = objectMapper.writeValueAsString(requestBody);
      // HTTP 요청 생성
      HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(ENDPOINT)) //질문을 보낼 주소
            .header("Content-Type", "application/json") 
            .header("Authorization","Bearer " + API_KEY) //제품 키
            .POST(HttpRequest.BodyPublishers.ofString(requestBodyJson))//나의질문을 요청에담아
            .build();
      // 요청 보내고 응답 받기
      HttpResponse<String> response = 
            client.send(request, HttpResponse.BodyHandlers.ofString()); 
      
      //성공적으로 응답이왔다면
      if(response.statusCode() == 200) {
         Map<String, Object> responseBody = objectMapper.readValue(response.body(),new TypeReference<Map<String, Object>>() {});
         List<Map<String, Object>> choices = (List<Map<String,Object>>)responseBody.get("choices");
         Map<String, Object> firstChoice = choices.get(0);
         Map<String, String> message = (Map<String,String>)firstChoice.get("message");
         return message.get("content");//ai의 답
      }else {
         throw new RuntimeException("API 요청 실패 : " +response.body());
      }
   }
}