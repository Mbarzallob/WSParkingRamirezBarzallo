package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.person;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Role;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Status;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.User;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.person.UserDTO;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.person.UserRoleRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    private UserRepository userRepository;

    public Result<List<Role>> getRoles(){
        try{
            List<Role> roles = userRepository.getRoles();
            return Result.success(roles);
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

    public Result<List<Status>> getStatuses(){
        try{
            List<Status> statuses = userRepository.getStatuses();
            return Result.success(statuses);
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

    public Result<List<UserDTO>> getUsers(){
        try {
            List<User> users = userRepository.getUsers();
            List<UserDTO> userDTOs = new ArrayList<UserDTO>();
            for (User user : users) {
                userDTOs.add(UserDTO.fromUser(user));
            }
            return Result.success(userDTOs);
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> updateUserRole(UserRoleRequest request){
        try{
            Role role = userRepository.getRole(request.getRoleId());
            userRepository.updateUerRole(request.getUserId(), role);
            return Result.ok();
        } catch (Exception e) {

            return Result.failure(e.getMessage());
        }
    }
}
