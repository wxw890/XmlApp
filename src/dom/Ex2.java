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
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Ex2 {
	public static void main(String[] args)throws ParserConfigurationException, FileNotFoundException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();// xml파일에 데이터를 읽어오기위해 미리 이클립스에 있는 공장을 통해 불러올수 있다.
		DocumentBuilder builder = factory.newDocumentBuilder(); //factory.newDocumentBuilder();란 실제 xml파일의 데이터를 저장할수 있는 메모리 공간을 만들어준다.
		Document doc = builder.parse(new FileInputStream("D:\\3DP\\test.xml"));
		
		System.out.println(doc.getDocumentElement().getNodeName());
		
		Element root = doc.getDocumentElement();// import 시킬때도 w3c나 xml에 관련된것을 import해야한다.
		
		for(Node n = root.getFirstChild(); n!=null; n=n.getNextSibling() ) //student 갯수만큼
		{
			if(n.getNodeType()==Node.ELEMENT_NODE){   //Element일때만 실행하겠다.
				if(n.getNodeName().equals("student")){
					Document d = n.getOwnerDocument();
					Element e = d.createElement("address"); //Element <address>를 만들어준다.
					Text t = d.createTextNode("서울시"); //서울시 텍스트가 만들어짐
					
					e.appendChild(t);//붙여준기 <address>서울시</address>
					n.appendChild(e);//<><> 붙여준기 <address>서울시</address>
				}
			}
		}
		
		System.out.println("작업 끝");
		//홍길동의 주소 출력
		//System.out.println(root.getFirstChild().getLastChild().getTextContent());
		
		TransformerFactory transFactory = TransformerFactory.newInstance(); //다시 보낼때 잠시 준비할수 있는 메모리 공간을 만들어줘야한다.
		Transformer trans = transFactory.newTransformer();
		
		trans.setOutputProperty(OutputKeys.ENCODING, "euc-kr");
		trans.setOutputProperty(OutputKeys.INDENT, "no");
		
		StreamResult result = new StreamResult(new FileOutputStream("D:\\3DP\\test.xml"));
		
		DOMSource source = new DOMSource(doc);//dom으로 저장된 메모리에
		trans.transform(source, result);//보내기전에 잠시 준비할 메모리인 trans에 소스를 저장함
	}
}
