package guishortcuts.consrainables

import java.awt.GridBagConstraints

/**
 * Get a GridBagConstraints with all supplied constraints.
 * Weights are set as Doubles.
 */
fun constraints(col: Int, row: Int, width: Int, height: Int, colweight: Double, rowweight: Double): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridx = col
    GBC.gridy = row
    GBC.gridwidth = width
    GBC.gridheight = height
    GBC.weightx = colweight
    GBC.weighty = rowweight

    return GBC
}

/**
 * Get a GridBagConstraints with all supplied constraints.
 * Weights are set as Ints.
 */
fun constraints(col: Int, row: Int, width: Int, height: Int, colweight: Int, rowweight: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridx = col
    GBC.gridy = row
    GBC.gridwidth = width
    GBC.gridheight = height
    GBC.weightx = colweight.toDouble()
    GBC.weighty = rowweight.toDouble()

    return GBC
}

/**
 * Get a GridBagConstraints with the supplied coordinates and size.
 */
fun constraints(col: Int, row: Int, width: Int, height: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridx = col
    GBC.gridy = row
    GBC.gridwidth = width
    GBC.gridheight = height

    return GBC
}

/**
 * Get a GridBagConstraints with the supplied coordinates set.
 */
fun coordinates(col: Int, row: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridx = col
    GBC.gridy = row

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

/**
 * Alias of coordinates.
 */
fun coords(col: Int, row: Int): GridBagConstraints = coordinates(col, row)

/**
 * Get a GridBagConstraints with the supplied cell width & height set.
 */
fun cells(width: Int, height: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridwidth = width
    GBC.gridheight = height

    return GBC
}

/**
 * Get a GridBagConstraints with the supplied weights set.
 * Weights are set as Doubles.
 */
fun weights(colweight: Double, rowweight: Double): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.weightx = colweight
    GBC.weighty = rowweight

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

/**
 * Get a GridBagConstraints with the supplied weights set.
 * Weights are set as Ints.
 */
fun weights(colweight: Int, rowweight: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.weightx = colweight.toDouble()
    GBC.weighty = rowweight.toDouble()

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

/**
 * Get a GridBagConstraints with the supplied column set.
 */
fun col(col: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridx = col

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

/**
 * Get a GridBagConstraints with the supplied row set.
 */
fun row(row: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridy = row

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

/**
 * Get a GridBagConstraints with the supplied column weight set.
 * Weight set as Int.
 */
fun colweight(colweight: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.weightx = colweight.toDouble()

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

/**
 * Get a GridBagConstraints with the supplied row weight set.
 * Weight set as Int.
 */
fun rowweight(rowweight: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.weighty = rowweight.toDouble()

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

/**
 * Get a GridBagConstraints with the supplied column weight set.
 * Weight set as Double.
 */
fun colweight(colweight: Double): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.weightx = colweight

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

/**
 *
 * Get a GridBagConstraints with the supplied row weight set.
 * Weight set as Double.
 */
fun rowweight(rowweight: Double): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.weighty = rowweight

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}
