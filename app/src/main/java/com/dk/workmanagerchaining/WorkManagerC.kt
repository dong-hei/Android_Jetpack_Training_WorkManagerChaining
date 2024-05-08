package com.dk.workmanagerchaining

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class WorkManagerC(context : Context, workerParameters: WorkerParameters ) : Worker(context, workerParameters) {
    override fun doWork(): Result {
        for (i in 30..50) {
            sleep(1000)
            Log.d("WorkManagerC", i.toString())
        }
        return Result.success()
    }
    
}