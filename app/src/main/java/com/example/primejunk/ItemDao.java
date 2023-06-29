package com.example.primejunk;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;




    @Dao
    public interface ItemDao
    {
        @Insert
        void insertrecord(Item item);


        @Query("SELECT EXISTS(SELECT * FROM Item WHERE pid = :productid)")
        Boolean is_exist(int productid);


        @Query("SELECT * FROM Item")
        List<Item> getallitem();

        @Query("DELETE FROM Item WHERE pid = :id")
        void deleteById(int id);
    }


