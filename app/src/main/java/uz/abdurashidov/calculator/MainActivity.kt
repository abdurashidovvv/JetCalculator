package uz.abdurashidov.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.abdurashidov.calculator.presentation.component.CalcButtonComponent
import uz.abdurashidov.calculator.presentation.component.InputDisplayComponent
import uz.abdurashidov.calculator.presentation.theme.CalculatorTheme
import uz.abdurashidov.calculator.presentation.theme.spacing
import uz.abdurashidov.calculator.utils.ActionType
import uz.abdurashidov.calculator.utils.Operators
import uz.abdurashidov.calculator.viewmodel.CalcViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel = viewModel<CalcViewModel>()
                    val state =
                        viewModel.viewState.collectAsState(initial = CalcViewModel.ViewState("0")).value
                    CalcScreen(state) {
                        viewModel.dispatch(it)
                    }
                }
            }
        }
    }
}

@Composable
private fun CalcScreen(state: CalcViewModel.ViewState, dispatcher: (ActionType) -> Unit) {
    Box(
        modifier = Modifier
            .padding(horizontal = MaterialTheme.spacing.lg, vertical = MaterialTheme.spacing.sm)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
        ) {
            InputDisplayComponent(state)
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.lg))
            CalcButtonsGridLayout(dispatcher)
        }
    }
}

@Composable
private fun CalcButtonsGridLayout(dispatcher: (ActionType) -> Unit) {
    val buttons = listOf(
        ActionType.Clear,
        ActionType.Operator(Operators.Power),
        ActionType.Percentage,
        ActionType.Operator(Operators.Divide),
        ActionType.Number(7),
        ActionType.Number(8),
        ActionType.Number(9),
        ActionType.Operator(Operators.Multiply),
        ActionType.Number(4),
        ActionType.Number(5),
        ActionType.Number(6),
        ActionType.Operator(Operators.Substract),
        ActionType.Number(3),
        ActionType.Number(2),
        ActionType.Number(1),
        ActionType.Operator(Operators.Add),
        ActionType.Number(0),
        ActionType.Decimal,
        ActionType.Delete,
        ActionType.Calculate,
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.sm),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.sm),
        content = {
            items(buttons) {
                CalcButtonComponent(
                    modifier = Modifier.aspectRatio(1f),
                    color = it.buttonColor,
                    symbol = it.symbol
                ) {
                    dispatcher(it)
                }
            }
        })
}

@Preview(showBackground = true)
@Composable
fun ScreenCalcPreview() {
    CalculatorTheme {
        CalcScreen(CalcViewModel.ViewState("0")) { }
    }
}