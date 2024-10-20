package com.vn.mywallet.addtransactions.composables

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.vn.designsystem.dimension.smallIconSize
import com.vn.designsystem.dimension.smallRadius

@Composable
internal fun TransactionImagePreviewItem(
    uri: Uri,
    onCloseButtonClick: () -> Unit,
    onFullScreenButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    previewHeight: Dp = 150.dp,
    previewWidth: Dp = 180.dp
) {
    Box(
        modifier = modifier
            .size(height = previewHeight, width = previewWidth)
            .clip(RoundedCornerShape(smallRadius))
    ) {
        Image(
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(model = uri),
            contentDescription = "Image preview"
        )
        Row(modifier = modifier.align(alignment = Alignment.TopEnd)) {
            IconButton(onClick = { onFullScreenButtonClick() }) {
                Icon(
                    modifier = Modifier.size(smallIconSize),
                    painter = painterResource(id = com.vn.designsystem.R.drawable.ic_fullscreen),
                    contentDescription = "Full screen icon"
                )
            }
            IconButton(onClick = { onCloseButtonClick() }) {
                Icon(
                    modifier = Modifier.size(smallIconSize),
                    painter = painterResource(id = com.vn.designsystem.R.drawable.ic_close),
                    contentDescription = "close icon"
                )
            }
        }
    }
}


