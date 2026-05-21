package com.example.maturski

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class apartmani(
    @SerialName("id_objekta")
    val id_objekta: String,

    @SerialName("ime_objekta")
    val ime_objekta: String =" ",

    @SerialName("kategorija")
    val kategorija: String =" ",

    @SerialName("opis")
    val opis: String =" ",

    @SerialName("cena_po_noci")
    val cena_po_noci: String =" ",

    @SerialName("kapacitet_odraslih")
    val kapacitet_odraslih: Int = 0,

    @SerialName("kapactet_dece")
    val kapacitet_dece: Int = 0,

    @SerialName("mesto")
    val mesto: String =" ",

    @SerialName("id_vlasnika")
    val id_vlasnika: String =" ",

    @SerialName("slike")
    val slike: List<String>
)