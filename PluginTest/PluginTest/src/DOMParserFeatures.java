import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParserFeatures {

	public static void main(String[] args) throws Exception {
		//Get the DOM Builder Factory
		DocumentBuilderFactory factory = 
				DocumentBuilderFactory.newInstance();

		//Get the DOM Builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		//Load and Parse the XML document
		//document contains the complete XML as a Tree.
		Document document = 
				builder.parse(new File("C:/Users/carlos/Desktop/feature.xml")
						);

		ArrayList<Protein> protList = new ArrayList<>();

		//Iterating through the nodes and extracting the data.
		NodeList nodeList = document.getDocumentElement().getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {

			//We have encountered an <employee> tag.
			Node Anode = nodeList.item(i);
			if (Anode instanceof Element) {
				Protein prot = new Protein();
				prot.GFFVersion = Anode.getAttributes().getNamedItem("version").getNodeValue();
				prot.href = Anode.getAttributes().getNamedItem("href").getNodeValue();
				NodeList FirstchildNodes = ((Element) Anode).getElementsByTagName("SEGMENT");
				for (int j = 0; j < FirstchildNodes.getLength(); j++) {
					Node Bnode = FirstchildNodes.item(j);
					prot.SegmentVersion = Bnode.getAttributes().getNamedItem("version").getNodeValue();
					prot.SegmentLabel = Bnode.getAttributes().getNamedItem("label").getNodeValue();
					prot.SegmentStop = Bnode.getAttributes().getNamedItem("stop").getNodeValue();
					prot.SegmentStart = Bnode.getAttributes().getNamedItem("start").getNodeValue();
					prot.SegmentID = Bnode.getAttributes().getNamedItem("id").getNodeValue();
					NodeList SecondchildNodes = Bnode.;
					for (int k = 0; k < SecondchildNodes.getLength(); k++)
					{
						Node Cnode = SecondchildNodes.item(j);
						prot.FeatureLabel = Cnode.getAttributes().getNamedItem("label").getNodeValue();
						prot.FeatureID = Cnode.getAttributes().getNamedItem("id").getNodeValue();
						NodeList ThirdchildNodes = Cnode.getChildNodes();
						for (int l = 0; l < ThirdchildNodes.getLength(); l++)
						{
							Node Dnode = ThirdchildNodes.item(j);
							switch (Dnode.getNodeName()) {
							case "TYPE":
								prot.typeID = Dnode.getAttributes().getNamedItem("id").getNodeValue();
								prot.typeCat = Dnode.getAttributes().getNamedItem("category").getNodeValue();
								prot.CVID = Dnode.getAttributes().getNamedItem("cvId").getNodeValue();
								prot.type = Dnode.getLastChild().getTextContent().trim();;
								break;
							case "METHOD":
								prot.methodID = Dnode.getAttributes().getNamedItem("id").getNodeValue();
								prot.methodCVID = Dnode.getAttributes().getNamedItem("cvId").getNodeValue();
								prot.method = Dnode.getLastChild().getTextContent().trim();;
								break;	
							case "START":
								prot.start = Dnode.getLastChild().getTextContent().trim();;
								break;	
							case "END":
								prot.end = Dnode.getLastChild().getTextContent().trim();;
								break;		
							case "SCORE":
								prot.end = Dnode.getLastChild().getTextContent().trim();;
								break;		
							case "LINK":
								String linktoadd = Dnode.getAttributes().getNamedItem("href").getNodeValue();
								prot.link.add(linktoadd);
								break;		
							}
						}
					}
					protList.add(prot);
				}
			}

		}

	}

	//Printing the Employee list populated.
	//for (Employee emp : empList) {
	//	System.out.println(emp);
	//}

	//}
}

class Protein{
	String GFFVersion;
	String href;
	String SegmentVersion;
	String SegmentLabel;
	String SegmentStop;
	String SegmentStart;
	String SegmentID;
	String FeatureLabel;
	String FeatureID;
	String type;
	String typeID;
	String typeCat;
	String CVID;
	String method;
	String methodID;
	String methodCVID;
	String start;
	String end;
	String score;
	ArrayList <String> link;
	//String LinkOne;
	//String LinkTwo;

	//@Override
	//public String toString() {
	//	return firstName+" "+lastName+"("+id+")"+location;
}
