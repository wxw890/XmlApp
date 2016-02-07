package dom;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Ex1 {
	public static void main(String[] args)throws ParserConfigurationException, FileNotFoundException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();// xml���Ͽ� �����͸� �о�������� �̸� ��Ŭ������ �ִ� ������ ���� �ҷ��ü� �ִ�.
		DocumentBuilder builder = factory.newDocumentBuilder(); //factory.newDocumentBuilder();�� ���� xml������ �����͸� �����Ҽ� �ִ� �޸� ������ ������ش�.
		Document doc = builder.parse(new FileInputStream("F:\\javastudy\\jsp\\test.xml"));
		
		System.out.println(doc.getDocumentElement().getNodeName());
		
		Element root = doc.getDocumentElement();// import ��ų���� w3c�� xml�� ���õȰ��� import�ؾ��Ѵ�.
		
		System.out.println(root.getNodeName());
		System.out.println(root.getNodeType());
		System.out.println(root.getNodeValue());
		
		System.out.println("-------------------------------------------");
		
		Node n1 = root.getFirstChild();
		System.out.println(n1.getNodeName());
		System.out.println(n1.getNodeType());
		System.out.println(n1.getNodeValue());
		
		System.out.println("-------------------------------------------");
		
		System.out.println(n1.getFirstChild().getNodeName());
		System.out.println(n1.getFirstChild().getNodeType());
		System.out.println(n1.getFirstChild().getNodeValue());
		
		System.out.println("-------------------------------------------");
		
		System.out.println(n1.getFirstChild().getFirstChild().getNodeName());
		System.out.println(n1.getFirstChild().getTextContent());
		
		System.out.println("-------------------------------------------");
		System.out.println(n1.getLastChild().getTextContent());
	}
}
