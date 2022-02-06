package com.nech9ev.tinkofftestapp

sealed class ActionState<out T>(
    open val data: T? = null,
    open val message: String? = null
) {
    class Idle<out T>(data: T? = null) : ActionState<T>(data)

    class Loading<out T>(data: T? = null) : ActionState<T>(data)

    class Success<out T>(override val data: T) : ActionState<T>(data)

    class Error<out T>(data: T? = null, message: String) : ActionState<T>(data, message)
}
