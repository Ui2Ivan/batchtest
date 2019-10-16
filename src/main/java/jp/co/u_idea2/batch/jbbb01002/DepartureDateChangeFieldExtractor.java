package jp.co.u_idea2.batch.jbbb01002;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.stereotype.Component;

@Component
public class DepartureDateChangeFieldExtractor implements FieldExtractor<RouteAggregationDto> {
    @Override
    public Object[] extract(RouteAggregationDto item) {

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Object[] values = new Object[5];

        values[0] = dateFormat.format(item.getDepartureDate());
        values[1] = item.getDepAirport();
        values[2] = item.getArrAirport();
        values[3] = item.getPassengerNum();
        values[4] = item.getLoadFactor();

        return values;
    }

}
