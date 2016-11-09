package com.be.ooxs.example.jaxb.extended;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Odyssey on 09.11.2016.
 */
public class ShortDateFormatter extends XmlAdapter<String, Date> {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String date) throws Exception {
        return formatter.parse(date);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return formatter.format(date);
    }
}
