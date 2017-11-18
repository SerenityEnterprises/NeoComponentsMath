package host.serenity.neo.components.math.vector

import host.serenity.neo.components.math.vector.util.magnitude

data class Vector3(val x: Double, val y: Double, val z: Double) {
    fun add(other: Vector3): Vector3 {
        val (oX, oY, oZ) = other

        return Vector3(x + oX, y + oY, z + oZ)
    }

    operator fun plus(other: Vector3) = add(other)

    fun subtract(other: Vector3): Vector3 {
        val (oX, oY, oZ) = other

        return Vector3(x - oX, y - oY, z - oZ)
    }

    operator fun minus(other: Vector3) = subtract(other)

    fun scale(scalar: Double) = Vector3(x * scalar, y * scalar, z * scalar)

    fun multiplyElements(multiplier: Double) = scale(multiplier)
    operator fun times(multiplier: Double) = scale(multiplier)

    fun scale(other: Vector3): Vector3 {
        val (oX, oY, oZ) = other

        return Vector3(x * oX, y * oY, z * oZ)
    }

    fun multiplyElements(other: Vector3) = scale(other)
    operator fun times(other: Vector3) = scale(other)


    // Cache the length to avoid recalculation for successive length() calls.
    private val length = magnitude(x, y, z)

    fun length() = length
    fun magnitude() = length()


    fun distance(other: Vector3): Double {
        val (oX, oY, oZ) = other

        return magnitude(x - oX, y - oY, z - oZ)
    }


    fun normalize(): Vector3 {
        if (length() == 0.0)
            return Vector3(0.0, 0.0, 0.0)

        return Vector3(x / length(), y / length(), z / length())
    }

    fun floor() = Vector3(Math.floor(x), Math.floor(y), Math.floor(z))

    fun ceil() = Vector3(Math.ceil(x), Math.ceil(y), Math.ceil(z))


    fun reverse() = Vector3(-x, -y, -z)


    fun dot(other: Vector3) = scale(other)

    fun cross(other: Vector3): Vector3 {
        val (oX, oY, oZ) = other

        return Vector3(y * oZ - z * oY, z * oX - x * oZ, x * oY - y * oX)
    }


    fun offset(x: Double, y: Double, z: Double) = Vector3(this.x + x, this.y + y, this.z + z)

    fun up(y: Double) = Vector3(x, this.y + y, z)
    fun down(y: Double) = up(-y)
}
