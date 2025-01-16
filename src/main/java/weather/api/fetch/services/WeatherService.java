package weather.api.fetch.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";


    @Value("${weather.api.key}")
    private String apiKey;

    public String getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?q=%s&appid=%s", API_URL, city, apiKey);
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
