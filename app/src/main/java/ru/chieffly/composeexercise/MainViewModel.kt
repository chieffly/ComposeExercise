package ru.chieffly.composeexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *Created by Bryantsev Anton on 28.06.2023.
 **/

class MainViewModel : ViewModel() {

    private val _isFollowing = MutableLiveData<Boolean>()
    val isFollowing: LiveData<Boolean> = _isFollowing

    fun changesFollowingStatus() {
        val wasFollowing = _isFollowing.value ?: false
        _isFollowing.value = !wasFollowing
    }
}