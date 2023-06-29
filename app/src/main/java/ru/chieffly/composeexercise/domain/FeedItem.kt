package ru.chieffly.composeexercise.domain

import ru.chieffly.composeexercise.R

/**
 *Created by Bryantsev Anton on 29.06.2023.
 **/

data class FeedItem(
    val communityName: String = "/dev/null",
    val publicationDate: String = "13:41",
    val AvatarResId: Int = R.drawable.avatar,
    val postText: String = "Lorem uopd dsjfls noetu fnacbajse asf wqrzzxcv vb d sakxioq",
    val contentImageResId: Int = R.drawable.post_image,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, 252),
        StatisticItem(type = StatisticType.SHARES, 12),
        StatisticItem(type = StatisticType.COMMENTS, 73),
        StatisticItem(type = StatisticType.LIKES, 26)
    )
)