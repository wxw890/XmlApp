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
		
		SAXParserFactory factory = SAXParserFactory.newInstance(); // �轺 ���� ���ο� �ν��Ͻ� ������ش�.
		SAXParser parser = factory.newSAXParser();
		Ex2 ex = new Ex2();
		parser.parse("D:\\3DP\\poem.xml", ex);//ex�� �ڱ� �ڽ��� ��ü�� ������ ���̴�.
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("������ ��");
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("������ ����");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException { //���ڵ��� �����븶�� ȣ��ȴ�.
		// TODO Auto-generated method stub
		for(int i=start ; i<start + length; i++){
			System.out.print(ch[i]);
		}
		System.out.println();
	}

	
}
