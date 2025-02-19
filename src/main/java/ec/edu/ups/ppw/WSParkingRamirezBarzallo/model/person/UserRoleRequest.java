package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.person;

public class UserRoleRequest {

    private int UserId;
    private int RoleId;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }
}
