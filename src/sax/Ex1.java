package sax;



import java.io.IOException;
import java.util.Hashtable;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Ex1 extends DefaultHandler {
	private Hashtable<String, String> data = new Hashtable<String, String>();
	@Override
	public void endDocument() throws SAXException { //우리가 호출하는 메서드가 아니라 콜백 매서드이다. 그러므로 문서의 마지막 끝에 만났을때 호출됨
		// TODO Auto-generated method stub
		System.out.println("문서의 끝<SaxTest>");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {//시작 태그가를 만났을때 호출될때
		// TODO Auto-generated method stub
		//System.out.println("시작 태그 : " + uri + "," + localName + "," + qName);
		System.out.println(attributes.getLength());//attribute가 있을때만 2, 즉 여기서는 loc 속성
		
		if(attributes.getLength() == 2){
			data.put(attributes.getValue("name"), attributes.getValue("value"));
		}
	}

	@Override
	public void startDocument() throws SAXException {//우리가 호출하는 메서드가 아니라 콜백 매서드이다. 그러므로 문서의 첫 시작을 만났을때 호출됨(알아서 호출됨)
		// TODO Auto-generated method stub
		System.out.println("문서의 시작</SaxTest>");
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		
		SAXParserFactory factory = SAXParserFactory.newInstance(); // 삭스 공장 새로운 인스턴스 만들어준다.
		SAXParser parser = factory.newSAXParser();
		Ex1 ex = new Ex1();
		parser.parse("D:\\3DP\\SaxTest.xml", ex);//ex는 자기 자신의 객체를 생성한 것이다.
		
		
		
		System.out.println(ex.data.get("name"));
		System.out.println(ex.data.get("age"));
		System.out.println(ex.data.get("addr"));
		System.out.println(ex.data.get("tel"));
		
	}
}
