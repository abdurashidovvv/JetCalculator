package uz.abdurashidov.calculator.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.abdurashidov.calculator.presentation.theme.ButtonPink
import uz.abdurashidov.calculator.presentation.theme.ButtonShadowColorBottom
import uz.abdurashidov.calculator.presentation.theme.ButtonShadowColorTop
import uz.abdurashidov.calculator.presentation.theme.CalculatorTheme

@Composable
fun CaclButtonComponent(
    modifier: Modifier = Modifier,
    color: Color,
    symbol: String,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .background(color)
            .then(modifier)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize(.8f)
                .shadow(
                    color = ButtonShadowColorTop,
                    offsetX = (-4).dp,
                    offsetY = (-4).dp,
                    blurRadius = 8.dp
                )
                .shadow(
                    color = ButtonShadowColorBottom,
                    offsetX = (-4).dp,
                    offsetY = (-4).dp,
                    blurRadius = 8.dp
                )
                .clip(MaterialTheme.shapes.medium)
                .background(color)
        ) {
            Text(text = symbol)
        }
    }
}

@Preview
@Composable
fun CalcButtonComponentPreview() {
    CalculatorTheme {
        CaclButtonComponent(
            modifier = Modifier.size(
                100.dp
            ), color = ButtonPink, symbol = "1"
        ) {

        }
    }
}