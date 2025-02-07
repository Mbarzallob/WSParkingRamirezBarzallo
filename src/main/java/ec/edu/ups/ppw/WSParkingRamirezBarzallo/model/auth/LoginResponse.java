package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.auth;

public class LoginResponse {
    private String JWT;
    private int rol;

    public String getJWT() {
        return JWT;
    }

    public void setJWT(String JWT) {
        this.JWT = JWT;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
}
