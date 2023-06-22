package com.janwojnar.meteoapp.web.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.janwojnar.meteoapp.util.OpenMeteoApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.time.LocalDate;

@Service
@Slf4j
public class OpenMeteoApiAdapter {

    private final String baseUrl = "https://archive-api.open-meteo.com/v1/archive";

    public OpenMeteoApiResponse getLastWeekRainingsAndDaytime(String longitude, String latitude, LocalDate start_date, LocalDate end_date){

        OpenMeteoApiResponse openMeteoApiResponse = new OpenMeteoApiResponse();

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();

            String encodedUrl = baseUrl +
                    "?latitude=" + URLEncoder.encode(String.valueOf(latitude), "UTF-8") +
                    "&longitude=" + URLEncoder.encode(String.valueOf(longitude), "UTF-8") +
                    "&start_date=" +URLEncoder.encode(String.valueOf(start_date),"UTF-8") +
                    "&end_date=" +URLEncoder.encode(String.valueOf(end_date),"UTF-8")+
                    "&daily=sunrise,sunset,rain_sum&timezone=Europe%2FBerlin";

            HttpGet request = new HttpGet(encodedUrl);
            HttpResponse response = httpClient.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());

            log.info("Request " + request.getMethod() + " on url " + encodedUrl + " proceeded.");

            ObjectMapper objectMapper = new ObjectMapper();
            openMeteoApiResponse = objectMapper.readValue(responseBody, OpenMeteoApiResponse.class);
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return openMeteoApiResponse;
    }
}
