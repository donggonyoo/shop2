package kr.gdu.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import kr.gdu.service.ShopService;

public class CountScheduler {

	@Autowired
	private ShopService service;
	
	private int cnt;
	
	/*
	@Scheduled(cron="0/5 * * * * ?") 
	@Scheduled(fixedRate = 5000) //이전작업의 시작시점부터 고정간격
	@Scheduled(fixedDelay = 5000) //이전작업의 종료시점부터 고정간격
	*/
	
	// 5초마다 실행되는 메서드 
	//@Scheduled(fixedDelay = 5000)
	public void execute1() {
		System.out.println("cnt : "+cnt++);
	}
	
	//5초 대기 후 3초마다 실행
	//@Scheduled(initialDelay=5000 , fixedRate = 3000)
	public void execute2() {
		System.out.println("5초대기 후 실행");
		System.out.println("3초마다실행");
	}
	/*
	 * cron
	 * 1.특정시간 , 주기적으로 프로그램을 실행
	 * 2.리눅스에서 crontab명령으로 설정 가능
	 * 
	 * 형식 : 초 분 시 일 월 요일
	 * 
	 * cron 예시
	 * 0/10 * * * * ? :10초마다한번씩
	 * 0 0/1 * * * ? : 1분마다 한번
	 * 0 20,50 * * * ? : 매 시 20,50분마다 실행
	 * 0 0 0/3 * * ? : 3시간마다 실행
	 * 0 0 12 ? * 1 : 월요일12시에실행
	 * 0 0 12 ? * MON : 월요일12시에실행
	 * 0 0 10 ? * 6,7 : 주말 10시에 실행
	 */
	
	//6월23일 12시20분에 실행해.!
	//@Scheduled(cron="0 20 12 23 6 ?")
		public void execute3() {
			System.out.println("현재시각 : "+new Date());
		}
		
	/*
	 * 1.매일 평일 아침10시30분에  환율(한국수출입은행)을 DB에 저장
	 * 
	 *  
	 */
		@Scheduled(cron="0 04 11 * * 1,2,3,4,5")
		public void exchange() {
			service.exchageCreate();
		}
	
	
}
