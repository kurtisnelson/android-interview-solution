package com.thisisnotajoke.interview

import android.app.Application
import com.thisisnotajoke.interview.di.AppGraph
import dev.zacsweers.metro.createGraph
import dev.zacsweers.metrox.android.MetroAppComponentProviders
import dev.zacsweers.metrox.android.MetroApplication

class MainApplication : Application(), MetroApplication {
    private val appGraph by lazy { createGraph<AppGraph>() }
    override val appComponentProviders: MetroAppComponentProviders
        get() = appGraph
}
