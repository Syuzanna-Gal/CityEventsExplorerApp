package com.example.coreui.extensions

import android.annotation.SuppressLint
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit


@JvmInline
value class Minutes(val minutes: Long)


fun Minutes.formatToHHMM() =
    String.format("%02d:%02d", TimeUnit.MINUTES.toHours(minutes), minutes % 60)


@JvmInline
value class Millis(val millis: Long)






