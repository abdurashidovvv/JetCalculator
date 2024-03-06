package uz.abdurashidov.calculator.presentation.utils

import androidx.compose.ui.graphics.Color
import uz.abdurashidov.calculator.presentation.theme.ButtonBlue
import uz.abdurashidov.calculator.presentation.theme.ButtonPink
import uz.abdurashidov.calculator.presentation.theme.ButtonYellow

sealed class ActionType(val symbol: String, val buttonColor: Color) {
    data class Number(val number: Int) : ActionType(symbol = number.toString(), ButtonBlue)
    data class Operator(val operation: Operators) : ActionType(operation.smybol, ButtonPink)

    data object Calculate : ActionType("=", ButtonYellow)
    data object Delete : ActionType("-", ButtonBlue)
    data object Clear : ActionType("AC", ButtonPink)
    data object Decimal : ActionType(".", ButtonBlue)
    data object Percentage : ActionType("%", ButtonPink)
}

sealed class Operators(val smybol: String) {
    data object Add : Operators("+")
    data object Substract : Operators("-")
    data object Multiply : Operators("×")
    data object Divide : Operators("÷")
    data object Power : Operators("^")
}