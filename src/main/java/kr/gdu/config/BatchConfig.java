package kr.gdu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import kr.gdu.util.CountScheduler;

@Configuration
@EnableScheduling //schedule기능 활성화
/*
 * @EnableScheduling은 Spring에서 스케줄링 기능을 활성화하여 
 * @Scheduled 어노테이션이 붙은 메서드를 주기적으로 실행하도록 설정합니다.
 */
public class BatchConfig {

	@Bean
	public CountScheduler countScheduler() {
		return new CountScheduler();
	}
}
