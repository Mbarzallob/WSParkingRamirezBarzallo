package ec.edu.ups.ppw.WSParkingRamirezBarzallo.filters;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.User;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person.UserRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.utils.JWTUtils;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Principal;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class JWTFilter implements ContainerRequestFilter {

    @Inject
    private UserRepository userRepository;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String path = requestContext.getUriInfo().getPath();
        if (path.contains("/auth/login") ||  path.contains("/person/gender") || path.contains("/auth/register")) {
            return;
        }
        String token = requestContext.getHeaderString("Authorization");

        if (token == null || !token.startsWith("Bearer ")) {

            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity(Result.failure("Token no proporcionado o inválido"))
                    .build());
        }

        try {
            assert token != null;
            token = token.substring(7);
            final String userId = JWTUtils.getUserId(token);
            User user = userRepository.getUser(Integer.parseInt(userId));
            String rol = String.valueOf(user.getRole().getId());

            requestContext.setSecurityContext(new SecurityContext() {

                @Override
                public Principal getUserPrincipal() {
                    return () -> userId;
                }

                @Override
                public boolean isUserInRole(String role) {
                    return role.equals(rol);
                }

                @Override
                public boolean isSecure() {
                    return false;
                }

                @Override
                public String getAuthenticationScheme() {
                    return "Bearer";
                }
            });

        } catch (Exception e) {
            requestContext.abortWith(Response.status(Response.Status.OK)
                    .entity(Result.failure("🚫 Token inválido o expirado"))
                    .build());
        }
    }
}
