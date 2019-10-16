package jp.co.u_idea2.batch.jbbb01001;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.stereotype.Component;

@Component
public class WriteHeaderFlatFileHeaderCallback implements FlatFileHeaderCallback {

    @Override
    public void writeHeader(Writer writer) throws IOException {

        writer.write("\"予約番号\",\"便名\",\"搭乗日\",\"運賃種別\",\"出発空港\",\"出発時刻\",\"到着空港\",\"到着時刻\",\"合計金額\"");

    }

}
