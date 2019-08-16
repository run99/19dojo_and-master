package jp.co.cyberagent.dojo2019

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities =  arrayOf(Profile::class), version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun profileDao(): ProfileDao
}