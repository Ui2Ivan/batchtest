package jp.co.u_idea2.batch.jbbb01003;

import java.io.IOException;

import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.stereotype.Component;

@Component
public class WriteHeaderFlatFileHeaderCallback implements FlatFileHeaderCallback {

    @Override
    public void writeHeader(Writer writer) throws IOException {
        writer.write("\"搭乗日\",\"便名\",\"運賃種別\",\"搭乗者数\"");

    }

}
