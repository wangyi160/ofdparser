package dom;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomUtil {

	public static final String prefix="ofd:";
	
	public static List<Node> getElementsByTagNameNS(Node node, String ns, String tagName)
	{
		List<Node> list=new ArrayList<>();
		
		NodeList children=node.getChildNodes();
		
		for(int i=0;i<children.getLength();i++)
		{
			Node child=children.item(i);
			
			
			if(child.getNodeType()==Node.ELEMENT_NODE 
					&& child.getNamespaceURI().equals(ns) 
					&& child.getNodeName().equals(prefix+tagName))
			{
				list.add(child);
			}
		}
		
		return list;
	}
	
	public static List<Node> getElementsByTagNameNS(Node node, String ns, Set<String> tagNames)
	{
		List<Node> list=new ArrayList<>();
		
		NodeList children=node.getChildNodes();
		
		for(int i=0;i<children.getLength();i++)
		{
			Node child=children.item(i);
			
			for(String tagName: tagNames)
			{
				if(child.getNodeType()==Node.ELEMENT_NODE 
						&& child.getNamespaceURI().equals(ns) 
						&& child.getNodeName().equals(prefix+tagName))
				{
					list.add(child);
					break;
				}
			}
		}
		
		return list;
	}
	
	public static List<Node> getElementsByTagName(Node node, String tagName)
	{
		List<Node> list=new ArrayList<>();
		
		NodeList children=node.getChildNodes();
		
		for(int i=0;i<children.getLength();i++)
		{
			Node child=children.item(i);
			
			
			if(child.getNodeType()==Node.ELEMENT_NODE 
					&& child.getNodeName().equals(tagName))
			{
				list.add(child);
			}
		}
		
		return list;
	}
	
}
