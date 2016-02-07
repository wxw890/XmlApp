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
	public void endDocument() throws SAXException { //�츮�� ȣ���ϴ� �޼��尡 �ƴ϶� �ݹ� �ż����̴�. �׷��Ƿ� ������ ������ ���� �������� ȣ���
		// TODO Auto-generated method stub
		System.out.println("������ ��<SaxTest>");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {//���� �±װ��� �������� ȣ��ɶ�
		// TODO Auto-generated method stub
		//System.out.println("���� �±� : " + uri + "," + localName + "," + qName);
		System.out.println(attributes.getLength());//attribute�� �������� 2, �� ���⼭�� loc �Ӽ�
		
		if(attributes.getLength() == 2){
			data.put(attributes.getValue("name"), attributes.getValue("value"));
		}
	}

	@Override
	public void startDocument() throws SAXException {//�츮�� ȣ���ϴ� �޼��尡 �ƴ϶� �ݹ� �ż����̴�. �׷��Ƿ� ������ ù ������ �������� ȣ���(�˾Ƽ� ȣ���)
		// TODO Auto-generated method stub
		System.out.println("������ ����</SaxTest>");
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		
		SAXParserFactory factory = SAXParserFactory.newInstance(); // �轺 ���� ���ο� �ν��Ͻ� ������ش�.
		SAXParser parser = factory.newSAXParser();
		Ex1 ex = new Ex1();
		parser.parse("D:\\3DP\\SaxTest.xml", ex);//ex�� �ڱ� �ڽ��� ��ü�� ������ ���̴�.
		
		
		
		System.out.println(ex.data.get("name"));
		System.out.println(ex.data.get("age"));
		System.out.println(ex.data.get("addr"));
		System.out.println(ex.data.get("tel"));
		
	}
}
