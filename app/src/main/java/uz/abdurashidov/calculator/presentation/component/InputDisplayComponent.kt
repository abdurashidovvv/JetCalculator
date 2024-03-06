package uz.abdurashidov.calculator.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.abdurashidov.calculator.presentation.theme.CalculatorTheme
import uz.abdurashidov.calculator.presentation.theme.ResultShadowColorBottom
import uz.abdurashidov.calculator.presentation.theme.ResultShadowColorTop
import uz.abdurashidov.calculator.presentation.theme.spacing
import uz.abdurashidov.calculator.viewmodel.CalcViewModel

@Composable
internal fun InputDisplayComponent(state: CalcViewModel.ViewState) {
    Box(
        Modifier
            .fillMaxWidth()
            .shadow(
                color = ResultShadowColorTop,
                blurRadius = 15.dp,
                offsetX = (-6).dp,
                offsetY = (-6).dp,
            )
            .shadow(
                color = ResultShadowColorBottom,
                blurRadius = 15.dp,
                offsetX = (6).dp,
                offsetY = (6).dp,
            )
            .clip(MaterialTheme.shapes.large)
            .background(MaterialTheme.colors.onBackground)
            .padding(
                vertical = MaterialTheme.spacing.md,
                horizontal = MaterialTheme.spacing.sm
            )
    ) {
        Text(
            text = state.result,
            overflow = TextOverflow.Visible,
            maxLines = 1,
            style = MaterialTheme.typography.h1.merge(TextStyle(textAlign = TextAlign.End)),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
@Preview(showBackground = true)
@Composable
fun InputDisplayComponentPreview() {
    CalculatorTheme {
        Box(modifier = Modifier.padding(10.dp)) {
            InputDisplayComponent(CalcViewModel.ViewState("5+7=12"))
        }
    }
}