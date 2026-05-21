package com.example.maturski

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ocene(
    @SerialName("id_vlasnika")
    val id_vlasnika: String,

    @SerialName("id_gosta")
    val id_gosta: String =" ",

    @SerialName("id_objekta")
    val id_objekta: String =" ",

    @SerialName("pozitivna")
    val pozitivna: Boolean,

    @SerialName("opis")
    val opis: String =" ",

    @SerialName("datum")
    val datum: String? = null
)