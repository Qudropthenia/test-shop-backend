package ru.quadrophenia.test.testshop.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import ru.quadrophenia.test.testshop.domain.entity.Goods;
import ru.quadrophenia.test.testshop.domain.mixin.GoodsMixIn;

@SpringBootConfiguration
public class JacksonCustomization {
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer customizer() {
		return jacksonObjectMapperBuilder -> {
//			jacksonObjectMapperBuilder.mixIn(Goods.class, GoodsMixIn.class);
		};
	}
}
