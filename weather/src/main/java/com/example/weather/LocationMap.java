package com.example.weather;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletOutputStream;


@RestController
@Slf4j
public class LocationMap {

    @GetMapping("/GetLocationList")
    public String callApi() throws IOException {

        StringBuilder result = new StringBuilder();
        String key = "W5gGN77YkIbjO4bErMdc5ljC1YsBqJNjHgr4qK%2B9klvzmjnBt80TiOXkwhY07PbEVHrljwWrKFqHgov2daqFiA%3D%3D";
/**
 * http://apis.data.go.kr/6410000/GOA/GOA001?ServiceKey=서비스키&type=json&numOfRows=10&pageNo=1
 */
        String urlStr = "http://apis.data.go.kr/6410000/GOA/GOA001?ServiceKey="+key+"&type=json&numOfRows=10&pageNo=1";

        URL url = new URL(urlStr);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        log.info("urlConnection = {}",urlConnection);

        urlConnection.setRequestMethod("GET");

        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

        System.out.println("br = "+br);

        String returnLine;
        while ((returnLine = br.readLine()) != null){

            result.append(returnLine+"\n\r");

        }

        urlConnection.disconnect();

        /**
         * Json parsing
         */
        JSONParser parser = new JSONParser();

        JSONObject obj = null;
        JSONArray items = null;

        ArrayList<String> arrayList = new ArrayList<>();

        try {
            obj = (JSONObject)parser.parse(String.valueOf(result));
            items = (JSONArray) obj.get("items");
        } catch (ParseException e) {
            System.out.println("변환에 실패");
            e.printStackTrace();
        }

//        System.out.println(obj);
//        System.out.println(items.get(2));


        for(int i = 0; i < items.size(); i++){
            if (items.get(i) != null) {
                JSONObject jso = (JSONObject) items.get(i);

                String name = (String) jso.get("name");
                String busno = (String) jso.get("busno");

                Location location = new Location(name, busno);


            }
        }


        return result.toString();
    }
    /**
     * RestTemplate
     */
//    public String callApi() throws IOException{
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);//JSON 변환
//        headers.set("Authorization", "W5gGN77YkIbjO4bErMdc5ljC1YsBqJNjHgr4qK%2B9klvzmjnBt80TiOXkwhY07PbEVHrljwWrKFqHgov2daqFiA%3D%3D"); //appKey 설정
//
//
//        HttpEntity entity = new HttpEntity("parameters", headers);
//        URI url=URI.create("http://apis.data.go.kr/6410000/GOA/GOA001?ServiceKey=W5gGN77YkIbjO4bErMdc5ljC1YsBqJNjHgr4qK%2B9klvzmjnBt80TiOXkwhY07PbEVHrljwWrKFqHgov2daqFiA%3D%3D&type=json&numOfRows=10&pageNo=1");
//
//        ResponseEntity response= restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//
////        JSONParser jsonParser = new JSONParser();
////        JSONObject jsonObject = (JSONObject) jsonParser.parse(response.getBody().toString());
//        return "";
//    }

}
