package com.example.mvpapp.scheduler

import androidx.annotation.VisibleForTesting
import io.reactivex.schedulers.Schedulers

/**
 * Created by Ahmed Abdullah on 9/21/2019.
 */
@VisibleForTesting(otherwise = VisibleForTesting.NONE)
class TestScheduler : IScheduler {

    override fun mainThread(): io.reactivex.Scheduler {
        return Schedulers.trampoline()
    }

    override fun io(): io.reactivex.Scheduler {
        return Schedulers.trampoline()
    }
}