package com.micap.MicapPrueba;

import com.micap.MicapPrueba.entity.Account;
import com.micap.MicapPrueba.entity.User;
import com.micap.MicapPrueba.repository.AccountDao;
import com.micap.MicapPrueba.repository.AccountDaoImp;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class MicapPruebaApplication {

	/*
	@Bean
	CommandLineRunner nombre(AccountDaoImp accountDaoImp){
		String g[]=new String[3];
		g[0]="984237481";
		g[1]="984237482";
		g[2]="984237483";
		return args -> {
			accountDaoImp.accountDao.deleteAll().subscribe(null,null,()->{
				Stream.of("warren erick jhon roger paul".split(" "))
						.map(user->new Account(new ObjectId(),user+"@gmail.com","123456",user,new User("warrrencio","aroni",new Date(),"masculino"),g))
						.forEach(user->accountDaoImp.accountDao.insert(user).subscribe(System.out::println));
			});
		};
	}
*/

	public static void main(String[] args) {
		SpringApplication.run(MicapPruebaApplication.class, args);
	}
}
