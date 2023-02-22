package com.adiupd123.roomdbapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Contact::class], version = 1)
@TypeConverters(TypeConvertor::class)
abstract class ContactDatabase: RoomDatabase(){

    abstract fun contactDao(): ContactDAO

    //Singleton pattern
    companion object {
        // responsive to changes in the data
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase {
            // thread safe
            synchronized(this){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContactDatabase::class.java,
                        "contactDB").build()
                }
            }
            return INSTANCE!!
        }
    }
}