import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

/**
 * Created by Kirill on 6/13/2016.
 */
public class KeyGenerator {
    public static void main(String[] args) {
        SecretKey key = MacProvider.generateKey(SignatureAlgorithm.HS512);
        System.out.println(DatatypeConverter.printBase64Binary(key.getEncoded()));
    }
}
