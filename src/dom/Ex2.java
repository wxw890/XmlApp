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
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();// xml���Ͽ� �����͸� �о�������� �̸� ��Ŭ������ �ִ� ������ ���� �ҷ��ü� �ִ�.
		DocumentBuilder builder = factory.newDocumentBuilder(); //factory.newDocumentBuilder();�� ���� xml������ �����͸� �����Ҽ� �ִ� �޸� ������ ������ش�.
		Document doc = builder.parse(new FileInputStream("D:\\3DP\\test.xml"));
		
		System.out.println(doc.getDocumentElement().getNodeName());
		
		Element root = doc.getDocumentElement();// import ��ų���� w3c�� xml�� ���õȰ��� import�ؾ��Ѵ�.
		
		for(Node n = root.getFirstChild(); n!=null; n=n.getNextSibling() ) //student ������ŭ
		{
			if(n.getNodeType()==Node.ELEMENT_NODE){   //Element�϶��� �����ϰڴ�.
				if(n.getNodeName().equals("student")){
					Document d = n.getOwnerDocument();
					Element e = d.createElement("address"); //Element <address>�� ������ش�.
					Text t = d.createTextNode("�����"); //����� �ؽ�Ʈ�� �������
					
					e.appendChild(t);//�ٿ��ر� <address>�����</address>
					n.appendChild(e);//<><> �ٿ��ر� <address>�����</address>
				}
			}
		}
		
		System.out.println("�۾� ��");
		//ȫ�浿�� �ּ� ���
		//System.out.println(root.getFirstChild().getLastChild().getTextContent());
		
		TransformerFactory transFactory = TransformerFactory.newInstance(); //�ٽ� ������ ��� �غ��Ҽ� �ִ� �޸� ������ ���������Ѵ�.
		Transformer trans = transFactory.newTransformer();
		
		trans.setOutputProperty(OutputKeys.ENCODING, "euc-kr");
		trans.setOutputProperty(OutputKeys.INDENT, "no");
		
		StreamResult result = new StreamResult(new FileOutputStream("D:\\3DP\\test.xml"));
		
		DOMSource source = new DOMSource(doc);//dom���� ����� �޸𸮿�
		trans.transform(source, result);//���������� ��� �غ��� �޸��� trans�� �ҽ��� ������
	}
}
