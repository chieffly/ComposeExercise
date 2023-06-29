package ru.chieffly.composeexercise.domain

/**
 *Created by Bryantsev Anton on 29.06.2023.
 **/

data class StatisticItem(
    val type: StatisticType,
    val count: Int = 0
)

enum class StatisticType {
    VIEWS, COMMENTS, SHARES, LIKES
}