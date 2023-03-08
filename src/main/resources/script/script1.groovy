
//import org.apache.camel.impl.DefaultAttachment;
//import javax.mail.util.ByteArrayDataSource;
import java.util.*;
 import com.sap.gateway.ip.core.customdev.util.Message;

def Message processData(Message message) {
    //Body 
       def body = message.getBody(String);
            
      //  def dataSource = new ByteArrayDataSource(body, 'text/xml') //Set MIME type
      //  def attachment = new DefaultAttachment(dataSource)
      //  message.addAttachmentObject("0000449177_GSAP_KRED_VendorMaster20230208-150007-653.xml", attachment)   //Add request attachment
       
       message.setProperty("CP_NAME", "GSAP_SUPPLIER_P");
       message.setProperty("XML_FILE_NAME", "0000449177_GSAP_KRED_VendorMaster20230208-150007-653.xml");
       
       message.setHeader("Accept-Encoding", "gzip,deflate");
       message.setHeader("Content-Type", "multipart/mixed; boundary="+'"----123"');
       message.setHeader("Content-Length", "7728");
       
       body = "------123\r\nContent-Type: text/xml\r\nContent-Transfer-Encoding: quoted-printable\r\nContent-Disposition: attachment;\r\n  filename=0000449177_GSAP_KRED_VendorMaster20230208-150007-653.xml\r\n\r\n" + body +"\r\n------123--"
       message.setBody(body);
       return message
      ;
      
}