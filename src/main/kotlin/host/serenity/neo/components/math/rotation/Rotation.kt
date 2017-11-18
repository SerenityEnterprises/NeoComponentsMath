package host.serenity.neo.components.math.rotation

import host.serenity.neo.components.math.vector.util.magnitude


data class Rotation(val yaw: Double, val pitch: Double, val roll: Double = 0.0) {
    fun add(other: Rotation): Rotation {
        val (oY, oP, oR) = other

        return Rotation(yaw + oY, pitch + oP, roll + oR)
    }
    operator fun plus(other: Rotation) = add(other)

    fun subtract(other: Rotation): Rotation {
        val (oY, oP, oR) = other

        return Rotation(yaw - oY, pitch - oP, roll - oR)
    }
    operator fun minus(other: Rotation) = subtract(other)

    fun length() = magnitude(yaw, pitch, roll)

    fun wrapToQuadrants(referenceYaw: Double, referencePitch: Double): Rotation {
        // Since Minecraft uses -180 to 180 for angles, instead of 0 to 360, we have to do this:
        fun wrapAngleToQuadrant(angle: Double, referenceAngle: Double): Double {
            return referenceAngle + 360 * Math.floor((angle - 180) / 360) + 180
        }

        return Rotation(wrapAngleToQuadrant(yaw, referenceYaw), wrapAngleToQuadrant(pitch, referencePitch), roll)
    }

    fun shortestPath(): Rotation {
        fun getShortestAngle(targetAngle: Double): Double {
            val positive = (180 + targetAngle) % 180
            val negative = (-180 + targetAngle) % 180

            return if (Math.abs(negative) < Math.abs(positive)) negative else positive
        }

        return Rotation(getShortestAngle(yaw), getShortestAngle(pitch), getShortestAngle(roll))
    }
}
