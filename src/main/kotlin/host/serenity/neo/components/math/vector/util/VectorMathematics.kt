package host.serenity.neo.components.math.vector.util

fun magnitude(x: Double, y: Double): Double {
    return Math.sqrt(x * x + y * y)
}

fun magnitude(x: Double, y: Double, z: Double): Double {
    return Math.sqrt(x * x + y * y + z * z)
}

fun magnitude(vararg values: Double): Double {
    var d = 0.0

    for (v in values) {
        d += (v * v)
    }

    return Math.sqrt(d)
}
