package com.fstg.Tuto_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileEntity implements Serializable {
    @Id
    @GeneratedValue
    private int profileId;
    @Column(nullable = false)
    private String avatar;
    @Column()
    private String tel;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
