package com.codeactuator.rocket.dto;


import com.codeactuator.rocket.domain.Workforce;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkforceDTO implements Marshallable<Workforce, WorkforceDTO> {


    private Long id;
    private String name;
    private String email;
    private UserProfileDTO role;

    @Override
    public Workforce marshall() {
        Workforce workforce = new Workforce();
        workforce.setId(this.getId());
        workforce.setName(this.getName());
        workforce.setEmail(this.getEmail());

        if(this.getRole() != null){
            workforce.setUserProfile(this.getRole().marshall());
        }
        return workforce;
    }

    @Override
    public void unmarshal(Workforce workforce) {
        this.setId(workforce.getId());
        this.setName(workforce.getName());
        this.setEmail(workforce.getEmail());

        if(workforce.getUserProfile() != null){
            UserProfileDTO userProfileDTO = new UserProfileDTO();
            userProfileDTO.unmarshal(workforce.getUserProfile());
            this.setRole(userProfileDTO);
        }
    }
}
