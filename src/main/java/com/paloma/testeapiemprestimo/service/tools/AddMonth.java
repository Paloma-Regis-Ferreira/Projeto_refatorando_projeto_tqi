package com.paloma.testeapiemprestimo.service.tools;

import java.util.Calendar;
import java.util.Date;

public class AddMonth {

    public Date executeAddMonth(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, i);
        return calendar.getTime();
    }
}
