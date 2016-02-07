package sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Ex2 extends DefaultHandler {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		
		SAXParserFactory factory = SAXParserFactory.newInstance(); // 삭스 공장 새로운 인스턴스 만들어준다.
		SAXParser parser = factory.newSAXParser();
		Ex2 ex = new Ex2();
		parser.parse("D:\\3DP\\poem.xml", ex);//ex는 자기 자신의 객체를 생성한 것이다.
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("문서의 끝");
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("문서의 시작");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException { //문자들을 만날대마다 호출된다.
		// TODO Auto-generated method stub
		for(int i=start ; i<start + length; i++){
			System.out.print(ch[i]);
		}
		System.out.println();
	}

	
}
