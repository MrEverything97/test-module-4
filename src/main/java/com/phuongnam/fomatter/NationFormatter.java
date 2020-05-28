package com.phuongnam.fomatter;

import com.phuongnam.model.Nation;
import com.phuongnam.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import java.util.Locale;

@Component
public class NationFormatter implements Formatter<Nation> {
    private NationService nationService;
    @Autowired
    public NationFormatter(NationService nationService){
        this.nationService=nationService;
    }
    @Override
    public Nation parse(String text, Locale locale) throws ParseException {
        return nationService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Nation object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
