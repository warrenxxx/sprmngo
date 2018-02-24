package com.micap.MicapPrueba.controller;

import com.micap.MicapPrueba.entity.Account;
import com.micap.MicapPrueba.entity.User;
import com.micap.MicapPrueba.repository.AccountDaoImp;
import com.micap.MicapPrueba.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Service for  Account
 * Create by Warren Stephen Aroni soto
 * Creation Date 24/02/2018
 */
@Configuration
public class AccountController {

    @Autowired
    AccountService accountService;

    @Bean
    RouterFunction<ServerResponse> Routes(AccountDaoImp accountDaoImp) {
        return nest(path("/account"),
                route(
                        GET("/"), Req -> accountService.getAccounts(Req)
                ).andRoute(
                        GET("/{id}"), Req -> ok().body(accountDaoImp.accountDao.findById(Req.pathVariable("id")), Account.class)
                ).andRoute(
                        POST("/"), Req -> ok().body(accountDaoImp.accountDao.insert(Req.bodyToMono(Account.class)), Account.class)
                ).andRoute(
                        POST("/user"), Req -> ok().body(accountDaoImp.UserOfAccount(Req.bodyToMono(Account.class).block()), User.class))
        );
    }
}

