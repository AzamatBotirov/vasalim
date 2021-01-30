package com.salom.vasalim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.xml.crypto.Data;
import java.util.Date;

@EnableScheduling
@SpringBootApplication
public class VasalimApplication {

	public static void main(String[] args) {
		SpringApplication.run(VasalimApplication.class, args);
	}

//	@Scheduled(fixedDelay = 1000L)
	public void star(){
		System.out.println("yangi vaqt"+ new Date());
	}

//	@Scheduled(fixedRate = 3000l)
	public void starR(){
		System.out.println("3yangi vaqt"+ new Date());
	}
//	@Scheduled(cron = "0 53 19 * * *")
	public void starDelay(){
		System.out.println("000yangi vaqt"+ new Date());
	}

}
