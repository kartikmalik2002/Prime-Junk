package com.example.primejunk;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class}, version = 3,exportSchema = true)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract ItemDao ItemDao();
}

