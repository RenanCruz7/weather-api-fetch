package weather.api.fetch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import weather.api.fetch.model.WeatherResponse;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherResponse getWeather(String city) {
        String url = API_URL + "?q=" + city + "&appid=" + apiKey;
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}