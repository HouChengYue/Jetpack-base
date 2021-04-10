package com.hcy.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import dev.chrisbanes.accompanist.glide.GlideImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage

/**
 * description :
 * @author HCY
 * @date 2021/4/9
 */
@Composable
fun NetImageView(modifier: Modifier = Modifier.wrapContentSize(), imageUrl: String) {
    GlideImage(data = imageUrl, modifier = modifier) { imageState ->
        when (imageState) {
            is ImageLoadState.Success -> {
                MaterialLoadingImage(
                    result = imageState,
                    contentDescription = "加载成功",
                    fadeInEnabled = true,
                    fadeInDurationMs = 600,
                    modifier = modifier
                )
            }
            is ImageLoadState.Loading -> {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(color = Color.LightGray)
                )
            }
            is ImageLoadState.Error -> {
                Image(
                    painter = painterResource(id = R.drawable.pic_erro),
                    contentDescription = "加载中",
                    modifier = Modifier
                        .matchParentSize()
                        .background(color = Color.LightGray)
                )
            }
            else -> {
                Image(
                    painter = painterResource(id = R.drawable.pic_empty),
                    contentDescription = "加载中",
                    modifier = Modifier
                        .matchParentSize()
                        .background(color = Color.LightGray)
                )
            }
        }
    }

}

@Preview
@Composable
fun showNetImage() {
    NetImageView(imageUrl = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png")
}