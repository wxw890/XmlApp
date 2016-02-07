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
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();// xml파일에 데이터를 읽어오기위해 미리 이클립스에 있는 공장을 통해 불러올수 있다.
		DocumentBuilder builder = factory.newDocumentBuilder(); //factory.newDocumentBuilder();란 실제 xml파일의 데이터를 저장할수 있는 메모리 공간을 만들어준다.
		Document doc = builder.parse(new FileInputStream("D:\\3DP\\netsong7.xml"));
		
		NodeList nodelist = doc.getElementsByTagName("company");
		
		System.out.println("다음은 netsong7의 자회사 목록입니다.");
		
		for(int i=0; i<nodelist.getLength(); i++){
			Node node = nodelist.item(i);
			Element element = (Element)node;
			
			NodeList urlList = element.getElementsByTagName("url");
			//url 출력
			Element urlElement = (Element)urlList.item(0);
			NodeList urlChilds = urlElement.getChildNodes();
			System.out.println("url : "+((Node)urlChilds.item(0)).getNodeValue());
			
			
			NodeList nameList = element.getElementsByTagName("name");
			//name출력
			Element nameElement = (Element)urlList.item(0);
			NodeList nameChilds = nameElement.getChildNodes();
			System.out.println("url : "+((Node)nameChilds.item(0)).getNodeValue());
			
			
			//System.out.println(urlList.item(i));
			//System.out.println(nameList.item(i));
		}
		
	}
}
