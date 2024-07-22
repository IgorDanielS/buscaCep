package dio.springboot.services;

import com.google.gson.Gson;
import dio.springboot.app.ViaCepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CepService {
    private static final String VIACEP_URL = "https://viacep.com.br/ws/{cep}/json/";

    private final RestTemplate restTemplate;

    @Autowired
    private final Gson gson;

    public CepService(RestTemplate restTemplate, Gson gson) {
        this.restTemplate = restTemplate;
        this.gson = gson;
    }

    public ViaCepResponse getCepInfo(String cep) {
        String url = UriComponentsBuilder.fromUriString(VIACEP_URL)
                .buildAndExpand(cep)
                .toUriString();
        String response = restTemplate.getForObject(url, String.class);
        return gson.fromJson(response, ViaCepResponse.class);
    }
}
