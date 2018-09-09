package ofd;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ofd.complextype.DocBody;
import ofd.complextype.DocInfo;
import ofd.complextype.OFD;


public class OFDParser {

	public static final String docNS = "http://www.ofdspec.org";
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ParseException {
		// TODO Auto-generated method stub
		OFD ofd=makeOFD("ofdunzipfiles/ReaderManual/OFD.xml");
		
		for(DocBody docBody: ofd.getDocBody())
		{
			String docRoot=docBody.getDocRoot();
			Document doc=makeDocument(docRoot);
		}
	}
	
	//获得操作xml文件的对象  
    private static Document getDocument(String file) throws ParserConfigurationException,  
            SAXException, IOException {  
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();//得到创建 DOM 解析器的工厂。  
        factory.setNamespaceAware(true);
                
        DocumentBuilder builder = factory.newDocumentBuilder();//得到 DOM 解析器对象。  
        Document document = builder.parse(new File(file)); //得到代表整个文档的 Document 对象  
                
        // here is our vendor URL used in namepace-related functions:
        
          
        return document;  
    }  
    
	// 解析ofdxml文件获取OFD结构体信息
	public static OFD makeOFD(String ofdxml) throws ParserConfigurationException, SAXException, IOException, ParseException
	{
		Document document = getDocument(ofdxml);  
		Element e = document.getDocumentElement();
		
		
		OFD ofd=new OFD();
		
		NamedNodeMap attrMap=e.getAttributes();
		
		System.out.println(attrMap.getNamedItem("Version").getNodeValue());
		ofd.setVersion(attrMap.getNamedItem("Version").getNodeValue());
		
		System.out.println(attrMap.getNamedItem("DocType").getNodeValue());
		ofd.setDocType(attrMap.getNamedItem("DocType").getNodeValue());
		
		NodeList list = document.getElementsByTagNameNS(docNS, "DocBody");  
		Set<DocBody> docBodies=new HashSet<DocBody>();
		
		System.out.println(list.getLength());
		
		for(int i=0;i<list.getLength();i++)
		{
			Node docBodyNode = list.item(i);
			docBodies.add(makeDocBody(document, docBodyNode));
		}
		
//		
//        for(int i=0;i<list.getLength();i++){  
//            Element element = (Element) list.item(i);  
//            String value = element.getAttribute("examid");  
//            if(examid.equals(value)){  
//                Student student = new Student();  
//                student.setExamid(examid);  
//                student.setIdcard(element.getAttribute("idcard"));  
//                student.setName(element.getElementsByTagName("name").item(0).getTextContent());  
//                student.setLocation(element.getElementsByTagName("location").item(0).getTextContent());  
//                student.setGrade(element.getElementsByTagName("grade").item(0).getTextContent());  
//                return student;  
//            }  
//        }  
//        return null;  
		return ofd;
	}
	
	private static DocBody makeDocBody(Document document, Node node) throws ParseException
	{
		DocBody docBody=new DocBody();
		
		NodeList list=document.getElementsByTagNameNS(docNS, "DocInfo");
		Node docInfoNode=list.item(0);
		
		DocInfo docInfo=makeDocInfo(document, docInfoNode);	
		docBody.setDocInfo(docInfo);
		
		list=document.getElementsByTagNameNS(docNS, "DocRoot");
		if(list.getLength()>0)
		{
			Node docRootNode=list.item(0);
			String docRoot=docRootNode.getTextContent();
			
			System.out.println(docRoot);
			docBody.setDocRoot(docRoot);
		}
		
		list=document.getElementsByTagNameNS(docNS, "Signatures");
		if(list.getLength()>0)
		{
			Node signaturesNode=list.item(0);
			String signatures=signaturesNode.getTextContent();
			
			System.out.println(signatures);
			docBody.setSignatures(signatures);
		}
		
		return docBody;
	}
	
	private static DocInfo makeDocInfo(Document document, Node node) throws ParseException
	{
		DocInfo docInfo=new DocInfo(); 
		
		NodeList list=document.getElementsByTagNameNS(docNS, "DocID");
		if(list.getLength()>0)
		{
			Node docIDNode=list.item(0);
			String docID=docIDNode.getTextContent();
			
			System.out.println(docID);
			docInfo.setDocID(docID);
		}
		
		list=document.getElementsByTagNameNS(docNS, "Title");
		if(list.getLength()>0)
		{
			Node titleNode=list.item(0);
			String title=titleNode.getTextContent();
			
			System.out.println(title);
			docInfo.setTitle(title);
		}
		
		list=document.getElementsByTagNameNS(docNS, "Creator");
		if(list.getLength()>0)
		{
			Node creatorNode=list.item(0);
			String creator=creatorNode.getTextContent();
			
			System.out.println(creator);
			docInfo.setCreator(creator);
		}
		
		list=document.getElementsByTagNameNS(docNS, "CreationDate");
		if(list.getLength()>0)
		{
			Node creationDateNode=list.item(0);
			String creationDate=creationDateNode.getTextContent();
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=sdf.parse(creationDate);
			
			System.out.println(date);
			docInfo.setCreationDate(date);
		}
		
		list=document.getElementsByTagNameNS(docNS, "ModDate");
		if(list.getLength()>0)
		{
			Node modDateNode=list.item(0);
			String modDate=modDateNode.getTextContent();
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=sdf.parse(modDate);
			
			System.out.println(date);
			docInfo.setModDate(date);
		}
		
		return docInfo;
	}
	
	private Document makeDocument(String docRoot)
	{
		
		
		return null;
	}
	
}


















