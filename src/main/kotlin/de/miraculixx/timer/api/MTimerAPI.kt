@file:Suppress("unused")

package de.miraculixx.timer.api

import java.util.UUID
import kotlin.time.Duration

/**
 * API for the timer system.
 * Use the global INSTANCE to access the API and all functions.
 * If the INSTANCE is not set, the API is not available, please check in advance.
 */
abstract class MTimerAPI {
    companion object {
        var INSTANCE: MTimerAPI? = null
    }

    /**
     * @return The public timer running status
     */
    abstract fun getTimerStatus(): Boolean

    /**
     * @param uuid Target player [UUID]
     * @return The timer running status of the given player. Returns false if the player has no personal timer
     */
    abstract fun getTimerStatus(uuid: UUID): Boolean

    /**
     * Start the public timer
     * @return False if already running
     */
    abstract fun startTimer(): Boolean

    /**
     * Start the personal timer of the given player
     * @param uuid Target player [UUID]
     * @return False if already running
     */
    abstract fun startTimer(uuid: UUID): Boolean

    /**
     * Stop the public timer
     * @return False if already stopped
     */
    abstract fun stopTimer(): Boolean

    /**
     * Stop the personal timer of the given player
     * @return False if already stopped
     */
    abstract fun stopTimer(uuid: UUID): Boolean

    /**
     * Sets a custom time for the global timer
     * @param duration new time
     */
    abstract fun setTime(duration: Duration)

    /**
     * Sets a custom time for a personal timer
     * @param uuid Target player [UUID]
     * @param duration new time
     */
    abstract fun setTime(uuid: UUID, duration: Duration): Boolean

    /**
     * Add a new logic that is called on each tick (not seconds) as long as the public timer is running
     * @param onTick Tick logic extending the current time as a [Duration]
     */
    abstract fun addTickLogic(onTick: (Duration) -> Unit)

    /**
     * Add a new logic that is called on public timer stopping
     * @param onStop Stop logic
     */
    abstract fun onStopLogic(onStop: () -> Unit)

    /**
     * Add a new logic that is called on public timer starting
     * @param onStart Start logic
     */
    abstract fun onStartLogic(onStart: () -> Unit)
}