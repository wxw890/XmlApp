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
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();// xml파일에 데이터를 읽어오기위해 미리 이클립스에 있는 공장을 통해 불러올수 있다.
		DocumentBuilder builder = factory.newDocumentBuilder(); //factory.newDocumentBuilder();란 실제 xml파일의 데이터를 저장할수 있는 메모리 공간을 만들어준다.
		Document doc = builder.parse(new FileInputStream("F:\\javastudy\\jsp\\test.xml"));
		
		System.out.println(doc.getDocumentElement().getNodeName());
		
		Element root = doc.getDocumentElement();// import 시킬때도 w3c나 xml에 관련된것을 import해야한다.
		
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
