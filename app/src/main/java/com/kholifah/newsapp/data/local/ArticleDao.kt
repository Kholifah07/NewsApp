package com.kholifah.newsapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kholifah.newsapp.data.model.Article

@Dao
interface ArticleDao {
//digunkan untuk memilih data
    @Query("SELECT * FROM article_table")
    fun getArticles() : LiveData<List<Article>>
// digunkan untuk meng insert data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article) : Long
// digunkan untuk menghapus
    @Delete
    suspend fun delete(article: Article)
// digunakan untuk menghapus data
    @Query("DELETE FROM article_table")
    suspend fun deleteAllArticles()
}