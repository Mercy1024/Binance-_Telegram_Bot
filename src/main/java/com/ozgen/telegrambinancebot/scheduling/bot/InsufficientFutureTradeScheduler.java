package com.ozgen.telegrambinancebot.scheduling.bot;

import com.ozgen.telegrambinancebot.manager.bot.FutureTradeManager;
import com.ozgen.telegrambinancebot.model.TradeStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class InsufficientFutureTradeScheduler {

    private static final Logger log = LoggerFactory.getLogger(InsufficientFutureTradeScheduler.class);

    private final FutureTradeManager futureTradeManager;

    public InsufficientFutureTradeScheduler(FutureTradeManager futureTradeManager) {
        this.futureTradeManager = futureTradeManager;
    }

    @Scheduled(fixedRateString = "#{${app.bot.schedule.insufficient}}")
    public void processInsufficientFutureTrades() {
        this.futureTradeManager.processFutureTrades(TradeStatus.INSUFFICIENT);
    }
}