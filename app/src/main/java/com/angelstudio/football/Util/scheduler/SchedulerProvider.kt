package com.angelstudio.football.Util.scheduler


import io.reactivex.Scheduler

/**
 * Allows providing different types of [Scheduler]s.
 */
interface SchedulerProvider {

  fun trampoline(): Scheduler

  fun newThread(): Scheduler

  fun computation(): Scheduler

  fun io(): Scheduler

  fun ui(): Scheduler
}
