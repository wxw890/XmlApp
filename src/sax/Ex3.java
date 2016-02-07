package sax;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Ex3 extends DefaultHandler {
	private PhoneDto phonebook;
	private ArrayList<PhoneDto> phonelist;
	private String position="";
	
	public ArrayList<PhoneDto> getArrayList(){
		return phonelist;
	}
	//ArrayList에다가 Dto를 통해 데이터를 모아두기 위해서 오버라이딩 메서드들이 필요하다.
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException { 
		// TODO Auto-generated method stub
		if(position.equals("firstname")){
	         phonebook.setFirstname(new String(ch, start, length));
	      }else if(position.equals("lastname")){
	         phonebook.setLastname(new String(ch, start, length));
	      }else if(position.equals("address")){
	         phonebook.setAddress(new String(ch, start, length));
	      }else if(position.equals("home")){
	         phonebook.setHomephone(new String(ch, start, length));
	      }else if(position.equals("work")){
	         phonebook.setWorkphone(new String(ch, start, length));
	      }else if(position.equals("mobile")){
	         phonebook.setMobilephone(new String(ch, start, length));
	      }
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if(qName.equals("PhoneBookEntry")){
			phonelist.add(phonebook);
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if(qName.equals("PhoneBookEntry")){
			phonebook = new PhoneDto();
		}
		else if(qName.equals("firstname")){
			position = "firstname";
		}
		else if(qName.equals("lastname")){
			position = "lastname";
		}
		else if(qName.equals("address")){
			position = "address";
		}
		else if(qName.equals("phone")){
			String attr = attributes.getValue("loc");
			position = attr;
		}
	}

	@Override
	public void startDocument() throws SAXException { //startDocument()는 가장 먼저 실행이된다 
		// TODO Auto-generated method stub
		phonelist = new ArrayList<PhoneDto>(); //우선 리스트 초기화 작업
		
		
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		Ex3 ex = new Ex3();
		parser.parse("D:\\3DP\\PhoneBook.xml", ex);
		
		ArrayList<PhoneDto> arr = ex.getArrayList();
		System.out.println(arr.size());
	}

	
}
