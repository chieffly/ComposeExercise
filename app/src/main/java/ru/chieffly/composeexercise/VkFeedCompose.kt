package ru.chieffly.composeexercise

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.chieffly.composeexercise.domain.FeedItem
import ru.chieffly.composeexercise.domain.StatisticItem
import ru.chieffly.composeexercise.domain.StatisticType

/**
 *Created by Bryantsev Anton on 27.06.2023.
 **/

@Composable
fun VkFeedCard(
    modifier: Modifier = Modifier,
    feedItem: FeedItem,
    onStatisticsItemClickListener: (StatisticItem) -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            VkCardTopper(feedItem.communityName, feedItem.publicationDate, feedItem.AvatarResId)
            Text(text = feedItem.postText, modifier = Modifier.padding(4.dp))
            Image(
                painter = painterResource(id = feedItem.contentImageResId),
                contentDescription = "",
                modifier = Modifier
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            FeedCardStatistics(statistics = feedItem.statistics, onItemClickListener = onStatisticsItemClickListener)
        }
    }
}

@Composable
private fun VkCardTopper(
    communityName: String,
    dateOfPublication: String,
    avatarResId: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = avatarResId), contentDescription = "", modifier = Modifier
                .size(60.dp)
                .padding(4.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .padding(8.dp)
                .weight(1f)
        ) {
            Text(
                text = communityName,
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = dateOfPublication,
                color = MaterialTheme.colors.onSecondary
            )
        }
        Icon(painter = painterResource(R.drawable.baseline_more_vert_24), contentDescription = "", tint = MaterialTheme.colors.onSecondary)
    }
}

@Composable
private fun FeedCardStatistics(
    statistics: List<StatisticItem>,
    onItemClickListener: (StatisticItem) -> Unit
) {
    Row {
        Row(modifier = Modifier.weight(1f)) {
            val viewsItem = statistics.getItemByType(StatisticType.VIEWS)
            IconWithCount(drawableId = R.drawable.ic_eye_24, count = viewsItem.count.toString(), onClickListener = { onItemClickListener(viewsItem) })
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val sharesItem = statistics.getItemByType(StatisticType.SHARES)
            IconWithCount(drawableId = R.drawable.baseline_share_24, count = sharesItem.count.toString(), onClickListener = { onItemClickListener(sharesItem) })
            val commentsItem = statistics.getItemByType(StatisticType.COMMENTS)
            IconWithCount(drawableId = R.drawable.baseline_message_24, count = commentsItem.count.toString(), onClickListener = { onItemClickListener(commentsItem) })
            val likesItem = statistics.getItemByType(StatisticType.LIKES)
            IconWithCount(drawableId = R.drawable.baseline_favorite_border_24, count = likesItem.count.toString(), onClickListener = { onItemClickListener(likesItem) })
        }
    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { it.type == type } ?: throw IllegalStateException("Unknown statistics type $type ")
}

@Composable
private fun IconWithCount(
    drawableId: Int,
    count: String,
    onClickListener: () -> Unit
) {
    Row(
        modifier = Modifier.clickable {
            onClickListener()
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(drawableId), contentDescription = "", tint = MaterialTheme.colors.onSecondary)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = count, color = MaterialTheme.colors.onSecondary)
    }
}