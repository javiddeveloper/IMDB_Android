package ir.javid.developer.imdb

import android.app.Application

import ir.javid.developer.imdb.tools.ContextModel

/**
 * Developed by javid
 */
class IMDBApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ContextModel.context = applicationContext
    }
}
