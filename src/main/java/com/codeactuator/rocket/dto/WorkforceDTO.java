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
    private UserProfileDTO userProfile;

    @Override
    public Workforce marshall() {
        Workforce workforce = new Workforce();
        workforce.setId(this.getId());
        workforce.setName(this.getName());
        workforce.setEmail(this.getEmail());

        if(this.getUserProfile() != null){
            workforce.setUserProfile(this.getUserProfile().marshall());
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
            this.setUserProfile(userProfileDTO);
        }
    }


    public static class Builder{

        private Long id;
        private String name;
        private String email;
        private UserProfileDTO userProfile;


        public Builder(String name){
            this.name = name;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder userProfile(UserProfileDTO userProfile){
            this.userProfile = userProfile;
            return this;
        }

        public WorkforceDTO build(){
            WorkforceDTO workforceDTO = new WorkforceDTO();
            workforceDTO.setId(this.id);
            workforceDTO.setName(this.name);
            workforceDTO.setEmail(this.email);
            workforceDTO.setUserProfile(this.userProfile);
            return workforceDTO;
        }
    }
}
