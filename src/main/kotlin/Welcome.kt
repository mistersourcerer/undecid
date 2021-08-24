import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.attrs
import react.dom.div
import react.dom.h1
import react.dom.input

external interface WelcomeProps : RProps {
    var name: String
}

//fun RBuilder.welcome(name: String) = child(welcome) {
//    attrs.name = name
//}
// or:
fun RBuilder.welcome(handler: WelcomeProps.() -> Unit) = child(welcome) {
    attrs {
        handler()
    }
}
// so we can: welcome { name = "Kotlin" }

//@JsExport
private val welcome = functionalComponent<WelcomeProps> { props ->
    //var (name, setName) = useState(props.name)
    // or
    var name by useState(props.name)
    h1 {
        +"Hello, $name"
    }

    input {
        attrs {
            type = InputType.text
            value = name
            onChangeFunction = { event ->
                name = (event.target as HTMLInputElement).value
            }
        }
    }
}
