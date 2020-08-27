package com.codeactuator.rocket.dto;

import com.codeactuator.rocket.domain.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDTO implements Marshallable<UserProfile, UserProfileDTO> {


    private Long id;
    private String name;


    @Override
    public UserProfile marshall() {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(this.getId());
        userProfile.setName(this.getName());
        return userProfile;
    }

    @Override
    public void unmarshal(UserProfile userProfile) {
        this.setId(userProfile.getId());
        this.setName(userProfile.getName());
    }


    public static class Builder {

        private Long id;
        private String name;

        public Builder(String name){
            this.name = name;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public UserProfileDTO build(){
            UserProfileDTO userProfileDTO = new UserProfileDTO();
            userProfileDTO.setId(this.id);
            userProfileDTO.setName(this.name);
            return userProfileDTO;
        }
    }
}
