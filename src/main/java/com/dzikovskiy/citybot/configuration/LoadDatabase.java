package com.dzikovskiy.citybot.configuration;

import com.dzikovskiy.citybot.entity.City;
import com.dzikovskiy.citybot.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CityRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(
                    new City("Минск", "Троицкое предместье." +
                            " Первые упоминания о нем встречаются в 12 веке." +
                            " В 1505 город сожгли татары, но через 100 лет он не только был восстановлен, " +
                            "но и стал важным общественным центром. В начале 19 века огонь опять уничтожил Троицкое предместье, " +
                            "после чего была разработана новая планировка, утвержденная Александром I и " +
                            "частично сохранившаяся до наших дней. В то время тут жили крестьяне, торговцы, " +
                            "рабочие и мелкие чиновники.")));
            log.info("Preloading " + repository.save(
                    new City("Киев", "Золотые ворота. " +
                    "С эпохи правления Ярослава Мудрого прекрасно сохранился архитектурный и исторический памятник " +
                    "- Золотые Ворота. Он может поведать самые интересные факты об оборонном зодчестве того времени. " +
                    "Тогда сооружение представляло собой грандиозную крепость, имеющую широкий проезд. " +
                    "Оценить все величие башни, можно только при ее посещении. " +
                    "В настоящее время в здании Золотых ворот работает интересная музейная экспозиция.")));
        };
    }
}
