package com.kholifah.newsapp.ui.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kholifah.newsapp.data.model.Article
import com.kholifah.newsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
//view model
@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val articleEventChannel = Channel<ArticleEvent>()
    val articleEvent = articleEventChannel.receiveAsFlow()

    fun saveArticle(article: Article) {
        viewModelScope.launch {
            newsRepository.insertArticle(article)
            articleEventChannel.send(ArticleEvent.ShowArticleSavedMessage("Article Saved."))
        }
    }

    sealed class ArticleEvent{
        data class ShowArticleSavedMessage(val message: String): ArticleEvent()
    }
}