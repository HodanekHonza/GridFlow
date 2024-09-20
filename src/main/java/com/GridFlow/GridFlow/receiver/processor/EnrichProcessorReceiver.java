package com.GridFlow.GridFlow.receiver.processor;

import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.receiver.api.dto.Message;
import com.GridFlow.GridFlow.receiver.api.dto.ParsedObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

import org.springframework.stereotype.Service;

@Service
public class EnrichProcessorReceiver implements Processor {

    @Override
    public void process(Message message) {
        // Unescape the JSON-escaped XML string
        String unescapedXml = unescapeJsonXml(message.getBody());

        // Parse the XML into ParsedObject
        try {
            ParsedObject parsedObject = parseXmlToObject(unescapedXml);
            // Handle parsedObject, e.g., log it or route it somewhere
            System.out.println("Parsed consumption: " + parsedObject.getConsumption());
            System.out.println("Parsed generation: " + parsedObject.getGeneration());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private String unescapeJsonXml(String jsonEscapedXml) {
        // Assuming the body has XML content escaped as JSON, you can unescape it as follows
        // Replace escaped quotes, ampersands, etc., for simplicity
        return jsonEscapedXml
                .replace("\\\"", "\"")
                .replace("\\n", "")
                .replace("\\t", "")
                .replace("\\/", "/");
    }

    private ParsedObject parseXmlToObject(String xmlBody) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ParsedObject.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (ParsedObject) unmarshaller.unmarshal(new StringReader(xmlBody));
    }
}

