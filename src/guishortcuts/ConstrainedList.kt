package guishortcuts

import java.awt.GridBagConstraints
import javax.swing.*
import kotlin.random.Random

class ConstrainedList(text: Array<String>): JList<String>(text.toListModel()), Constrainable {
    override val GBC: GridBagConstraints = GridBagConstraints()
    private var listModel = DefaultListModel<String>()

    init {
        listModel = text.toListModel()
        model = listModel
    }

    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }

    infix fun does(func: () -> Unit) {
        addListSelectionListener {
            if(!valueIsAdjusting) func()
        }
    }

    infix fun selected(kind: Int): String {
        if(kind != item) throw Exception("Use 'item' when attempting to get selected list item")
        return selectedValue
    }

    infix fun selected(kind: Double): Int {
        if(kind != index) throw Exception("Use 'index' when attempting to get selected list item's index")
        return selectedIndex
    }

    infix fun add(item: String) {
        listModel.addElement(item)
        model = listModel
    }

    infix fun remove(item: String) {
        listModel.removeElement(item)
        model = listModel
    }

    infix fun add(items: Array<String>) {
        items.forEach {this add it}
        model = listModel
    }

    infix fun remove(items: Array<String>) {
        items.forEach {this remove it}
        model = listModel
    }
}

val single = 0
val interval = 1
val free = 2
val item = 3
val index = 0.0

infix fun Int.add(list: ConstrainedList): ConstrainedList {
    return list
}

infix fun Int.enabled(list: ConstrainedList) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    list.isEnabled = true
}

infix fun Int.disabled(list: ConstrainedList) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    list.isEnabled = false
}

infix fun Int.selection(list: ConstrainedList) {
    when (this) {
        single -> list.selectionMode = ListSelectionModel.SINGLE_SELECTION
        interval -> list.selectionMode = ListSelectionModel.SINGLE_INTERVAL_SELECTION
        free -> list.selectionMode = ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
        else -> throw Exception("Specify a selection mode when attempting to set it.")
    }
}

fun Array<String>.toListModel(): DefaultListModel<String> {
    val listModel = DefaultListModel<String>()
    this.forEach {listModel.addElement(it)}
    return listModel
}

fun items(vararg item: String) = options(*item)
