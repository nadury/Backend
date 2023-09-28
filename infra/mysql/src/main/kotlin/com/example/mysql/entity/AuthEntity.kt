package com.example.mysql.entity

import com.example.mysql.enums.OauthProvider
import javax.persistence.*

@Entity
@Table(name = "auth")
class AuthEntity() {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null

    @Column(nullable = false)
    var userId : Long? = null

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var oauthProvider : OauthProvider? = null

}