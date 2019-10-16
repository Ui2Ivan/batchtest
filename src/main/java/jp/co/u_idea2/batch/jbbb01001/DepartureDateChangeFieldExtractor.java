package jp.co.u_idea2.batch.jbbb01001;

import java.text.SimpleDateFormat;

import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.stereotype.Component;

@Component
public class DepartureDateChangeFieldExtractor implements FieldExtractor<ReservationDto> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    @Override
    public Object[] extract(ReservationDto item) {

        Object[] values = new Object[9];

        values[0] = item.getReserveNo();
        values[1] = item.getFlightName();
        values[2] = dateFormat.format(item.getDepartureDate());
        values[3] = item.getFareTypeName();
        values[4] = item.getDepAirport();
        values[5] = item.getDepartureTime();
        values[6] = item.getArrAirport();
        values[7] = item.getArrivalTime();
        values[8] = item.getTotalFare();

        return values;
    }

}
