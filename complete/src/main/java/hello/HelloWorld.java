package hello;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger; 
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.joda.time.LocalTime;

public class HelloWorld {
  public static void main(String[] args) {

	LocalTime currentTime = new LocalTime();
	System.out.println("The current local time is: " + currentTime);

	Greeter greeter = new Greeter();
    
        try {
	
          greeter.setReportingYear(2020);
          String year = Integer.toString(greeter.getReportingYear());
          // String year = String.valueOf(greeter.getReportingYear());
           
          greeter.setReportingMonth(7);
          String month = Integer.toString(greeter.getReportingMonth());

          greeter.setBusinessUnitId("SD-CLAIMS-01");
          String businessUnitId = greeter.getBusinessUnitId();

			    String fte = greeter.concatenate(new String[]{year, "~", month, "~", businessUnitId});
		      System.out.println("fte: " + fte);
          System.out.println("\n" + fte + " : " + greeter.toHexString(greeter.getSHA(fte)));  
           
            // 2020~7~SD-CLAIMS-01 : 7ba5f729d20b610d517fa0f222389cf9
            // 2019~7~SD-CLAIMS-01 : 9a6b95187a92341aa885e66585c23532
            // 2018~7~SD-CLAIMS-01 : e8a894c29786292f4014ec5a14081ba9

        } catch (Exception e) { //NoSuchAlgorithmException
             System.out.println("Something is wrong");
            
        }
  }
}