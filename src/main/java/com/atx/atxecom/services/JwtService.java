package com.atx.atxecom.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

/**
 * @author ashiq
 * @createdOn 23/03/25 4:52 am
 * @project AtxEcom
 **/
@Service
public class JwtService
{
    private  String SECRETE_KEY="b75735d9fad249d6a7329e212020ac80511c79dd8c16b5ef0698354ab2be5f9398203f9e09a30b7078ad8497a37d9d6066e88bffe975b4c445d798b35c130b6b7814c131de6cd9ea5471380d747651aa155fb92ba9ce82ac241182b3d0543b5325749d09fe85e275c7f722ad17857e7ca658198ddf44bcb3efe21f2155d5e032d7f1a90066c3afb400887a243a199853f954fa50a617785d433ae685f56abc3d639759a19ba56d76615e85f01536319bc0fc42c64e2db06b971997231076a3508873a251d46bdc7090254047bfe06dad5103a25f69ab5d319fd1f57660d652bbe34a71d7571142bd24831c080e9245c3e30ab8dee04c2347506f18dc55706b4f";

//    public JwtService()
//    {
//        try
//        {
//            KeyGenerator keyGenerator =  KeyGenerator.getInstance("HmacSHA256");
//            SecretKey generateKey = keyGenerator.generateKey();
//            SECRETE_KEY=Base64.getEncoder().encodeToString(generateKey.getEncoded());
//
//        }
//        catch(NoSuchAlgorithmException e)
//        {
//            throw new RuntimeException(e);
//        }
//
//    }

    public String generateJwtToken(String email)
    {
        HashMap<String,Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims(claims)
                .subject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+60*60*100))
                .signWith(getKey())
                .compact();
    }



    private SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRETE_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUserName(String token) {
        // extract the username from jwt token
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
