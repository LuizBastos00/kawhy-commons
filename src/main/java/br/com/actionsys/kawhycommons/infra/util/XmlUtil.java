package br.com.actionsys.kawhycommons.infra.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.tika.detect.EncodingDetector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.txt.UniversalEncodingDetector;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Slf4j
public class XmlUtil {

    public static Document buildDocument(byte[] bytes) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        String encode = detectEncoding(bytes);

        // Convertendo o arquivo para o encode identificado
        String fileConverted = new String(bytes, encode);

        return db.parse(new ByteArrayInputStream(fileConverted.getBytes(StandardCharsets.UTF_8)));
    }

    private static String detectEncoding(byte[] inputBytes) throws Exception {
        EncodingDetector encodingDetector = new UniversalEncodingDetector();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        Charset detectCharset = encodingDetector.detect(inputStream, new Metadata());

        return detectCharset.displayName();
    }

}
