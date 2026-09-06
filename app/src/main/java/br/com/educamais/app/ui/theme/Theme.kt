package br.com.educamais.app.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Esquema de cor único do EducaMais (sem modo escuro nem cor dinâmica):
// a marca é consistente em qualquer aparelho, como em Linear/Stripe.
private val EducaMaisColorScheme = lightColorScheme(
    primary = AzulEletrico,
    onPrimary = Color.White,
    secondary = Ciano,
    onSecondary = Navy,
    tertiary = Ciano,
    onTertiary = Navy,
    background = FundoClaro,
    onBackground = Navy,
    surface = SuperficieClara,
    onSurface = Navy,
    surfaceVariant = FundoClaro,
    onSurfaceVariant = Navy,
    outline = DivisorClaro,
    outlineVariant = DivisorClaro,
    error = Risco,
    onError = Color.White
)

// Cantos arredondados de 16dp em cartões, conforme a identidade visual.
val EducaMaisShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(24.dp)
)

// Tokens semânticos que não têm slot correspondente no ColorScheme padrão
// do Material 3 (sucesso/atenção/risco, navy da marca). Telas devem ler
// essas cores por aqui, nunca declarar hex literal.
data class EducaMaisExtraColors(
    val navy: Color,
    val azulEletrico: Color,
    val ciano: Color,
    val divisor: Color,
    val sucesso: Color,
    val atencao: Color,
    val risco: Color
)

private val LocalEducaMaisExtraColors = staticCompositionLocalOf {
    EducaMaisExtraColors(
        navy = Navy,
        azulEletrico = AzulEletrico,
        ciano = Ciano,
        divisor = DivisorClaro,
        sucesso = Sucesso,
        atencao = Atencao,
        risco = Risco
    )
}

object EducaMaisTokens {
    val cores: EducaMaisExtraColors
        @Composable
        get() = LocalEducaMaisExtraColors.current
}

@Composable
fun EducaMaisTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalEducaMaisExtraColors provides EducaMaisExtraColors(
        navy = Navy,
        azulEletrico = AzulEletrico,
        ciano = Ciano,
        divisor = DivisorClaro,
        sucesso = Sucesso,
        atencao = Atencao,
        risco = Risco
    )) {
        MaterialTheme(
            colorScheme = EducaMaisColorScheme,
            typography = Typography,
            shapes = EducaMaisShapes,
            content = content
        )
    }
}
