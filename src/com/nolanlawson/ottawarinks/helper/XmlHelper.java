package com.nolanlawson.ottawarinks.helper;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.nolanlawson.ottawarinks.data.EventResponse;
import com.nolanlawson.ottawarinks.data.EventResponsePage;
import com.nolanlawson.ottawarinks.util.UtilLogger;

public class XmlHelper {

	private static UtilLogger log = new UtilLogger(XmlHelper.class);
	
	private static final String NAME_ATTRIBUTE = "name";
	
	public static EventResponsePage parseEventResponsePage(String xml) {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		try {
			SAXParser parser = factory.newSAXParser();
			EventResponseHandlerBase handlerBase = new EventResponseHandlerBase();
			InputSource inputSource = new InputSource();
			inputSource.setCharacterStream(new StringReader(xml));
			parser.parse(inputSource, handlerBase);
			return handlerBase.getEventResponsePage();
		} catch (SAXException e) {
			log.e(e, "");
		} catch (ParserConfigurationException e) {
			log.e(e, "");
		} catch (IOException e) {
			log.e(e, "");
		}
		
		return null;
		
		
	}
	
	private static class EventResponseHandlerBase extends HandlerBase {

		private static enum XmlTag {
			startRow, toRow, totalRows, str, doc;
		}
		private static enum StrTag {
			day, dayNo, end_date, end_time, event, location, location_alt, location_map, location_url, region, session_type,
			start_date, start_time
		}
		
		private EventResponsePage eventResponsePage = new EventResponsePage();
		private EventResponse currentEventResponse;
		private String tempVal;
		
		
		@Override
		public void startElement(String name, AttributeList attributes) throws SAXException {
			super.startElement(name, attributes);
			
			try {
				XmlTag xmlTag = XmlTag.valueOf(name);
				switch (xmlTag) {
				case startRow:
					eventResponsePage.setStartRow(Integer.parseInt(tempVal));
					break;
				case toRow:
					eventResponsePage.setToRow(Integer.parseInt(tempVal));
					break;
				case totalRows:
					eventResponsePage.setTotalRows(Integer.parseInt(tempVal));
					break;
				case doc:
					currentEventResponse = new EventResponse();
					break;
				case str:
					handleStrTag(attributes);
					break;
				}
			} catch (IllegalArgumentException ignore) { }
		}
		
		private void handleStrTag(AttributeList attributes) {
			try {
				StrTag strTag = StrTag.valueOf(attributes.getValue(NAME_ATTRIBUTE));
				
				// TODO
			} catch (IllegalArgumentException ignore) {
			} catch (NullPointerException ignore) {}
			
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			super.characters(ch, start, length);
			tempVal = new String(ch, start, length);
		}

		@Override
		public void endElement(String name) throws SAXException {
			super.endElement(name);
			try {
				XmlTag xmlTag = XmlTag.valueOf(name);
				switch (xmlTag) {
				case doc:
					eventResponsePage.getEventResponses().add(currentEventResponse);
					break;
				}
			} catch (IllegalArgumentException ignore) {}
		}

		public EventResponsePage getEventResponsePage() {
			return eventResponsePage;
		}
		
	}	
}
