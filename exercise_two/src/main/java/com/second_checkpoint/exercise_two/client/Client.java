package com.second_checkpoint.exercise_two.client;

import com.second_checkpoint.exercise_two.constant.Constants;
import com.second_checkpoint.exercise_two.dto.item.Item;
import com.second_checkpoint.exercise_two.dto.item.ItemResponse;
import com.second_checkpoint.exercise_two.dto.jwt.Login;
import com.second_checkpoint.exercise_two.util.MapperUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@Component
public class Client {

    private HttpHeaders headers;
    private String token;
    private RestTemplate restTemplate = new RestTemplate();
    private HttpEntity<Login> entity;

    private String getToken() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        entity = new  HttpEntity<Login>(new Login(Constants.USER_EXERCISE_ONE, Constants.PASSWORD),headers);
        token = restTemplate.exchange(Constants.JWT_URL, HttpMethod.POST, entity, String.class).getBody();
        return token;
    }

    public Item getItem(String id){
        token = getToken();
        HttpEntity httpEntity = new HttpEntity<>(headers);
        headers.setBearerAuth(token);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        ItemResponse response = restTemplate.exchange(Constants.ITEM_URL+id, HttpMethod.GET, httpEntity, ItemResponse.class).getBody();
        return setItemResponse(response, id);
    }

    public Item setItemResponse(ItemResponse response, String id){
        Item item = MapperUtil.toItem(response);
        item.setImages(response.getImages());
        item.setCurrencyId(Integer.parseInt(response.getCurrency()));
        item.setId(Integer.parseInt(id));
        return item;
    }
}
