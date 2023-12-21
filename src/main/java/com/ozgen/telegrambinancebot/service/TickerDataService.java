package com.ozgen.telegrambinancebot.service;

import com.ozgen.telegrambinancebot.model.binance.TickerData;
import com.ozgen.telegrambinancebot.repository.TickerDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TickerDataService {
    private static final Logger log = LoggerFactory.getLogger(TickerDataService.class);

    private final TickerDataRepository tickerDataRepository;


    public TickerDataService(TickerDataRepository tickerDataRepository) {
        this.tickerDataRepository = tickerDataRepository;
    }

    public TickerData createTickerData(TickerData tickerData) {
        return this.tickerDataRepository.save(tickerData);
    }

    public TickerData findOne(UUID id) {
        return tickerDataRepository.findById(id).orElse(null);
    }

}