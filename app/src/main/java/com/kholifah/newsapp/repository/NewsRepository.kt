package com.kholifah.newsapp.repository

import com.kholifah.newsapp.data.local.ArticleDao
import com.kholifah.newsapp.data.model.Article
import com.kholifah.newsapp.data.model.NewsResponse
import com.kholifah.newsapp.data.remote.NewsApi
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton
// digunakan untuk mengambil berita secara ofline
@Singleton
class NewsRepository @Inject constructor(
    private val newsApi: NewsApi,
    private val articleDao: ArticleDao
) {
    // digunakanuntuk mengambil berita terkini
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int): Response<NewsResponse> {
        return newsApi.getBreakingNews(countryCode,pageNumber)
    }
    // digunakan untuk mencari berita
    suspend fun searchNews(searchQuery: String, pageNumber: Int): Response<NewsResponse>{
        return newsApi.searchForNews(searchQuery, pageNumber)
    }

    fun getAllArticles() = articleDao.getArticles()
    //digunakn untuk menginsert articel dari articelDao
    suspend fun insertArticle(article: Article) = articleDao.insert(article)
    //digunakn untuk menghapus articel dari articelDao
    suspend fun deleteArticle(article: Article) = articleDao.delete(article)

    suspend fun deleteAllArticles() = articleDao.deleteAllArticles()
}