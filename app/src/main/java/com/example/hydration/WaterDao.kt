package com.example.hydration

import androidx.room.Dao
import androidx.room.Insert

@Dao    //data access object
interface WaterDao {

    @Insertsuspend fun insert


}