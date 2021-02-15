package modularization.features.onboardingtest.Base

import android.app.Application
import timber.log.Timber
/**
 * @author Anand M Joseph (anandmampuzhakal@hotmail.com)
 */
class App : Application() {
    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        lateinit var instance: App
            private set
    }
}