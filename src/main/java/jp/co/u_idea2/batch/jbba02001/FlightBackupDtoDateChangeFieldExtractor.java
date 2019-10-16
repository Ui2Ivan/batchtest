package jp.co.u_idea2.batch.jbba02001;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.stereotype.Component;

@Component
public class FlightBackupDtoDateChangeFieldExtractor implements FieldExtractor<FlightBackupDto> {
    @Override
    public Object[] extract(FlightBackupDto item) {

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Object[] values = new Object[5];

        values[0] = dateFormat.format(item.getDepartureDate());
        values[1] = item.getFlightName();
        values[2] = item.getBoardingClassCd();
        values[3] = item.getFareTypeCd();
        values[4] = item.getVacantNum();

        return values;
    }

}
