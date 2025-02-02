package ec.edu.ups.ppw.WSParkingRamirezBarzallo.utils;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    private static final String SECRET = "74j4m_d&3-r8s&8#^mbt+&2%!aau0-(o$n+js+^-@f2i=wn=i!";

    private static final SecretKey SECRET_KEY  = new SecretKeySpec(SECRET.getBytes(), "HmacSHA256");
    public static String generateTocken(int userId, int rol) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("rol", rol);
        return Jwts.builder()
                .subject(String.valueOf(userId))
                .claims(claims)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SECRET_KEY)
                .compact();
    }
}
