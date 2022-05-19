
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParsing_test {

    // tag���� ������ �������� �޼ҵ�
   private static String getTagValue(String tag, Element eElement) {
       NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
       Node nValue = (Node) nlList.item(0);
       if(nValue == null) 
           return null;
       return nValue.getNodeValue();
   }

   public static void main(String[] args) {
      int page = 1;   // ������ �ʱⰪ 
 
      try{
         while(true){
            // parsing�� url ����(API Ű �����ؼ�)
            String url = "http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?serviceKey=mnUlBGGUwAhkbrePB0BjlD4C6IgJBf%2BnggDmp4B%2F75ZYKBpXRAEkpYE5PTjpa0I4SQ9Dks5%2FJkyd56nSL75%2B0Q%3D%3D&pageNo="+page+"&numOfRows=9999";
            
            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
            Document doc = dBuilder.parse(url);
            
            
            // root tag 
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            
            // �Ľ��� tag
            NodeList nList = doc.getElementsByTagName("item");
            System.out.println("�Ľ��� ����Ʈ �� : "+ nList.getLength());
            
            for(int temp = 0; temp < nList.getLength(); temp++){
               Node nNode = nList.item(temp);
               if(nNode.getNodeType() == Node.ELEMENT_NODE){
                  
                  Element eElement = (Element) nNode;
   
                  System.out.println("######################");
                  //System.out.println(eElement.getTextContent());
                  System.out.println("�̸�  : " + getTagValue("statNm", eElement));
                  System.out.println("���� : " + getTagValue("lat", eElement));
                  System.out.println("�浵 : " + getTagValue("lng", eElement));
                  System.out.println("���ð� : " + getTagValue("useTime", eElement));
               }   // for end
            }   // if end
            
            page += 1;
            System.out.println("page number : "+page);
            if(page > 4){   
               break;
            }
         }   // while end
         
      } catch (Exception e){   
         System.out.println("����" + e);
      }   // try~catch end
   }   // main end
}   // class end
