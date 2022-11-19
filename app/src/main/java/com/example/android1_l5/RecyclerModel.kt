package com.example.android1_l5

import java.io.Serializable

data class RecyclerModel(
var imageUrl: String,
var name: String,
var age: Int,
var family: String
) : Serializable
