package uz.abdurashidov.calculator.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val DarkColorPalette = darkColors(
    background = OuterSpace300,
    onBackground = OuterSpace200
)

@Composable
fun CalculatorTheme(
    content: @Composable () -> Unit
) {
    val colors = DarkColorPalette
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = colors.background)

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}