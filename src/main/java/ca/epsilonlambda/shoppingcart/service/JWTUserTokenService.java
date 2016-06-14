package ca.epsilonlambda.shoppingcart.service;

import ca.epsilonlambda.shoppingcart.domain.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Kirill on 6/13/2016.
 */
@Service
public class JWTUserTokenService implements UserTokenService {

    @Value("${ca.epsilonlambda.shoppingcart.jwt_secret_key}")
    private String jwtSecretKey;

    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
    @Override
    public String getAuthToken(User user) {
        JwtBuilder jwtBuilder = Jwts.builder().setSubject(user.getId()).signWith(signatureAlgorithm, jwtSecretKey);
        return jwtBuilder.compact();
    }

    @Override
    public User getUserFromToken(String token) {
        try
        {
            String userId = Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token).getBody().getSubject();
            return new User(userId);
        }
        catch(JwtException e) {
            return null;
        }
    }
}
