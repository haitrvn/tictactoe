package com.haitrvn.core

import co.touchlab.kermit.Logger

class KermitLogger(
    private val defaultTag: String = "CookApp",
    private val logger: Logger = Logger
) : AppLogger {

    override fun d(message: String) = d(defaultTag, message)
    override fun d(tag: String, message: String) {
        logger.withTag(tag).d { message }
    }

    override fun i(message: String) = i(defaultTag, message)
    override fun i(tag: String, message: String) {
        logger.withTag(tag).i { message }
    }

    override fun w(message: String) = w(defaultTag, message)
    override fun w(tag: String, message: String) {
        logger.withTag(tag).w { message }
    }

    override fun e(message: String, throwable: Throwable?) = e(defaultTag, message, throwable)
    override fun e(tag: String, message: String, throwable: Throwable?) {
        logger.withTag(tag).e(throwable) { message }
    }
}