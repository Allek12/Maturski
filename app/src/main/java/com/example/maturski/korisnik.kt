package com.example.maturski

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class korisnik(
    @SerialName("id")
    val id: String,

    @SerialName("ime")
    val ime: String =" ",

    @SerialName("prezime")
    val prezime: String =" ",

    @SerialName("email")
    val email: String =" ",

    @SerialName("username")
    val username: String =" ",

    @SerialName("telefon")
    val telefon: String =" ",

    @SerialName("mesto")
    val mesto: String =" ",

    @SerialName("pozitivnih_ocena")
    val pozitivnih_ocena: Int = 0,

    @SerialName("negativnih_ocena")
    val negativnih_ocena: Int  =0
)