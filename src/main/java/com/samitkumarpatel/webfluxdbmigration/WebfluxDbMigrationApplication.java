package com.samitkumarpatel.webfluxdbmigration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class WebfluxDbMigrationApplication {
	private UserAccountsRepository userAccountsRepository;
	WebfluxDbMigrationApplication(UserAccountsRepository userAccountsRepository) {
		this.userAccountsRepository = userAccountsRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(WebfluxDbMigrationApplication.class, args);
	}

	@Bean
	RouterFunction routerFunction() {
		return RouterFunctions
				.route()
				.GET("/user-account/{id}", serverRequest -> {
					var id = serverRequest.pathVariable("id");
					return ServerResponse.ok().body(userAccountsRepository.findById(Long.valueOf(id)), UserAccounts.class);
				})
				.build();
	}
}
enum AccountType {
	SAVINGS_ACCOUNT, CURRENT_ACCOUNT
}
record Accounts(@Id Long id, @Column("account_type") AccountType accountType, Float balance){}
record Users(@Id Long id, String name, String email, String password, @Column("account_no") Long accountNumber){}
record UserAccounts(@Id Long id, String name, String email, @Column("account_no") Long accountNumber, Float balance){}

interface UsersRepository extends R2dbcRepository<Users, Long> {}
interface AccountsRepository extends R2dbcRepository<Accounts, Long> {}
interface UserAccountsRepository extends R2dbcRepository<UserAccounts, Long> {}