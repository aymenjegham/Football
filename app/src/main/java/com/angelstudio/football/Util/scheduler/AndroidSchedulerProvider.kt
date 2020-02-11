package com.angelstudio.football.Util.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject



class AndroidSchedulerProvider
@Inject
constructor() : SchedulerProvider {

  override fun trampoline(): Scheduler {
    return Schedulers.trampoline()
  }

  override fun newThread(): Scheduler {
    return Schedulers.newThread()
  }

  override fun computation(): Scheduler {
    return Schedulers.computation()
  }

  override fun io(): Scheduler {
    return Schedulers.io()
  }

  override fun ui(): Scheduler {
    return AndroidSchedulers.mainThread()
  }
}
