package dom;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Ex3 {
	public static void main(String[] args) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();// xml���Ͽ� �����͸� �о�������� �̸� ��Ŭ������ �ִ� ������ ���� �ҷ��ü� �ִ�.
		DocumentBuilder builder = factory.newDocumentBuilder(); //factory.newDocumentBuilder();�� ���� xml������ �����͸� �����Ҽ� �ִ� �޸� ������ ������ش�.
		Document doc = builder.parse(new FileInputStream("D:\\3DP\\netsong7.xml"));
		
		NodeList nodelist = doc.getElementsByTagName("company");
		
		System.out.println("������ netsong7�� ��ȸ�� ����Դϴ�.");
		
		for(int i=0; i<nodelist.getLength(); i++){
			Node node = nodelist.item(i);
			Element element = (Element)node;
			
			NodeList urlList = element.getElementsByTagName("url");
			//url ���
			Element urlElement = (Element)urlList.item(0);
			NodeList urlChilds = urlElement.getChildNodes();
			System.out.println("url : "+((Node)urlChilds.item(0)).getNodeValue());
			
			
			NodeList nameList = element.getElementsByTagName("name");
			//name���
			Element nameElement = (Element)urlList.item(0);
			NodeList nameChilds = nameElement.getChildNodes();
			System.out.println("url : "+((Node)nameChilds.item(0)).getNodeValue());
			
			
			//System.out.println(urlList.item(i));
			//System.out.println(nameList.item(i));
		}
		
	}
}
