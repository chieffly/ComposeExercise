package ru.chieffly.composeexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.chieffly.composeexercise.domain.FeedItem
import ru.chieffly.composeexercise.domain.StatisticItem

/**
 *Created by Bryantsev Anton on 28.06.2023.
 **/

class MainViewModel : ViewModel() {

    private val _feedItem = MutableLiveData(FeedItem())
    val feedItem: LiveData<FeedItem> = _feedItem

    fun updateCount(item: StatisticItem) {
        val oldStat = feedItem.value?.statistics ?: throw IllegalStateException()
        val newStat = oldStat.toMutableList().apply {
            this.replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else
                    oldItem
            }
        }
        _feedItem.value = feedItem.value?.copy(
            statistics = newStat
        )
    }
}