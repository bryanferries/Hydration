package com.example.hydration

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class WaterRecord(
    @PrimaryKey
    @NonNull
    var day: String,
    @NonNull
    val glasses: Int
    )