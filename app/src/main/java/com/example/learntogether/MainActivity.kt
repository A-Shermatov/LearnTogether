package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeLearnTogetherCard()
                }
            }
        }
    }
}

@Composable
fun ComposeLearnTogetherCard() {
    LearnTogetherCard(
        title = stringResource(R.string.title),
        firstParagraph = stringResource(R.string.first_paragraph),
        secondParagraph = stringResource(R.string.second_paragraph),
        image = painterResource(R.drawable.bg_compose_background),
    )
}

@Composable
private fun LearnTogetherCard(
    title: String,
    firstParagraph: String,
    secondParagraph: String,
    image: Painter,
    modifier: Modifier = Modifier,
) {
    Column {
        GreetingImage(
            image = image,
            modifier = modifier,
        )
        GreetingText(
            title = title,
            firstParagraph = firstParagraph,
            secondParagraph = secondParagraph,
            modifier = modifier,
        )
    }
}

@Composable
private fun GreetingImage(image: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = modifier,
    )
}

@Composable
private fun GreetingText(
    title: String,
    firstParagraph: String,
    secondParagraph: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp),
        )
        Text(
            text = firstParagraph,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp),
        )
        Text(
            text = secondParagraph,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp),
        )
    }

}


@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun LearnTogetherPreview() {
    LearnTogetherTheme {
        ComposeLearnTogetherCard()
    }
}