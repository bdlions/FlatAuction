package com.auction.library;

import com.auction.dto.Stat;
import com.auction.dto.StayList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author nazmul hasan
 */
public class ProductLibrary {
    public List<Stat> getStatList(String startDate, String endDate, int productId)
    {
        List<Stat> statList = new ArrayList<>();
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        Random random = new Random();
        if(startDate.compareTo(endDate) > 0)
        {
            return statList;
        }
        else if(startDate.equals(endDate))
        {
            Stat stat = new Stat();
            stat.setDate(start.toString());
            stat.setClicks(random.nextInt(100)+"");
            stat.setImpressions(random.nextInt(100)+"");
            stat.setCtr(random.nextInt(100)+"%");
            stat.setCost(random.nextInt(100));
            statList.add(stat);
        }
        else if(startDate.compareTo(endDate) < 0)
        {
            while (!start.isAfter(end)) {
                Stat stat = new Stat();
                stat.setDate(start.toString());
                stat.setClicks(random.nextInt(100)+"");
                stat.setImpressions(random.nextInt(100)+"");
                stat.setCtr(random.nextInt(100)+"%");
                stat.setCost(random.nextInt(100));
                statList.add(stat);
                start = start.plusDays(1);           
            }
        }
        return statList;
    }
}
