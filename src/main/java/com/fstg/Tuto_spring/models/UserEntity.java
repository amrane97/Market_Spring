package com.fstg.Tuto_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {

    @Id
    private int userId;

    @Column (nullable = false)
    private String username;

    @Column (nullable = false)
    private String password;

    @ManyToMany()
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity> roles;

    @OneToOne(mappedBy = "userEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserProfileEntity userProfile;
}
