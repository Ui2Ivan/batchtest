package jp.co.u_idea2.batch.jbba02001;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.stereotype.Component;

@Component
public class ReserveFlightBackupDtoDateChangeFieldExtractor implements FieldExtractor<ReserveFlightBackupDto> {
    @Override
    public Object[] extract(ReserveFlightBackupDto item) {

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Object[] values = new Object[6];

        values[0] = item.getReserveFlightNo();
        values[1] = item.getReserveNo();
        values[2] = dateFormat.format(item.getDepartureDate());
        values[3] = item.getFlightName();
        values[4] = item.getBoardingClassCd();
        values[5] = item.getFareTypeCd();

        return values;
    }

}
