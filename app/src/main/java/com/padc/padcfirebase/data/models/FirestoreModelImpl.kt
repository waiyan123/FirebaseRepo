package com.padc.padcfirebase.data.models

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.padc.padcfirebase.data.vos.ArticleVO

object FirestoreModelImpl : FirestoreModel{

    private val firestoreRef = FirebaseFirestore.getInstance()

    override fun getAllArticles(cleared: LiveData<Unit>): LiveData<List<ArticleVO>> {
        var liveData = MutableLiveData<List<ArticleVO>>()

        firestoreRef.collection("testicles")
            .get()
            .addOnSuccessListener {
                val articles = ArrayList<ArticleVO>()
                for (articleData in it.documents){
                    val article = articleData.toObject(ArticleVO::class.java)
                    article?.let{
                        articles.add(article)

                    }
                }
            }
            .addOnFailureListener{
                Log.d("test---",it.message)
            }
        return liveData
    }

}