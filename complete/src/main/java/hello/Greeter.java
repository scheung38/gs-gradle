package hello;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger; 
import java.security.NoSuchAlgorithmException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

// @EqualsAndHashCode
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Greeter {

    private int reportingYear;
    private int reportingMonth;
    private String businessUnitId;

    public String concatenate(String... s) { //static 
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length; i++) {
      sb = sb.append(s[i]);
    }
      return sb.toString();
    }
   

    public byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance("MD5");  
  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public String toHexString(byte[] hash) 
    { 
        // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    } 

}