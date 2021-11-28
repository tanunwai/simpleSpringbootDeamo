package com.springboot.simpleiuds.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="memberships")
@Getter
@Setter
@NoArgsConstructor
public class Memberships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberid;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String realname;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String sex;
    @Column
    private String birthday;
    @Column
    private String address;
}
