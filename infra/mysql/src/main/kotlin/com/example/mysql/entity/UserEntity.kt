package com.example.mysql.entity

import com.example.mysql.enums.UserType
import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var uid : Long? = null

    @Column(nullable = false, unique = true)
    private var userId : String? = null

    @Enumerated(EnumType.STRING)
    private var userType : UserType? = null

    private var email : String? = null
}