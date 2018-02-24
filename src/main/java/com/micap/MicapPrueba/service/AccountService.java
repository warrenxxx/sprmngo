package com.micap.MicapPrueba.service;

import com.micap.MicapPrueba.entity.Account;
import com.micap.MicapPrueba.entity.User;
import com.micap.MicapPrueba.repository.AccountDaoImp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class AccountService {
    @Autowired
    private AccountDaoImp accountDaoImp;
    public Mono<ServerResponse> UserOfAccount(ServerRequest req){
        return ok().body( accountDaoImp.UserOfAccount(req.bodyToMono(Account.class).block()),User.class);
    }
//                        GET("/"),Req->ok().body(accountDaoImp.accountDao.findAll(), Account.class)
    public Mono<ServerResponse> getAccounts(ServerRequest req){
        return ok().body(accountDaoImp.accountDao.findAll(),Account.class);
    }

}
