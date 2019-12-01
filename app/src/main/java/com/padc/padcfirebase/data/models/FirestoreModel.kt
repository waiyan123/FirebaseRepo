package com.padc.padcfirebase.data.models

import androidx.lifecycle.LiveData
import com.padc.padcfirebase.data.vos.ArticleVO

interface FirestoreModel {

    fun getAllArticles(cleared: LiveData<Unit>): LiveData<List<ArticleVO>>
}