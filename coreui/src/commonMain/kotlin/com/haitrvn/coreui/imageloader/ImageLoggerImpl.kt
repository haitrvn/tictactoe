package com.haitrvn.coreui.imageloader

import coil3.util.Logger
import com.haitrvn.core.log.Log

class ImageLoggerImpl : Logger {
    override var minLevel: Logger.Level = Logger.Level.Debug

    override fun log(
        tag: String,
        level: Logger.Level,
        message: String?,
        throwable: Throwable?
    ) {
        val messageElseDefault = message ?: throwable?.message ?: ""
        when (level) {
            Logger.Level.Debug -> Log.d(tag, messageElseDefault)
            Logger.Level.Error -> Log.e(tag, messageElseDefault, throwable)
            Logger.Level.Info -> Log.i(tag, messageElseDefault)
            Logger.Level.Verbose -> Log.d(tag, messageElseDefault)
            Logger.Level.Warn -> Log.w(tag, messageElseDefault)
        }
    }
}