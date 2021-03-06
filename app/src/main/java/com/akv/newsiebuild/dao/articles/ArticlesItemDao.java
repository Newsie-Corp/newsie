package com.akv.newsiebuild.dao.articles;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.akv.newsiebuild.model.database.articles.ArticlesItemDB;

import java.util.List;

@Dao
public interface ArticlesItemDao {

    @Query("SELECT * FROM ArticlesItemDB")
    List<ArticlesItemDB> getAll();

    @Query("SELECT * FROM ArticlesItemDB WHERE articleId in (:articlesItemsIds)")
    List<ArticlesItemDB> getAllById(int[] articlesItemsIds);

    @Query("SELECT * FROM ArticlesItemDB WHERE articleId = :articlesItemsId")
    ArticlesItemDB getById(int articlesItemsId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ArticlesItemDB... articlesItems);

    @Update
    void updateUsers(ArticlesItemDB... articlesItems);

    @Query("DELETE FROM ArticlesItemDB")
    void deleteAll();
}
