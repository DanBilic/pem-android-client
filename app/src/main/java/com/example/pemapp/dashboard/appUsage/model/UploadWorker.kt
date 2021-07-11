package com.example.pemapp.dashboard.appUsage.model

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker (appContext: Context, workerParams: WorkerParameters):
Worker(appContext, workerParams) {
    override fun doWork(): Result {

        println("WORKER WORKS!!!")
        return Result.success()
    }
}