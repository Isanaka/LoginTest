package com.isanaka.myapplication.utils

import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.*
import com.isanaka.myapplication.R


class SpannableHelper {
    companion  object SpannableHelper {
        fun buildFormattedText(fullString: String, clickable: String, color: Int) =

            fullString
                .indexOf(clickable)
                .takeIf { it >= 0 }
                ?.let { createSpans(fullString, color, start = it, end = it + clickable.length) }


        private fun createSpans(fullString: String,  color: Int,start: Int, end: Int) =
            SpannableStringBuilder(fullString).apply {
                setSpans(color, setSpan = { setSpan(it, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) })
            }

        private inline fun setSpans(color:Int, setSpan: (span: Any) -> Unit) {
            setSpan(URLSpan("https://electricflamingo.co.nz/"))
            setSpan(ForegroundColorSpan(color))
        }
    }
}