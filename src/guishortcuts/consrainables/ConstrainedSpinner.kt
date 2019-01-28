package guishortcuts.consrainables

import java.awt.GridBagConstraints
import javax.swing.*

class ConstrainedSpinner(text: Array<String>): JSpinner(text.toSpinnerModel()), Constrainable {
    override val GBC: GridBagConstraints = GridBagConstraints()

    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }

    infix fun does(func: () -> Unit) {
        addChangeListener {
            func()
        }
    }

    infix fun selected(kind: Int): String {
        if(kind != item) throw Exception("Use 'item' when attempting to get selected list item")
        return (model as SpinnerListModel).value.toString()
    }
}

infix fun Int.add(spinner: ConstrainedSpinner): ConstrainedSpinner {
    return spinner
}

fun Array<String>.toSpinnerModel(): SpinnerListModel {
    return SpinnerListModel(this)
}
