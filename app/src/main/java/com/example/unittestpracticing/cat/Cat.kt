package com.example.unittestpracticing.cat

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cat")
data class Cat(
    @PrimaryKey(autoGenerate = true)
    val catId: Int = -1,
    @SerializedName("_id")
    val id: String?,
    val createdAt: String?,
    val owner: String?,
    val updatedAt: String?
)