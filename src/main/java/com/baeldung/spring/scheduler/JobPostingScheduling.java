package com.baeldung.spring.scheduler;


import java.util.List;

import com.baeldung.spring.dao.JobPostingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class JobPostingScheduling {

    @Autowired
    JobPostingDao jobPostingDao;


    @Scheduled(cron="0 25 21 * * MON-FRI")
    public void doDailyUpdate() {
        // update the job posting from the company

    }


    private void writeDailyUpdatesToTicker() {
//        try {
//            tickerService.writeToDatabaseDailyPriceRecordFor(ticker);
//        }
//        catch (DataAccessException ex) {
//            System.out.println("Already updated record for " + ticker.getSymbol() + ".");
//        }
//        catch (FailedDownloadException ex) {
//            System.out.println("Could not download record for " + ticker.getSymbol() + " this time.");
//        }
    }


    @Scheduled(cron="0 0 0 * * SUN")
    public void doCompleteUpdate() {
//        List<Ticker> tickers = tickerService.loadAllTickers();
//        for(Ticker t : tickers)
//            if(tickerService.loadEagerTickerWithSymbol(t.getSymbol()).getPriceRecords().isEmpty())
//                tickerService.writeToDatabaseAllPriceRecordsFor(t);
//    }
    }
}