package com.example.mysql.entity

import com.example.mysql.enums.UserType
import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var uid : Long? = null

    @Column(nullable = false, unique = true)
    var userId : String? = null

    @Enumerated(EnumType.STRING)
    var userType : UserType? = null

    var email : String? = null
}