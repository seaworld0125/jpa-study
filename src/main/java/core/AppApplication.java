package core;

import core.query.Member;
import core.query.MemberJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppApplication.class, args);
	}
}
