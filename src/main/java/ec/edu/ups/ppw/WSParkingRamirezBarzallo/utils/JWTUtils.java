package ec.edu.ups.ppw.WSParkingRamirezBarzallo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    private static final String SECRET = "vN8jiL1zEl7M3YgT0P9mKbedGpDys1Asfj8+vBJ1GqzkdrVHDy6OJoV4E4po9kiXG";

    private static final SecretKey SECRET_KEY  = new SecretKeySpec(SECRET.getBytes(), "HmacSHA256");
    public static String generarToken(int userId, int rolId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", String.valueOf(userId));
        claims.put("rol", String.valueOf(rolId));

        return Jwts.builder()
                .claims(claims)
                .issuer("http://localhost:8080")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SECRET_KEY, Jwts. SIG. HS256)
                .compact();
    }
    public static Claims obtenerClaims(String token) {
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }
    public static boolean validarToken(String token) {
        try {

            Jwts.parser()
                    .verifyWith(SECRET_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String obtenerUserId(String token) {
        return obtenerClaims(token).get("sub",String.class);
    }

    public static String obtenerRol(String token) {
        return obtenerClaims(token).get("rol", String.class);
    }
}
