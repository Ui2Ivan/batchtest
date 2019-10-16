package jp.co.u_idea2.batch.jbbb01003;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.stereotype.Component;

@Component
public class DepartureDateChangeFieldExtractor implements FieldExtractor<FareTypeAggregationDto> {
    @Override
    public Object[] extract(FareTypeAggregationDto item) {

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Object[] values = new Object[4];

        values[0] = dateFormat.format(item.getDepartureDate());
        values[1] = item.getFlightName();
        values[2] = item.getFareTypeName();
        values[3] = item.getPassengerNum();

        return values;
    }

}
