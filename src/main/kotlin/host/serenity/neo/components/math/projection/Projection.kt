package host.serenity.neo.components.math.projection

import host.serenity.neo.components.math.rotation.Rotation
import host.serenity.neo.components.math.vector.Vector3

fun getRotationsToOffset(offset: Vector3): Rotation {
    val distance = Math.sqrt(offset.x * offset.x + offset.z * offset.z)
    val yaw = Math.toDegrees(Math.atan2(offset.z, offset.x)) - 90.0
    val pitch = -Math.toDegrees(Math.atan2(offset.y, distance))

    return Rotation(yaw, pitch)
}