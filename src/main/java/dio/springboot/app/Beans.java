package dio.springboot.app;

import com.google.gson.Gson;
import dio.springboot.services.CepService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Beans {
    @Bean
    public Gson gson()
    {
        return new Gson();
    }

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
    @Bean
    public CommandLineRunner run(ConversorJson conversor, CepService cepService) throws Exception{
        return args -> {
            String cep = "23812310";
            ViaCepResponse response = cepService.getCepInfo(cep);
            System.out.println("Dados: " + response);
        };
    }
}
