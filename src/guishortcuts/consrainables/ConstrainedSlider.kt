package guishortcuts.consrainables

import java.awt.GridBagConstraints
import java.lang.Exception
import javax.swing.*
import javax.swing.event.ChangeEvent

class ConstrainedSlider(min: Int, max: Int): JSlider(min, max), Constrainable {
    override val GBC: GridBagConstraints = GridBagConstraints()

    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }

    infix fun set(to: Int) {
        value = to
    }

    infix fun label(action: Int) {
        paintLabels = action == enable
    }

    infix fun ticks(action: Int) {
        paintTicks = action == enable
    }

    infix fun set(spacing: Pair<Int, Int>) {
        majorTickSpacing = spacing.first
        minorTickSpacing = spacing.second
    }

    infix fun does(func: () -> Unit) {
        addChangeListener {
            if(!(it.source as ConstrainedSlider).valueIsAdjusting)
                func()
        }
    }

    infix fun get(kw: Int): Int {
        if(kw != selected) throw Exception("Use 'selected' to get the selected value from a slider")
        return value
    }
}

val disable = 0
val enable = 1
val selected = 2

infix fun Int.add(slider: ConstrainedSlider): ConstrainedSlider {
    return slider
}

infix fun Int.horizontal(slider: ConstrainedSlider): ConstrainedSlider {
    slider.orientation = JSlider.HORIZONTAL
    return slider
}

infix fun Int.vertical(slider: ConstrainedSlider): ConstrainedSlider {
    slider.orientation = JSlider.VERTICAL
    return slider
}

fun spacing(major: Int, minor: Int): Pair<Int, Int> {
    return Pair(major, minor)
}
