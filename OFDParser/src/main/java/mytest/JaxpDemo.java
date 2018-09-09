package mytest;

import java.io.BufferedReader;  
import java.io.File;  
import java.io.IOException;  
import java.io.InputStreamReader;  
  
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;  
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerException;  
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.dom.DOMSource;  
import javax.xml.transform.stream.StreamResult;  
  
import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;  
import org.xml.sax.SAXException;  
  
public class JaxpDemo {  
  
    /** 
     * @param args 
     * @throws IOException  
     */  
    public static void main(String[] args) throws Exception {  
  
          
        System.out.print("添加用户：(a)  ");  
        System.out.print("删除用户：(b)  ");  
        System.out.println("查询成绩：(c)");  
        System.out.print("请输入操作类型：");  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        String type = br.readLine();  
          
        if("a".equals(type)){  
              
            //添加用户  
            Student student = new Student();  
            System.out.print("请输入学生姓名：");  
            String name = br.readLine();  
            student.setName(name);  
            System.out.print("请输入学生准考证号：");  
            String examid = br.readLine();  
            student.setExamid(examid);  
            System.out.print("请输入学生身份证号：");  
            String idcard = br.readLine();  
            student.setIdcard(idcard);  
            System.out.print("请输入学生所在地：");  
            String location = br.readLine();  
            student.setLocation(location);  
            System.out.print("请输入学生成绩：");  
            String grade = br.readLine();  
            student.setGrade(grade);  
              
            add(student);  
            System.out.println("------添加数据成功------");  
        }else if("b".equals(type)){  
            //删除用户  
            System.out.print("请输入删除的学生姓名：");  
            String name = br.readLine();  
            delete(name);  
            System.out.println("------已成功删除学生信息------");  
              
        }else if("c".equals(type)){  
            //查询成绩  
            System.out.print("请输入查询的学生准考证号：");  
            String examid = br.readLine();  
            Student student = find(examid);  
            System.out.println("您查询的学生信息为：");  
            System.out.println(student);  
              
        }else{  
            System.out.println("对不起，您的操作有误！！");  
        }  
    }  
  
    private static Student find(String examid) throws Exception {  
  
        Document document = getDocument();  
        NodeList list = document.getElementsByTagName("student");  
        for(int i=0;i<list.getLength();i++){  
            Element element = (Element) list.item(i);  
            String value = element.getAttribute("examid");  
            if(examid.equals(value)){  
                Student student = new Student();  
                student.setExamid(examid);  
                student.setIdcard(element.getAttribute("idcard"));  
                student.setName(element.getElementsByTagName("name").item(0).getTextContent());  
                student.setLocation(element.getElementsByTagName("location").item(0).getTextContent());  
                student.setGrade(element.getElementsByTagName("grade").item(0).getTextContent());  
                return student;  
            }  
        }  
        return null;  
    }  
  
    private static void delete(String name) throws ParserConfigurationException, SAXException, IOException, TransformerException {  
        Document document = getDocument();  
        NodeList list = document.getElementsByTagName("name");  
        for(int i=0;i<list.getLength();i++){  
            Node node = list.item(i);  
            if(node.getTextContent().equals(name)){  
                node.getParentNode().getParentNode().removeChild(node.getParentNode());  
            }  
        }  
        writeXml(document);  
    }  
  
    private static void add(Student student) throws Exception {  
          
        Document document = getDocument();  
          
        Element student_node = document.createElement("student");  
        student_node.setAttribute("idcard", student.getIdcard());  
        student_node.setAttribute("examid", student.getExamid());  
          
        Node name = document.createElement("name");  
        name.setTextContent(student.getName());  
        Node location = document.createElement("location");  
        location.setTextContent(student.getLocation());  
        Node grade = document.createElement("grade");  
        grade.setTextContent(student.getGrade());  
          
        student_node.appendChild(name);  
        student_node.appendChild(location);  
        student_node.appendChild(grade);  
          
        Element root = document.getDocumentElement();  
        root.appendChild(student_node);  
          
        writeXml(document);  
    }  
  
    //将内存中的数据保存到XML文件中  
    private static void writeXml(Document document) throws TransformerException {  
          
        DOMSource source = new DOMSource(document);  
        StreamResult result = new StreamResult(new File("src/exam.xml"));  
          
        TransformerFactory factory = TransformerFactory.newInstance();  
        Transformer trans = factory.newTransformer();  
        trans.transform(source, result);  
    }    
  
    //获得操作xml文件的对象  
    private static Document getDocument() throws ParserConfigurationException,  
            SAXException, IOException {  
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();//得到创建 DOM 解析器的工厂。  
        DocumentBuilder builder = factory.newDocumentBuilder();//得到 DOM 解析器对象。  
        Document document = builder.parse(new File("xmlfiles/exam.xml")); //得到代表整个文档的 Document 对象  
        Element e = document.getDocumentElement();  
        return document;  
    }  
  
}  
  
class Student{  
    private String name;  
    private String examid;  
    private String idcard;  
    private String location;  
    private String grade;  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public String getExamid() {  
        return examid;  
    }  
    public void setExamid(String examid) {  
        this.examid = examid;  
    }  
    public String getIdcard() {  
        return idcard;  
    }  
    public void setIdcard(String idcard) {  
        this.idcard = idcard;  
    }  
    public String getLocation() {  
        return location;  
    }  
    public void setLocation(String location) {  
        this.location = location;  
    }  
    public String getGrade() {  
        return grade;  
    }  
    public void setGrade(String grade) {  
        this.grade = grade;  
    }  
      
    public String toString(){  
        return "姓名：" + name + ",身份证号：" + idcard + ",准考证号：" + examid + ",地区：" + location + ",成绩：" + grade;  
    }  
}  