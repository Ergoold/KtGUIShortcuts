package guishortcuts.consrainables

import guishortcuts.*
import java.awt.GridBagConstraints
import java.util.*
import javax.swing.*

/**
 * A slider with GridBagConstraints.
 */
class ConstrainedSlider(min: Int, max: Int): JSlider(min, max), Constrainable {
    /**
     * This slider's GridBagConstraints.
     */
    override val GBC: GridBagConstraints = GridBagConstraints()
    
    /**
     * Add this slider to a frame.
     *
     * @param frame the frame this slider will be added to.
     */
    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
    
    /**
     * Set this slider to a certain value.
     *
     * @param to the value this slider will be set to.
     */
    infix fun set(to: Int) {
        value = to
    }
    
    /**
     * Enable or disable this slider's labels.
     * The parameter should be equal to the variable enable to enable labels and anything else to disable labels.
     *
     * @param action whether or not to enable the labels.
     *
     * @throws IllegalKeywordException
     */
    infix fun label(action: Int) {
        if(action != enable && action != disable) throw IllegalKeywordException("Use 'enable' or 'disable' to enable or disable slider labels.")
        paintLabels = action == enable
    }
    
    /**
     * Enable or disable this slider's tick marks.
     * The parameter should be equal to the variable enable to enable tick marks and anything else to disable tick marks.
     *
     * @param action whether or not to enable the tick marks.
     *
     * @throws IllegalKeywordException
     */
    infix fun ticks(action: Int) {
        if(action != enable && action != disable) throw IllegalKeywordException("Use 'enable' or 'disable' to enable or disable slider tick marks.")
        paintTicks = action == enable
    }
    
    /**
     * Set this slider's tick spacing.
     *
     * @param spacing a pair where first is the major tick spacing and second is the minor tick spacing.
     */
    infix fun set(spacing: Pair<Int, Int>) {
        majorTickSpacing = spacing.first
        minorTickSpacing = spacing.second
    }
    
    /**
     * Add an action listener to this slider.
     *
     * @param func the function to execute when this slider's value is changed.
     */
    infix fun does(func: () -> Unit) {
        addChangeListener {
            if(!(it.source as ConstrainedSlider).valueIsAdjusting)
                func()
        }
    }
    
    /**
     * Get the slider's current selected value.
     *
     * @param kw must be equal to the variable selected.
     *
     * @return the slider's current selected value.
     *
     * @throws IllegalKeywordException
     */
    infix fun get(kw: Int): Int {
        if(kw != selected) throw IllegalKeywordException("Use 'selected' to get the selected value from a slider")
        return value
    }
    
    /**
     * Put labels on this slider.
     * The labels will not show unless they are enabled.
     *
     * @param labels the labels to put on this slider.
     */
    infix fun put(labels: Array<String>) {
        val diff = if(labels.size > 1) (maximum - minimum) / (labels.size - 1) else 0

        val dict = Hashtable<Int, JLabel>()
        for(i in 0 until labels.size)
            dict.put(minimum + diff * i, JLabel(labels[i]))

        labelTable = dict
    }
}

/**
 * This function is purely for cosmetic purposes.
 *
 * @param slider the slider to return.
 *
 * @return the slider it was gives.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.add(slider: ConstrainedSlider): ConstrainedSlider {
    if(this != window) throw IllegalKeywordException("Use 'window' when attempting to add a component to a frame")
    return slider
}

/**
 * Make a slider horizontal.
 *
 * @param slider the slider to make horizontal.
 *
 * @return the slider it was given.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.horizontal(slider: ConstrainedSlider): ConstrainedSlider {
    if(this != make) throw IllegalKeywordException("Use 'make' when attempting to change slider orientation")
    slider.orientation = JSlider.HORIZONTAL
    return slider
}

/**
 * Make a slider vertical.
 *
 * @param slider the slider to make vertical.
 *
 * @return the slider it was given.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.vertical(slider: ConstrainedSlider): ConstrainedSlider {
    if(this != make) throw IllegalKeywordException("Use 'make' when attempting to change slider orientation")
    slider.orientation = JSlider.VERTICAL
    return slider
}

/**
 * Turn to Ints into a Pair<Int, Int>.
 *
 * @param major the first Int.
 * @param minor the second Int.
 *
 * @return a pair containing major and minor.
 */
fun spacing(major: Int, minor: Int): Pair<Int, Int> {
    return Pair(major, minor)
}

/**
 * Turn a String vararg into an Array<String>.
 *
 * @param labels strings to put into the array.
 *
 * @return an array containing all the strings in labels.
 */
fun labels(vararg labels: String): Array<String> {
    return arrayOf(*labels)
}

/**
 * Create a slider.
 * Int must be equal to the variable create.
 *
 * @param min the minimum value of the spinner.
 * @param max the maximum value of the spinner.
 *
 * @return a ConstrainedSlider with the supplied minimum and maximum.
 *
 * @throws IllegalKeywordException
 */
fun slider(min: Int, max: Int): ConstrainedSlider {
    val slider = ConstrainedSlider(min, max)
    slider.majorTickSpacing = max - min
    slider.minorTickSpacing = (max - min) / 2
    slider.paintTicks = true
    slider.paintLabels = true
    return slider
}
