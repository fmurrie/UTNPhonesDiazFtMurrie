package com.utnphones.UTNPhonesDiazFtMurrie.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class SessionScheduler
{
    //region Properties:
    @Autowired
    SessionManager sessionManager;
    //endregion

    //region Methods:
    @Async
    @Scheduled(fixedRate = 10000000)
    public void expiresSessions() {
        sessionManager.expireSessions();
    }
    //endregion
}
