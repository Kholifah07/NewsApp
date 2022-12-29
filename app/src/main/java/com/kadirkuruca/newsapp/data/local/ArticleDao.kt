package com.kadirkuruca.newsapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kadirkuruca.newsapp.data.model.Article

@Dao
interface ArticleDao {
//digunkan untuk
    @Query("SELECT * FROM article_table")
    fun getArticles() : LiveData<List<Article>>
// digunkan untuk meng innsert data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article) : Long
// digunkan untuk menghapus
    @Delete
    suspend fun delete(article: Article)

    @Query("DELETE FROM article_table")
    suspend fun deleteAllArticles()
}