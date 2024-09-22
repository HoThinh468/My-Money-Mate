package com.vn.designsystem.components.cards

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vn.designsystem.R
import com.vn.designsystem.color.MyMoneyMateColors
import com.vn.designsystem.dimension.cardMinHeight
import com.vn.designsystem.dimension.mediumRadius
import com.vn.designsystem.dimension.mediumSpacing

@Composable
fun FullWidthClickableCardViewWithIcon(
    cardTitle: String,
    @DrawableRes leadingIconRes: Int,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes trailingIconRes: Int? = null,
    trailingComposable: @Composable () -> Unit = {},
    backgroundColor: Color = MyMoneyMateColors.White,
    contentColor: Color = MaterialTheme.colorScheme.onBackground,
    cardContent: (@Composable () -> Unit)? = null
) {
    Card(
        modifier = modifier
            .heightIn(min = cardMinHeight)
            .wrapContentHeight(unbounded = true),
        shape = RoundedCornerShape(mediumRadius),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        onClick = onCardClick,
        border = BorderStroke(width = 1.dp, color = MyMoneyMateColors.LightGray)
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(mediumSpacing)) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = leadingIconRes),
                    tint = contentColor,
                    contentDescription = "Card leading icon"
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = mediumSpacing),
                    text = cardTitle,
                    style = MaterialTheme.typography.titleSmall
                )
                if (trailingIconRes != null) {
                    Icon(
                        painter = painterResource(id = trailingIconRes),
                        tint = contentColor,
                        contentDescription = "Card trailing icon"
                    )
                } else trailingComposable()
            }
            if (cardContent != null) {
                cardContent()
            }
        }
    }
}

@Preview
@Composable
private fun FullWidthClickableCardViewWithIconPreview() {
    FullWidthClickableCardViewWithIcon(
        leadingIconRes = R.drawable.ic_income,
        cardTitle = "Add payments",
        onCardClick = {
            // Do nothing
        }
    )
}
