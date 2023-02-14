import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
    var count: Int by mutableStateOf(0)

    renderComposable(rootElementId = "root") {

        Button(
            attrs = {
                onClick {
                    console.log("Hello")
                }
            },
            content = {
                Text("Hello")
            }
        )

//        Div({ style { padding(25.px) } }) {
//            Button(attrs = {
//                onClick { count -= 1 }
//            }) {
//                Text("-")
//            }
//
//            Span({ style { padding(15.px) } }) {
//                Text("$count")
//            }
//
//            Button(attrs = {
//                onClick { count += 1 }
//            }) {
//                Text("+")
//            }
//        }
    }
}

