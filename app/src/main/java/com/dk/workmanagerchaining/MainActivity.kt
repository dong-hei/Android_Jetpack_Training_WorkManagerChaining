package com.dk.workmanagerchaining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

/**
 * WorkManager Chaining
 *
 * A -> 순서 상관 없이 실행되도 괜찮
 * B -> 순서 상관 없이 실행되도 괜찮
 * C -> 무조건 A / B 모두 실행된 뒤에 실행되어야 한다.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wmA = OneTimeWorkRequestBuilder<WorkManagerA>().build()
        val wmB = OneTimeWorkRequestBuilder<WorkManagerB>().build()
        val wmC = OneTimeWorkRequestBuilder<WorkManagerC>().build()

//        WorkManager.getInstance(this).enqueue(wmA)
//        WorkManager.getInstance(this).enqueue(wmB)
//        WorkManager.getInstance(this).enqueue(wmC)

        //Chaining
        WorkManager.getInstance(this)
            .beginWith(listOf(wmA, wmB))
            .then(wmC)
            .enqueue()
    }
}